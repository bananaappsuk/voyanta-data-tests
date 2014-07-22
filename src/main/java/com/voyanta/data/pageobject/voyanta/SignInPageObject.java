package com.voyanta.data.pageobject.voyanta;


import com.voyanta.data.pageobject.voyanta.pageobject.WaitUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * @author ting 
 *  This class defines all the relevant elements and services provided by Sign In Page
 *
 */
public class SignInPageObject {
    static Logger LOGGER = Logger.getLogger(SignInPageObject.class);

    private static final int MAX_TIME_OUT = 60;
    //	private WebDriver driver;
	//private static String URL="https://test.voyanta.com/";
	private static String URL="http://test.voyanta.com";

    
	//	The Email or Password you entered is incorrect. Please try again.
	 @FindBy(how = How.ID, using = "email")
	    private WebElement inputEmail;
	 
	 @FindBy(how = How.ID, using = "password")
	    private WebElement inputPassword;
	 
	 @FindBy(how = How.CSS, using = ".voyantaButton.medium")
	    private WebElement buttonSignIn;
	 
	 @FindBy(how= How.PARTIAL_LINK_TEXT, using="Forgot your Password?")
	    private WebElement linkFP;

    @FindBy(how= How.LINK_TEXT, using="Home")
    public WebElement Home;

    @FindBy(how= How.LINK_TEXT, using="Building")
    public WebElement Building;

    @FindBy(how = How.CSS, using = "div.content-wrapper h1.left")
    public WebElement sidebar_label;

    @FindBy(how=How.TAG_NAME,using = "body")
    public WebElement body;

	//error message locator
	    private static String ErrorMSGID="form-messenger";
	    
	    
	public SignInPageObject(){
		 //this.driver=selenium;
	 }
	
	 public void signIn(String userName, String passWord){
         LOGGER .info("Logging in with the username and password :"+userName+" , "+passWord);
		 inputEmail.sendKeys(userName);
		 inputPassword.sendKeys(passWord);
		 buttonSignIn.click();


		// WebElement myDynamicElement = (new WebDriverWait(driver, 10))
		//		  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tabs.original-tabs>ul>li>a>span")));
		 try{
				Thread.sleep(5000);
				}
				catch(InterruptedException i){
					System.out.println("sleep error");
				}
         Assert.assertTrue("Login unsuccessful. Please check if application is up and running!",body.getText().contains("Overview"));
         LOGGER .info("Loggin success with the username and password: "+userName+" , "+passWord);
	 }
	 
	
	 public void forgotPW(){
		 linkFP.click();
	 }
     public static String getURL(){
    	 return URL;
     }

    public void waitForFirstPageToLoad(WebDriver driver,By by) throws InterruptedException {
        driver.switchTo().frame("report-page");
        waitForElementLoaded(driver,by);
        driver.switchTo().defaultContent();
    }

    private void waitForElementLoaded(WebDriver driver,By by) throws InterruptedException {
      int i=1000;
      int counter=0;
      while((!elementPresent(driver,by))&&counter<MAX_TIME_OUT)
        {

            Thread.sleep(i);
            counter ++;
            System.out.println("Waiting for a sec....");
        }
    }

    private boolean elementPresent(WebDriver driver,By by) {
        try {
            return driver.findElement(by).isDisplayed();

        }
        catch (Exception e)
        {
            return false;
        }
    }
}
