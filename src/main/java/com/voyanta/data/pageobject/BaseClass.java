package com.voyanta.data.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseClass {
	
	public static String browser="firefox";
	public static WebDriver driver;
	public static Properties errorMSGProp;

	
	public BaseClass()
	{
		Properties prop = new Properties();


		InputStream input = getClass().getResourceAsStream("/framework.properties");
		errorMSGProp=new Properties();
		InputStream errorMsgInput=getClass().getResourceAsStream("/messages.20.11.13.GB.properties");

		
		System.out.println(input);
		try {
	        prop.load(input);
	        browser = prop.getProperty("TEST_BROWSER","firefox");
	        errorMSGProp.load(errorMsgInput);
	        errorMsgInput.close();
	        input.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static WebDriver GetDriver()
	{
        if (browser.equals("firefox") || browser.equals("mozilla")) {
            driver = new FirefoxDriver();

        } else if (browser.equals("chrome") || browser.equals("google")) {
            driver = new ChromeDriver();

        } else if (browser.equals("ie") || browser.equals("explorer")) {
            driver = new InternetExplorerDriver();

        } else {
            driver = new FirefoxDriver();
        }
		return driver;
	}
}
