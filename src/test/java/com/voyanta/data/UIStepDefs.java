package com.voyanta.data;

import com.voyanta.data.pageobject.voyanta.SignInPageObject;

import com.voyanta.data.pageobject.voyanta.pageobject.DataManager;
import com.voyanta.data.pageobject.voyanta.pageobject.UploadPage;
import com.voyanta.data.pageobject.voyanta.pageobject.VUtils;
import com.voyanta.data.utils.PropertiesLoader;
import com.voyanta.data.voyanta.BrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;


/**
 * Created by sriramangajala on 10/07/2014.
 */
public class UIStepDefs {
    static String URL;
    static SignInPageObject signInPage;
    static WebDriver driver;
    static String propertiesFileName = "src/main/resources/";
    String fileName ;
    static Logger LOGGER = Logger.getLogger(UIStepDefs.class);
    @Before("~@nobrowser")
    public static void driverUp() throws MalformedURLException, InterruptedException {

////	   System.setProperty("webdri
// ver.chrome.driver", "/Users/sriramangajala/Documents/Automated-UAT/voyanta-availablity-tests/src/main/resources/chromedriver 5");
        driver= BrowserFactory.getDriver();

    }

    @When("^user uploads the (.*) DST from 'UI' with file '(.*)'$")
    public void user_uploads_the_Data_from_UI(String newFile,String fileName) throws Throwable {
        this.fileName = fileName;

        UploadPage uploadPage = new UploadPage();
        PageFactory.initElements(driver, uploadPage);
        driver.get(uploadPage.getURL());
        VUtils.waitFor(5);
        if(newFile.equals("new"))
            uploadPage.selectFiles(PropertiesLoader.getProperty("windows_boxFolder")+PropertiesLoader.getProperty("windows_testDataFolder")+fileName);
        else
            uploadPage.selectFiles(PropertiesLoader.getProperty("windows_boxFolder")+PropertiesLoader.getProperty("windows_editedTestDataFolder")+fileName);

//        uploadPage.waitTillFileIsUploaded(driver);
        uploadPage.save();

        VUtils.waitFor(10);
    }

    @When("^the DST have passed through the Validations and Approvals$")
    public void the_uploaded_file_is() throws Throwable
    {
        DataManager dataManager = new DataManager();
        PageFactory.initElements(driver, dataManager);
        dataManager.waitTill(driver,"Validating");
        dataManager.waitTill(driver,"Approving");
        VUtils.waitFor(20);
        dataManager.go_to_History();
        dataManager.setDriver(driver);

        Assert.assertTrue("Uploading failed as no file present in history tab", dataManager.getFirstRowText().contains(fileName));
//        Assert.assertTrue("File found but not the latest one", dataManager.getFirstRowText().contains("secs"));
        Assert.assertTrue("File uploaded but not Approved", dataManager.getFirstRowText().contains("Approved"));
    }
//
    @After("~@export")
    public static void tearDown(Scenario scenario){
//        driver.close();
//        driver.quit();
//        driver=null;
        if(scenario.isFailed())
        {
            VUtils.captureScreen(scenario.getName());
        }
    }


}
