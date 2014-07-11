// ################################# TEST RUNNER #################################
// Test runner classes are used to run selected, tagged scenarios and to perform
// some standard setup for testing (using JUnit rather than Selenium)
// ###############################################################################
//
// v 0.0.1		Ting Liu			Created file
// v 0.0.2		Kevin McCarthy		Added BeforeClass, AFterClass and Feature option

package com.voyanta.data.voyanta;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions
	(
		tags	=	"@upload",
		format	=	{"pretty", "html:target/cucumber-htmlreport","json:target/cucumber-report.json"}
	)
public class uploadFileTest {

	
	/*@BeforeClass
	public static void NavigationLogin()
	{   
		WebDriver driver=WebDriverManager.getSingletonDriver();
		SignInPageObject loginPage = new SignInPageObject();
		driver.get(loginPage.getURL());
		PageFactory.initElements(driver, loginPage); 
		loginPage.signIn("george.sandpitt@sandpitt.com", "v0yanta!");
	}
	*/
/*	@AfterClass
	public static void tearDown()
	{
		WebDriverManager.quiteDriver();

	}*/
}
