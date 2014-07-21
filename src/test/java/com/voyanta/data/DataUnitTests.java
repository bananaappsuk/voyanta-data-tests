package com.voyanta.data;



import com.voyanta.data.datamodel.DataSheetsView;
import com.voyanta.data.datamodel.DatabaseView;
import com.voyanta.data.datamodel.dbtables.loadDBRecords;
import com.voyanta.data.utils.DBUtils;
import com.voyanta.data.utils.DataSheetUtil;
import com.voyanta.data.utils.PropertiesLoader;
import com.voyanta.data.utils.VHashMap;
import com.voyanta.data.utils.utils.FileSearch;
import cucumber.deps.com.thoughtworks.xstream.XStream;
import cucumber.deps.com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


/**
 * Created by sriramangajala on 30/06/2014.
 */
public class DataUnitTests {
    static Logger LOGGER = Logger.getLogger(DBUtils.class);

    Properties prop;
    String strDataSheetLocation = "src/main/resources/framework.properties";

    @Before
    public void start()
    {
        prop = new Properties();
        FileInputStream input = null;
        try {
            input = new FileInputStream(strDataSheetLocation);
       //     System.out.println(input);
            prop.load(input);
         //   System.out.print(prop.getProperty("TEST_FILE_NAME"));
//            , "firefox"));
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void uploadDataTest()
    {
        DataSheetUtil dataSheetUtil = new DataSheetUtil();
        List<VHashMap> data = dataSheetUtil.getTestDataFromExcel(prop.getProperty("TEST_FOLDER_NAME"),prop.getProperty("TEST_FILE_NAME"),prop.getProperty("TEST_SHEET_NAME"));
        Assert.assertTrue(0<data.size());

    }

    @Test
    public void testDataModel()
    {
        DataSheetsView dataSheetsView = new DataSheetsView();
        Assert.assertTrue(0<dataSheetsView.getExcelFileDataInHashMap(prop.getProperty("TEST_FOLDER_NAME"),prop.getProperty("TEST_FILE_NAME"),prop.getProperty("TEST_SHEET_NAME")).size());

    }

    @Test
    public void dataBaseUnittest() throws SQLException {
        String SQL = ("SELECT \n" +
                "\t\tActive,\n" +
                "\t\tChartOfAccount,\n" +
                "\t\tAccountCategoryKey,\n" +
                "\t\tAccountNumberReference,\n" +
                "\t\tAccountName,\n" +
                "\t\tAccountDescription,\n" +
                "\t\tAccountSubcategoryKey,\n" +
                "\t\tSubAccountNumberReference,\n" +
                "\t\tSubAccountName,\n" +
                "\t\tSubAccountNumberDescription\n" +
                "\n" +
                "\t\t\n" +
                " FROM dbolive.Account LIMIT 0,10;");
        loadDBRecords loadDBRecords = new loadDBRecords();
        Assert.assertTrue("Checking the connectivity to datbase",0 < loadDBRecords.loadRecords(prop.getProperty("dbuserName"), prop.getProperty("dbpassword"), prop.getProperty("url"),SQL).size());

    }

    @Test
    public void loadDatabaseViewData()
    {
        DatabaseView databaseView = new DatabaseView();
        Assert.assertTrue("Checking atleast 1 record in DB from the SQL loaded from enums",0 < databaseView.getDataBaseRecords("BUILDING.sql").size());
    }

    @Test
    public void filePathTest()
    {
        File file = FileSearch.findFile("Building.xlsx", new File("/Users/sriramangajala/Box Sync/QA/Automation Test/DataSubmission/Test Data/editedData"));
        Assert.assertTrue("Checking the file is loaded from local system",file.getAbsolutePath().contains("Building.xlsx"));
    }

    @Test
    public void checkTheHumanise()
    {
        DatabaseView databaseView = new DatabaseView();
        Assert.assertTrue("Checking checkTheHumanise part and handling exceptions",0 < databaseView.getDataBaseRecordsInString("BUILDING.sql").size());
    }

    @Test
    public void verifyLoadSQLFile() throws IOException {

        String SQL = DBUtils.loadSQLFile(PropertiesLoader.getProperty("mac_boxFolder")+"/"+PropertiesLoader.getProperty("mac_SQLFolder")+"/Building.sql");
        loadDBRecords loadDBRecords = new loadDBRecords();
        Assert.assertTrue("Checking the connectivity to datbase",0 < loadDBRecords.loadRecords(prop.getProperty("dbuserName"), prop.getProperty("dbpassword"), prop.getProperty("url"),SQL).size());
    }

    @Test
    public void verifyXMLFileFound()
    {
        String xml = DBUtils.loadSQLFile("/Users/sriramangajala/Box Sync/QA/Automation Test/Export/expectedFiles/BUILDING-Asset.xml");
        List<HashMap> expData = VXMLUtils.sortData(VXMLUtils.getXMLData(xml, "BUILDING_EXTRACT", "BUILDING"),"AssetReference");
        VXMLUtils.printData(expData);

        String xml1 = DBUtils.loadSQLFile("/Users/sriramangajala/Box Sync/QA/Automation Test/Export/actualFiles/BUILDING-Asset_1.xml");
        List<HashMap> actData = VXMLUtils.sortData(VXMLUtils.getXMLData(xml1,"BUILDING_EXTRACT", "BUILDING"),"AssetReference");
        VXMLUtils.printData(actData)  ;
        ValidationUtils.compareTwoThings(actData,expData,"AssetReference");

    }

    @Test
    public void verifyXMLLease()
    {
        String xml = DBUtils.loadSQLFile("/Users/sriramangajala/Box Sync/QA/Automation Test/Export/expectedFiles/LEASE-Lease.xml");
        List<HashMap> expData = VXMLUtils.sortData(VXMLUtils.getXMLData(xml, "LEASE_EXTRACT", "LEASE"),"LeaseReference");
    //    VXMLUtils.printData(expData);

        String xml1 = DBUtils.loadSQLFile("/Users/sriramangajala/Box Sync/QA/Automation Test/Export/actualFiles/LEASE-Lease.xml");
        List<HashMap> actData = VXMLUtils.sortData(VXMLUtils.getXMLData(xml1,"LEASE_EXTRACT", "LEASE"),"LeaseReference");
      //  VXMLUtils.printData(actData)  ;
        ValidationUtils.compareTwoThings(actData,expData,"LeaseReference");

    }

    @Test
    public void verifyDevelopment()
    {


        String xml = DBUtils.loadSQLFile("/Users/sriramangajala/Box Sync/QA/Automation Test/Export/expectedFiles/DEVELOPMENT-Development.xml");
        List<HashMap> expData = VXMLUtils.sortData(VXMLUtils.getXMLData(xml, "DEVELOPMENT_EXTRACT","DEVELOPMENT"),"AssetReference");
        String xml1 = DBUtils.loadSQLFile("/Users/sriramangajala/Box Sync/QA/Automation Test/Export/actualFiles/DEVELOPMENT-Development.xml");
        List<HashMap> actData = VXMLUtils.sortData(VXMLUtils.getXMLData(xml, "DEVELOPMENT_EXTRACT","DEVELOPMENT"),"AssetReference");
        ValidationUtils.compareTwoThings(actData,expData,"AssetReference");
    }

}
