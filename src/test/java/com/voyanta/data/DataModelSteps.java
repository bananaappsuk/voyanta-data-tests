package com.voyanta.data;

import com.voyanta.data.datamodel.DataSheetsView;
import com.voyanta.data.datamodel.DatabaseView;
import com.voyanta.data.utils.PropertiesLoader;
import com.voyanta.data.utils.VHashMap;
import com.voyanta.data.utils.utils.FileSearch;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;


import java.io.File;
import java.util.List;

/**
 * Created by sriramangajala on 08/07/2014.
 */
public class DataModelSteps {
    String boxFolder ;
    String testDataFolder ;
    String dataSheet;
    List<VHashMap> dataBaseData;
    List<VHashMap> excelSheetData;
    Logger LOGGER = Logger.getLogger(DataModelSteps.class);

    File excelFolder;

    DataSheetsView dataSheetsView ;

    DatabaseView databaseView ;

    @Before
    public void before()
    {
        if(System.getProperty("os.name").toLowerCase().contains("mac"))
        {
            boxFolder = PropertiesLoader.getProperty("mac_boxFolder");
            testDataFolder = PropertiesLoader.getProperty("mac_testDataFolder");
        }
        else
        {
            boxFolder = PropertiesLoader.getProperty("windows_boxFolder");
            testDataFolder = PropertiesLoader.getProperty("windows_testDataFolder");
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
        LOGGER.info("Searching for the file :"+datasheet+" in folder :"+boxFolder+"/"+testDataFolder);
        excelFolder = FileSearch.findFile(datasheet, new File(boxFolder+"/"+testDataFolder));
        Assert.assertTrue(excelFolder.getAbsolutePath().contains(datasheet));
    }

    @Given("^the datasheet data is saved$")
    public void the_datasheet_data_is_saved() throws Throwable {
        LOGGER.info("Collecting data from spreadsheet...");
        excelSheetData = dataSheetsView.getExcelFileDataInHashMap(boxFolder+"/"+testDataFolder+"/",dataSheet,"0");
        Assert.assertTrue("Checking if atleast one row is returned from excel sheet",excelSheetData.size()>0);
    }


    @Then("^data should be saved in database table with query name '(.*)'$")
    public void data_should_be_saved_in_database(String SQLQueryName) throws Throwable {
         dataBaseData = databaseView.getDataBaseRecordsInStringWithLimit(SQLQueryName,dataSheetsView.getNumberOfRecordsInExcel());
         Assert.assertTrue("Checking if atleast one row is returned from database",dataBaseData.size()>0);
    }

    @Then("^data in all the cells should match$")
    public void data_in_all_the_cells_should_match() throws Throwable {
        excelSheetData = ValidationUtils.lowerCaseColumnsAndRemoveSpaces(excelSheetData);
        dataBaseData = ValidationUtils.lowerCaseColumnsAndRemoveSpaces(dataBaseData);

        ValidationUtils.compareColumnHeaders(excelSheetData,dataBaseData);

    }
}
