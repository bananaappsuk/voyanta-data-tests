// ############################## DATA MANAGER PAGE ##############################
// This file should contain all objects and object manipulations pertaining to the
// data management page and its associated tabs
// ###############################################################################
//
// v 0.0.1		Kevin McCarthy		Created file
// v 0.0.2		Kevin McCarthy		Added main page objects
// v 0.0.3		Sowmya Vudathu		Added navigation functions

package com.voyanta.data.pageobject.voyanta.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DataManager extends BaseClass{
	
	@FindBy(how = How.CSS, using = "#upload-button>a")
	private WebElement UploadDataButton;
	

	//-----------------------------------------------------
	// NAVIGATION TABS
	//-----------------------------------------------------
	@FindBy(how = How.LINK_TEXT, using = "My Submissions")
	private WebElement MySubmissionsTab;

	@FindBy(how = How.LINK_TEXT, using = "Pending Approval")
	private WebElement PendingApproval;

	@FindBy(how = How.LINK_TEXT, using = "History")
	private WebElement SubmissionHistory;
	

	//-----------------------------------------------------
	// RADIO BUTTONS FOR DATA TYPES
	//-----------------------------------------------------
	@FindBy(how = How.CSS, using = "#submission-radio-DATA")
	private WebElement SubmissionRadioData;
	
	@FindBy(how = How.CSS, using = "#submission-radio-DOCUMENT")
	private WebElement SubmissionRadioDocument;
	
	@FindBy(how = How.CSS, using = "#submission-radio-")
	private WebElement SubmissionRadioBoth;
	

	//-----------------------------------------------------
	// TABLE HEADERS (FOR SORTS)
	//-----------------------------------------------------
	@FindBy(how = How.CSS, using = "#submission-table-name")
	private WebElement SubmissionTableName;
	
	@FindBy(how = How.CSS, using = "#submission-table-recipient")
	private WebElement SubmissionTableRecipient;
	
	@FindBy(how = How.CSS, using = "#submission-table-type")
	private WebElement SubmissionTableType;
	
	@FindBy(how = How.CSS, using = "#submission-table-notes")
	private WebElement SubmissionTableNotes;
	
	@FindBy(how = How.CSS, using = "#submission-table-submitted")
	private WebElement SubmissionTableSubmitted;
	
	@FindBy(how = How.CSS, using = "#submission-table-validation")
	private WebElement SubmissionTableValidation;
	
	@FindBy(how = How.CSS, using = "#submission-table-approval")
	private WebElement SubmissionTableApproval;
	

	//-----------------------------------------------------
	// TABLE ELEMENTS - fetch as lists
	//-----------------------------------------------------
	
	@FindBy(how= How.CSS, using=".show-files-link>span")
	private WebElement ShowFilesLink;
	
	@FindBy(how= How.CSS, using=".voyantaButton.icon.actionReviewSubmission")
	private WebElement ReviewButton;
	
	@FindBy(how= How.CSS, using=".trash")
	private WebElement CancelButton;
	
	@FindBy(how= How.CSS, using=".approve")
	private WebElement ApproveSubmission;

    @FindBy(how = How.XPATH,using = "//div[@id='list-table-holder']/table/tbody/tr")
    private WebElement TopRow;

	//-----------------------------------------------------
	// PUBLIC METHODS
	//-----------------------------------------------------
	public void DataManagerPageNavigation(String NewLink) throws InterruptedException
	{
        if (NewLink.equals("My Submissions")) {
            go_to_MySubmissions();
            Thread.sleep(5000);

        } else if (NewLink.equals("Pending Approval")) {
            go_to_PendingApproval();
            Thread.sleep(5000);

        } else if (NewLink.equals("History")) {
            go_to_History();
            Thread.sleep(5000);

        }
	}

	//-----------------------------------------------------
	// PRIVATE METHODS
	//-----------------------------------------------------
	public void go_to_MySubmissions()
	{
		MySubmissionsTab.click();
	}
	
	public void go_to_PendingApproval()
	{
		PendingApproval.click();
	}
	
	public void go_to_History()
	{
		SubmissionHistory.click();
        VUtils.waitFor(20);
	}
    public WebElement getTopRow() {
        return TopRow;
    }

    public String getFirstRowText() {
        return driver.findElement(By.xpath("//div[@id='list-table-holder']/table/tbody/tr")).getText();
    }
}
