package com.voyanta.data;

import com.voyanta.data.datamodel.DatabaseView;
import com.voyanta.data.pageobject.voyanta.SignInPageObject;
import com.voyanta.data.utils.PropertiesLoader;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

/**
 * Created by sriramangajala on 22/07/2014.
 */
public class baseTest {
    static String URL;
    static SignInPageObject signInPage;
    static WebDriver driver;
    static String propertiesFileName = "src/main/resources/";
    String fileName ;
    static Logger LOGGER = Logger.getLogger(baseTest.class);


    @BeforeClass
    public static void driverUp() throws MalformedURLException, InterruptedException {

////	   System.setProperty("webdri
// ver.chrome.driver", "/Users/sriramangajala/Documents/Automated-UAT/voyanta-availablity-tests/src/main/resources/chromedriver 5");
        driver= BrowserFactory.getDriver();
//////       System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chrome\\chromedriver.exe");
//        Capabilities capabilities = DesiredCapabilities.chrome();
//        LOGGER.info("Server URL is " + PropertiesLoader.getProperty("server"));
//
//        driver = new RemoteWebDriver(new java.net.URL(PropertiesLoader.getProperty("server")),capabilities);

        URL = PropertiesLoader.getProperty("ui_url");
        driver.get(URL);
        driver.manage().window().maximize();
        signInPage=new SignInPageObject();
        PageFactory.initElements(driver, signInPage);
        signInPage.signIn(PropertiesLoader.getProperty("username"), PropertiesLoader.getProperty("password"));
        LOGGER.info("Test phase:"+System.getProperty("test_phase"));
        String boxFolder = PropertiesLoader.getProperty("windows_boxFolder");
       // testDataFolder = PropertiesLoader.getProperty("windows_testDataFolder");
        String SQLFolder = PropertiesLoader.getProperty("windows_SQLFolder");
        System.out.print((new DatabaseView()).executeMultipleDBQuerysFromFile(boxFolder+SQLFolder+"DeleteAll.sql",10));

//        signInPage.waitForFirstPageToLoad(driver,(By.className("QvContent")));

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
        driver.quit();
        driver=null;
    }
}
