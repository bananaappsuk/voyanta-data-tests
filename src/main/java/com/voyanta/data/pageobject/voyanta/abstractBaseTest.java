package com.voyanta.data.pageobject.voyanta;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

/**
 * Created by sriramangajala on 04/07/2014.
 */
public abstract class abstractBaseTest {
    static String URL;
    static SignInPageObject signInPage;
    static WebDriver driver;
    static String propertiesFileName = "src/main/resources/";
    public static Properties PROPERTIES = loadProperties(propertiesFileName);
    @Rule
    public SimpleOnFailed simpleOnFailed = new SimpleOnFailed();;



    @BeforeClass
    public static void driverUp() throws MalformedURLException, InterruptedException {

//	   System.setProperty("webdriver.chrome.driver", "/Users/sriramangajala/Documents/Automated-UAT/voyanta-availablity-tests/src/main/resources/chromedriver 5");
        driver=new FirefoxDriver();
////       System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chrome\\chromedriver.exe");
//        Capabilities capabilities = DesiredCapabilities.firefox();
//        System.out.println("URL is "+PROPERTIES.getProperty("server"));
//        driver = new RemoteWebDriver(new java.net.URL(PROPERTIES.getProperty("server")),capabilities);

        URL = PROPERTIES.getProperty("url");
        driver.get(URL);
        signInPage=new SignInPageObject();
        PageFactory.initElements(driver, signInPage);
        signInPage.signIn(PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password"));
        System.out.print(System.getProperty("test_phase"));
        signInPage.waitForFirstPageToLoad(driver,(By.className("QvContent")));

    }

    @Before
    public void before()
    {

    }

    @After
    public void after()
    {

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
        driver.quit();
        driver=null;
    }

    private static Properties loadProperties(String propertiesFileName) {
        Properties pro = new Properties();
        try {
            pro.load(new FileInputStream(propertiesFileName+System.getProperty("test_phase")+".properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pro;
    }

}
