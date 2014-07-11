package com.voyanta.data.pageobject;

import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResetPWPageObject {
	
	private static final String URL="https://featuredev.voyanta.com/account/forgotPassword";
	private static final String sentEmailTitle="Your recovery email is on its way!";
	private static final String sentEmailMSG1="An email containing your password recovery link has been sent.";
	private static final String sentEmailMSG2="For security purposes, this link is valid only for next 24 hours";
	private static final String sentEmailMSG3="If you do not receive an email within 10 minutes, check your spam folder first, then";
	private static final String wrongEmail="";
	private static final String title="Voyanta - ForgotPassword Account";
	
	 @FindBy(how = How.ID, using = "email")
	    private WebElement inputEmail;
 
	 @FindBy(how = How.ID, using = "reset-button")
	    private WebElement buttonReset;
	 
	 @FindBy(how = How.LINK_TEXT, using = "Login")
	    private WebElement linkSignIn;
	 
	 @FindBy(how=How.ID,using="forgot-password-try-again")
	    private WebElement linkTryAgain;
	 
	 @FindBy(how=How.XPATH, using=".//*[@id='forgot-password-success']/div[2]/h1")
	    private WebElement headSentEmailTitle;
	 
	 @FindBy(how=How.XPATH, using=".//*[@id='forgot-password-success']/div[2]/ul/li[1]")
	    private WebElement textMSG1;
	 
	 @FindBy(how=How.XPATH, using=".//*[@id='forgot-password-success']/div[2]/ul/li[2]")
	    private WebElement textMSG2;

	 @FindBy(how=How.XPATH, using=".//*[@id='forgot-password-success']/div[2]/ul/li[3]")
	    private WebElement textMSG3;
	 
public static String getTitle(){
	return title;
}	
	 
   public static String getURL(){
	   return URL;
   }
	 
	public void resetPW(String email){
		inputEmail.sendKeys(email);
		buttonReset.click();
	}
	
	public void gotoSignIn(){
		linkSignIn.click();
	}
	public void tryAgain(){
		linkTryAgain.click();
	}
	
	public void readErrorMSG(){
		Assert.assertEquals(headSentEmailTitle.getText(),sentEmailTitle);
		Assert.assertEquals(textMSG1.getText(),sentEmailMSG1);
		Assert.assertEquals(textMSG2.getText(),sentEmailMSG2);
		Assert.assertEquals(textMSG3.getText(),sentEmailMSG3);
	}
}
