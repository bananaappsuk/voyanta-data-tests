package com.voyanta.data;

import com.voyanta.data.datamodel.DataSheetsView;
import com.voyanta.data.datamodel.DatabaseView;
import com.voyanta.data.pageobject.voyanta.pageobject.VUtils;
import com.voyanta.data.utils.DBUtils;
import com.voyanta.data.utils.PropertiesLoader;
import com.voyanta.data.utils.VHashMap;
import com.voyanta.data.utils.utils.FileSearch;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sriramangajala on 08/07/2014.
 */
public class DataModelSteps {
    String boxFolder ;
    String testDataFolder ;
    String SQLFolder;
    String dataSheet;
    String exportExpectedFolder;
    String exportActualFolder;
    String editedTestDataFolder;
    List<VHashMap> dataBaseData;
    List<VHashMap> excelSheetData;
    Logger LOGGER = Logger.getLogger(DataModelSteps.class);
    List<HashMap> expExportData;
    List<HashMap> actualExportData;
    File excelFolder;

    DataSheetsView dataSheetsView ;

    DatabaseView databaseView ;
    private String xml;
    private String xml1;
    private String primaryKey;

    @Before
    public void before()
    {
        if(System.getProperty("os.name").toLowerCase().contains("mac"))
        {
            boxFolder = PropertiesLoader.getProperty("mac_boxFolder");
            testDataFolder = PropertiesLoader.getProperty("mac_testDataFolder");
            SQLFolder = PropertiesLoader.getProperty("mac_SQLFolder");
            editedTestDataFolder = PropertiesLoader.getProperty("mac_editedTestDataFolder");
        }
        else
        {
            boxFolder = PropertiesLoader.getProperty("windows_boxFolder");
            testDataFolder = PropertiesLoader.getProperty("windows_testDataFolder");
            SQLFolder = PropertiesLoader.getProperty("windows_SQLFolder");
            editedTestDataFolder = PropertiesLoader.getProperty("windows_editedTestDataFolder");
        }
        dataSheet=null;
        dataBaseData=null;
        excelSheetData=null;
        dataSheetsView = new DataSheetsView();
        databaseView = new DatabaseView();
    }

    @Given("^The DataSheet exists in the QA Box with name '(.*)'$")
    public void the_DataSheet_exits_in_the_QA_Box_with_name(String datasheet) throws Throwable {
        this.dataSheet = datasheet;
        LOGGER.info("Searching for the file :"+datasheet+" in folder :"+boxFolder+testDataFolder);
        excelFolder = FileSearch.findFile(datasheet, new File(boxFolder+testDataFolder));
        Assert.assertTrue(excelFolder.getAbsolutePath().contains(datasheet));
    }
    @Given("^The Edited DataSheet exists in the QA Box with name '(.*)'$")
    public void the_Edited_DataSheet_exits_in_the_QA_Box_with_name(String datasheet) throws Throwable {
        this.dataSheet = datasheet;
        LOGGER.info("Searching for the file :"+datasheet+" in folder :"+boxFolder+editedTestDataFolder);
        excelFolder = FileSearch.findFile(datasheet, new File(boxFolder+editedTestDataFolder));
        Assert.assertTrue(excelFolder.getAbsolutePath().contains(datasheet));
    }

    @Given("^the data from DST is collected and saved as expected data$")
    public void the_datasheet_data_is_saved() throws Throwable {
        LOGGER.info("Collecting data from spreadsheet...");
        excelSheetData = dataSheetsView.getExcelFileDataInHashMap(boxFolder+testDataFolder,dataSheet,"0");
        Assert.assertTrue("Checking if atleast one row is returned from excel sheet",excelSheetData.size()>0);
    }

    @Given("^the Edited data from DST is collected and saved as expected data$")
    public void the_edited_datasheet_data_is_saved() throws Throwable {
        LOGGER.info("Collecting data from spreadsheet...");
        excelSheetData = dataSheetsView.getExcelFileDataInHashMap(boxFolder+editedTestDataFolder,dataSheet,"0");
        Assert.assertTrue("Checking if atleast one row is returned from excel sheet",excelSheetData.size()>0);
    }

    @When("^data is collected from database with query '(.*)'$")
    public void data_should_be_saved_in_database(String SQLQueryName) throws Throwable {
         String FileName = boxFolder+"/"+SQLFolder+"/"+SQLQueryName;
         dataBaseData = databaseView.getDataBaseRecordsFromFile(FileName,dataSheetsView.getNumberOfRecordsInExcel());
         Assert.assertTrue("Checking if atleast one row is returned from database",dataBaseData.size()>0);
    }

    @Then("^the uploaded data from DST should match with database tables$")
    public void data_in_all_the_cells_should_match() throws Throwable {
      data_in_all_the_cells_should_matchwith_keys("");

    }

    @Then("^the uploaded data from DST should match with database tables sorted with '(.*)'$")
    public void data_in_all_the_cells_should_matchwith_keys(String keys) throws Throwable {

        String[] modifiedkeys = VUtils.humaniseKeys(keys);
        excelSheetData = ValidationUtils.lowerCaseColumnsAndRemoveSpaces(excelSheetData);
        dataBaseData = ValidationUtils.lowerCaseColumnsAndRemoveSpaces(dataBaseData);
        excelSheetData=VXMLUtils.sortData(excelSheetData,modifiedkeys);
        dataBaseData=VXMLUtils.sortData(dataBaseData,modifiedkeys);
        ValidationUtils.compareColumnHeaders(excelSheetData,dataBaseData,modifiedkeys);

    }

