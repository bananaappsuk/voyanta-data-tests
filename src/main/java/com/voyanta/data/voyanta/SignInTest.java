package com.voyanta.data.voyanta;

import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(tags="@login",format = {"pretty", "html:target/cucumber-htmlreport","json:target/cucumber-report.json"})
public class SignInTest {
	
	@BeforeClass
	public static void NavigationLogin()
	{   
	//	WebDriverManager.getSingletonDriver();
		//SignInPageObject loginPage = new SignInPageObject();
	}
	
	@AfterClass
	public static void tearDown()
	{
	//	WebDriverManager.quiteDriver();

	}
	
}





