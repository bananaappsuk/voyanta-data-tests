package com.voyanta.data.voyanta;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sriramangajala on 22/07/2014.
 */
public class BrowserFactory {

    static WebDriver driver;
    static String browserName = "remote";

    public void setDriver(String browserName)
    {

    }

    public static WebDriver getDriver()
    {
        if(driver==null)
        {
            if(browserName!=null||browserName.equalsIgnoreCase("firefox"))
            {
                driver = new FirefoxDriver();
            }
            else {
//                Capabilities capabilities= DesiredCapabilities.firefox();
//                try {
//                    driver = new RemoteWebDriver(new URL("http://autotest4.voyanta.com:4444/wd/hub"),capabilities);
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
                driver = new FirefoxDriver();
            }
        }

        return driver;
    }
}
