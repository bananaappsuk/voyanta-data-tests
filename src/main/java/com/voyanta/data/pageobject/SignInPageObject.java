package com.voyanta.data.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author ting 
 *  This class defines all the relevant elements and services provided by Sign In Page
 *
 */
public class SignInPageObject extends BasePage{
	
//	private WebDriver driver;
	//private static String URL="https://test.voyanta.com/";
	private static String URL="http://featuredev.voyanta.com";

    
	//	The Email or Password you entered is incorrect. Please try again.
	 @FindBy(how = How.ID, using = "email")
	    private WebElement inputEmail;
	 
	 @FindBy(how = How.ID, using = "password")
	    private WebElement inputPassword;
	 
	 @FindBy(how = How.CSS, using = ".voyantaButton.medium")
	    private WebElement buttonSignIn;
	 
	 @FindBy(how=How.PARTIAL_LINK_TEXT, using="Forgot your Password?")
	    private WebElement linkFP;
	 
	//error message locator
	    private static String ErrorMSGID="form-messenger";
	    
	    
	public SignInPageObject(){
		 //this.driver=selenium;
	 }
	
	 public void signIn(String userName, String passWord){
		 inputEmail.sendKeys(userName);
		 inputPassword.sendKeys(passWord);
		 buttonSignIn.click();
		// WebElement myDynamicElement = (new WebDriverWait(driver, 10))
		//		  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tabs.original-tabs>ul>li>a>span")));
		 try{
				Thread.sleep(15000);
				}
				catch(InterruptedException i){
					System.out.println("sleep error");
				}
	 }
	 
	 public String getErrorMSG(){
		 return driver.findElement(By.id(ErrorMSGID))
					.getText();
	 }; 
	 
	public boolean readErrorMSG(String errorMSG){
			String expectErroMSG=errorMSGProp.getProperty(errorMSG);
				if(getErrorMSG().equals(expectErroMSG)){
						return true;
		}
		return false;
	} 
	
	 public void forgotPW(){
		 linkFP.click();
	 }
     public static String getURL(){
    	 return URL;
     }
}
