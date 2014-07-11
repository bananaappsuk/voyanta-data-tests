package com.voyanta.data.pageobject.voyanta;


import org.junit.Assert;
import org.junit.Test;

//import org.voyanta.regression.WebDriverManager;

//import cucumber.api.Scenario;
//import cucumber.api.java.After;


public class BrowserTests extends abstractBaseTest{

	@Test
	public void financialReports() throws InterruptedException  {
        signInPage.Home.click();
        signInPage.Building.click();

		Thread.sleep(5000);

       Assert.assertEquals(signInPage.sidebar_label.getText(),("Building Listsfsff"));
       System.out.println("test case 3 passed...");
	}
   

	

}
