package com.voyanta.data;

import com.voyanta.data.datamodel.DataSheetsView;
import com.voyanta.data.datamodel.DatabaseView;
import com.voyanta.data.utils.DBUtils;
import com.voyanta.data.utils.PropertiesLoader;
import com.voyanta.data.utils.VHashMap;
import com.voyanta.data.utils.utils.FileSearch;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.FeatureRunner;
import org.apache.log4j.Logger;
import org.junit.Assert;


import java.io.File;
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
            exportExpectedFolder=PropertiesLoader.getProperty("mac_ExportExpectedFolder");
            exportActualFolder =PropertiesLoader.getProperty("mac_ExportActualFolder");
        }
        else
        {
            boxFolder = PropertiesLoader.getProperty("windows_boxFolder");
            testDataFolder = PropertiesLoader.getProperty("windows_testDataFolder");
            SQLFolder = PropertiesLoader.getProperty("windows_SQLFolder");
            exportExpectedFolder=PropertiesLoader.getProperty("mac_ExportExpectedFolder");
            exportActualFolder =PropertiesLoader.getProperty("mac_ExportActualFolder");
        }
        dataSheet=null;
        dataBaseData=null;
        excelSheetData=null;
        dataSheetsView = new DataSheetsView();
        databaseView = new DatabaseView();
    }

    @Given("^The DataSheet exits in the QA Box with name '(.*)'$")
    public void the_DataSheet_exits_in_the_QA_Box_with_name(String datasheet) throws Throwable {
        this.dataSheet = datasheet;
        LOGGER.info("Searching for the file :"+datasheet+" in folder :"+boxFolder+testDataFolder);
        excelFolder = FileSearch.findFile(datasheet, new File(boxFolder+testDataFolder));
        Assert.assertTrue(excelFolder.getAbsolutePath().contains(datasheet));
    }

    @Given("^the datasheet data is saved$")
    public void the_datasheet_data_is_saved() throws Throwable {
        LOGGER.info("Collecting data from spreadsheet...");
        excelSheetData = dataSheetsView.getExcelFileDataInHashMap(boxFolder+testDataFolder,dataSheet,"0");
        Assert.assertTrue("Checking if atleast one row is returned from excel sheet",excelSheetData.size()>0);
    }


    @Then("^data should be saved in database table with query name '(.*)'$")
    public void data_should_be_saved_in_database(String SQLQueryName) throws Throwable {
         String FileName = boxFolder+"/"+SQLFolder+"/"+SQLQueryName;
         dataBaseData = databaseView.getDataBaseRecordsFromFile(FileName,dataSheetsView.getNumberOfRecordsInExcel());
         Assert.assertTrue("Checking if atleast one row is returned from database",dataBaseData.size()>0);
    }

    @Then("^data in all the cells should match$")
    public void data_in_all_the_cells_should_match() throws Throwable {
        excelSheetData = ValidationUtils.lowerCaseColumnsAndRemoveSpaces(excelSheetData);
        dataBaseData = ValidationUtils.lowerCaseColumnsAndRemoveSpaces(dataBaseData);

        ValidationUtils.compareColumnHeaders(excelSheetData,dataBaseData);

    }

    @When("^an addition column '(.*)' is mapped with '(.*)'$")
    public void add_additional_column(String additionalColumn,String existingColumn)
    {
        excelSheetData = dataSheetsView.copyDataToAdditionalColumn(excelSheetData,additionalColumn,existingColumn);
    }
//----------------------------------------------------------------------//
    @Given("^a file with name '(.*)' is existing with expected xml data$")
    public void a_file_with_name_existing(String fileName) throws Throwable {
        xml = DBUtils.loadSQLFile(boxFolder+exportExpectedFolder+fileName);
        Assert.assertNotNull(xml);

    }

    @Given("^a file with name '(.*)' is existing with actual xml data$")
    public void a_file_with_name_Actual_File_folder(String fileName) throws Throwable {
        xml1 = DBUtils.loadSQLFile(boxFolder + exportActualFolder + fileName);
        Assert.assertNotNull(xml1);
    }

    @When("^the data is loaded from actual file with root '(.*)', header '(.*)' and primary key '(.*)'$")
    public void the_data_is_loaded_from_actual_file(String root,String header,String primaryKey) throws Throwable {
        expExportData = VXMLUtils.sortData(VXMLUtils.getXMLData(xml, root, header), primaryKey);
    }

    @When("^the data is loaded from expected file with root '(.*)', header '(.*)' and primary key '(.*)'$")
    public void the_data_is_loaded_from_expected_file(String root,String header,String primaryKey) throws Throwable {
        actualExportData = VXMLUtils.sortData(VXMLUtils.getXMLData(xml1, root, header),primaryKey);
    }


    @Then("^both files should have same set of data with primary key '(.*)'$")
    public void both_files_should_have_same_set_of_data(String key) throws Throwable {
        ValidationUtils.compareTwoThings(expExportData,actualExportData,key);
    }

    @Given("^an exported file exists with name '(.*)'$")
    public void an_exported_file_exists_with_name(String file) throws Throwable {
        a_file_with_name_existing(file);
        a_file_with_name_Actual_File_folder(file);
    }



    @Given("^data is loaded with entity name '(.*)' with primary key '(.*)'$")
    public void data_is_loaded_with_entity_name__with_primary_key_AssetReference(String entity,String primaryKey) throws Throwable {
        this.primaryKey = primaryKey;
        the_data_is_loaded_from_actual_file(entity+"_EXTRACT",entity,primaryKey);
        the_data_is_loaded_from_expected_file(entity+"_EXTRACT",entity,primaryKey);

    }

    @Then("^both files should have same set of data$")
    public void both_files_should_have_same_set_of_data() throws Throwable {
        both_files_should_have_same_set_of_data(primaryKey);

    }
}
