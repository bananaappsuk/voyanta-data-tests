// ########################### ACCOUNT MANAGEMENT PAGE ###########################
// This file should contain all objects and object manipulations pertaining to the
// account management - e.g. name, password and language preferences
// ###############################################################################
//
// v 0.0.1		Kevin McCarthy		Created file

package com.voyanta.data.pageobject.voyanta.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountManagementPage {
	
	@FindBy(how= How.LINK_TEXT,using="Name")
	private WebElement tabName;
	
	@FindBy(how= How.LINK_TEXT,using="Password")
	private WebElement tabPassword;
    
	@FindBy(how= How.LINK_TEXT,using="Password")
	private WebElement tabRegionalPreference;
	
	// -----------------------------------------------------
	// PAGE ELEMENTS - Change Password
	// -----------------------------------------------------
	@FindBy(how= How.CSS, using="#oldPassword")
	private WebElement OldPassword;
	
	@FindBy(how= How.CSS, using="#password")
	private WebElement NewPassword;
	
	@FindBy(how= How.CSS, using="#confirmPassword")
	private WebElement ConfirmPassword;
	
	@FindBy(how= How.NAME, using="#changepassword-button")
	private WebElement ChangePassword;
	
	// -----------------------------------------------------
	// PAGE ELEMENTS - change name
	// -----------------------------------------------------
	@FindBy(how= How.CSS, using="#name")
	private WebElement inputName;
	
	@FindBy(how= How.CSS, using="#.voyantaButton.medium")
	private WebElement buttonChangePassword;
	
	// -----------------------------------------------------
	// PAGE ELEMENTS - change language
	// -----------------------------------------------------
	@FindBy(how= How.CSS, using=".chzn-single>div")
	private WebElement optionLanguage;
	
	@FindBy(how= How.CSS, using=".chzn-single>span")
	private WebElement ChangeLanguage;
	
	private static String USEnglish="#language_chzn_o_0";
	
	private static String UKEnglish="#language_chzn_o_1";
	
	private static String french="#language_chzn_o_2";
	
	public void changePassword(String oldPassword, String newPassword, String confirmPassword){
		OldPassword.sendKeys(oldPassword);
		NewPassword.sendKeys(newPassword);
		ConfirmPassword.sendKeys(confirmPassword);
		buttonChangePassword.click();
	}
	
	public void changeName(String newName){
		inputName.sendKeys(newName);
		buttonChangePassword.click();
	}
	
	public void changeLanguage(String language){
//		switch(language){
//		case "English":
//
//		}
	}
}
