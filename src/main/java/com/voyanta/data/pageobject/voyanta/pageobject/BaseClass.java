package com.voyanta.data.pageobject.voyanta.pageobject;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseClass {
	
	public static String browser="firefox";
	public WebDriver driver;
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
	
	public void setDriver(WebDriver driver)
	{
		this.driver = driver;
	}
	
//	public static WebDriver GetDriver()
//	{
//		System.out.println("test-------------test");
//		switch(browser)
//		{
//		case "firefox": case "mozilla":
//			driver = new FirefoxDriver();
//			break;
//		case "chrome": case "google":
//			driver = new ChromeDriver();
//			break;
//		case "ie": case "explorer":
//			driver = new InternetExplorerDriver();
//			break;
//		default:
//			driver = new FirefoxDriver();
//		}
//		return driver;
//	}
}