    @When("^an additional column '(.*)' is mapped with '(.*)'$")
    public void add_additional_column(String additionalColumn,String existingColumn)
    {
        excelSheetData = dataSheetsView.copyDataToAdditionalColumn(excelSheetData,additionalColumn,existingColumn);
    }
//----------------------------------------------------------------------//
    @Given("^a file with name '(.*)' is existing with expected xml data$")
    public void a_file_with_name_existing(String fileName) throws Throwable {
        LOGGER.info("Checking for file with name :"+fileName);
        xml = DBUtils.loadSQLFile(boxFolder+exportExpectedFolder+fileName);
        Assert.assertNotNull(xml);

    }

    @Given("^a file with name '(.*)' is existing with actual xml data$")
    public void a_file_with_name_Actual_File_folder(String fileName) throws Throwable {
        LOGGER.info("Checking for file with name :"+fileName);
        xml1 = DBUtils.loadSQLFile(boxFolder + exportActualFolder + fileName);
        Assert.assertNotNull(xml1);
    }

    @When("^the data is loaded from actual file with root '(.*)', header '(.*)' and primary key '(.*)'$")
    public void the_data_is_loaded_from_expected_file(String root, String header, String primaryKey,String secondaryKey) throws Throwable {
        expExportData = VXMLUtils.sortData(VXMLUtils.getXMLData(xml, root, header), primaryKey,secondaryKey);
    }

    @When("^the data is loaded from expected file with root '(.*)', header '(.*)' and primary key '(.*)'$")
    public void the_data_is_loaded_from_actual_file(String root, String header, String primaryKey,String secondaryKey) throws Throwable {
        actualExportData = VXMLUtils.sortData(VXMLUtils.getXMLData(xml1, root, header),primaryKey,secondaryKey);
    }


    @Then("^both files should have same set of data with primary key '(.*)'$")
    public void both_files_should_have_same_set_of_data(String key) throws Throwable {
        ValidationUtils.compareTwoThings(expExportData,actualExportData,key);
    }
    
    @Given("all the files are saved under '(.*)' folder")
    public void all_the_files_are_saved_under_folder(String folderLocation){
        if(System.getProperty("os.name").toLowerCase().contains("mac"))
        {
          if(folderLocation.equalsIgnoreCase("StandartExport")){
            exportExpectedFolder=PropertiesLoader.getProperty("mac_ExportExpectedFolder");
            exportActualFolder =PropertiesLoader.getProperty("mac_ExportActualFolder");}
          else 
          {
              exportExpectedFolder=PropertiesLoader.getProperty("mac_ExportExpectedTaliance");
              exportActualFolder =PropertiesLoader.getProperty("mac_ExportActualTaliance");
          }
        }
        else
        {
            if(folderLocation.equals("StandartExport")){
                exportExpectedFolder=PropertiesLoader.getProperty("windows_ExportExpectedFolder");
                exportActualFolder =PropertiesLoader.getProperty("windows_ExportActualFolder");}
            else{
            exportExpectedFolder=PropertiesLoader.getProperty("windows_TalianceExpected");
            exportActualFolder =PropertiesLoader.getProperty("windows_TalianceActual");
            }
        }
    }


    @Given("^an exported file exists with name '(.*)'$")
    public void an_exported_file_exists_with_name(String file) throws Throwable {
        a_file_with_name_existing(file);
        a_file_with_name_Actual_File_folder(file);
    }

    @Given("^comparing between actual and expected XML files should be equal with name '(.*)'$")
    public void compare_XMLs(String fileName)
    {
        if(System.getProperty("os.name").toLowerCase().contains("mac"))
        {
                exportExpectedFolder=System.getProperty("user.home")+PropertiesLoader.getProperty("mac_augus_exp");
                exportActualFolder =System.getProperty("user.home")+PropertiesLoader.getProperty("mac_augus_act");
        }
        else
        {
                exportExpectedFolder=System.getProperty("user.home")+PropertiesLoader.getProperty("win_augus_exp");
                exportActualFolder =System.getProperty("user.home")+PropertiesLoader.getProperty("win_augus_act");
       }

        ValidationUtils.compareXML(exportExpectedFolder+"//"+fileName,exportActualFolder+"//"+fileName);


    }



    @Given("^data is loaded with entity name '(.*)' with primary key '(.*)' and '(.*)'$")
    public void data_is_loaded_with_entity_name__with_primary_key_AssetReference(String entity,String primaryKey,String secondaryKey) throws Throwable {
        this.primaryKey = primaryKey;
        the_data_is_loaded_from_expected_file(entity + "_EXTRACT", entity, primaryKey,secondaryKey);
        the_data_is_loaded_from_actual_file(entity + "_EXTRACT", entity, primaryKey,secondaryKey);

    }

    @Then("^both files should have same set of data$")
    public void both_files_should_have_same_set_of_data() throws Throwable {
        both_files_should_have_same_set_of_data(primaryKey);

    }

    @And("^ignore the validation taking today's value for '(.*)'$")
    public void ignore_the_validation_taking_today_s_value_for(String columns) throws Throwable {
        String replaceValue;
        if(!columns.equals("")) {
            for (String column:columns.split(","))
            {
                replaceValue = (new SimpleDateFormat("yyyy-MM-dd")).format((new Date()));
                expExportData=VXMLUtils.replaceValueForColumn(expExportData,column.trim(),replaceValue);
            }
        }
    }

    @After()
    public static void tearDown(Scenario scenario){

        if(scenario.isFailed())
        {
            VUtils.captureScreen(scenario.getName());
        }
    }

    @Given("^the data is deleted from database$")
    public void the_data_is_deleted_from_database() throws Throwable {
        System.out.print(databaseView.executeMultipleDBQuerysFromFile(boxFolder+SQLFolder+"DeleteAll.sql",10));
    }
}
