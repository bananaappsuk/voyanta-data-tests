package com.voyanta.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by sriramangajala on 22/07/2014.
 */
public class BrowserFactory {

    static WebDriver driver;
    static String browserName = "";

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
            else
                driver = new FirefoxDriver();
        }

        return driver;
    }
}
