package com.voyanta.data.pageobject.voyanta.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadPage extends BaseClass {
	
	private String url="https://test.voyanta.com/submission/upload";
	
	 @FindBy(how = How.CSS, using = ".fileinput-button>input")
	    private WebElement selectFileButton;
	 
	 @FindBy(how = How.NAME, using = "save")
	    private WebElement saveButton;
	 
	 @FindBy(how = How.ID, using = "name")
	 private WebElement nameInput;
	 
	 @FindBy(how = How.ID, using = "notes")
	 private WebElement notesInput;
	 
	 private WebElement sucMsg;
	 private static String sucMsgLoc=".green";
	 
	 private WebElement errorMsg;
	 private static String errorMsgLoc="";
	 
	private static void setClipboardData(String string) {
			   StringSelection stringSelection = new StringSelection(string);
			   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);		}
	 
	 public void selectFiles(String filePath) throws AWTException{

//		  selectFileButton.click();
//			//driver.findElement(By.cssSelector(".fileinput-button>input")).sendKeys("C:/Test.txt");
			setClipboardData(filePath);
			//native key strokes for CTRL, V and ENTER keys
//			Robot robot = new Robot();
//			robot.setAutoWaitForIdle(true);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//         robot.delay(20000);
		 selectFileButton.sendKeys(filePath);
         VUtils.waitFor(20);

         if(saveButton.getAttribute("class").contains("disabled"))
         {
             VUtils.waitFor(10);
             selectFileButton.click();
//			//driver.findElement(By.cssSelector(".fileinput-button>input")).sendKeys("C:/Test.txt");
             setClipboardData(filePath);
             //native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.setAutoWaitForIdle(true);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(2000);
             selectFileButton.sendKeys(filePath);
             robot.keyPress(KeyEvent.VK_ENTER);
             robot.keyRelease(KeyEvent.VK_ENTER);
         }
         try {
             Thread.sleep(2000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
	 
	 public void typeName(String name){
		 selectFileButton.sendKeys(name);
	 }
	 
	 public void typeNotes(String Notes){
		 selectFileButton.sendKeys(Notes);
	 }
	 
	 public void save(){
		 saveButton.click();
	 }
	 
	 public boolean getSucElement(){
		if ((driver.findElement(By.cssSelector(sucMsgLoc))==null)){
			return true;
		}
		return false;
	 }
	 
	 public String getUploadSucMsg(){
		 return driver.findElement(By.cssSelector(sucMsgLoc)).getText();
	 }
	 
	 public String getURL(){
		 return url;
	 }
}
