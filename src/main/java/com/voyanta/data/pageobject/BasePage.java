package com.voyanta.data.pageobject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BasePage extends BaseClass
{	
	public String page;
	public static Properties prop;
	
	
	public BasePage()
	{
		prop = new Properties();
		InputStream input = getClass().getResourceAsStream("/framework.properties");
		
		try {
	        prop.load(input);
	        page = prop.getProperty("ENVIRONMENT","http://test.voyanta.com");

	        input.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
}

	

