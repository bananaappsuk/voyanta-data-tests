package com.voyanta.data.voyanta;

import com.voyanta.data.pageobject.voyanta.SignInPageObject;
import com.voyanta.data.pageobject.voyanta.pageobject.BaseClass;
import com.voyanta.data.pageobject.voyanta.pageobject.UploadPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Test extends BaseClass {

	public static void setClipboardData(String string) {
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	public static void main(String[] args) throws InterruptedException, AWTException{
		WebDriver driver= new FirefoxDriver();
	//	driver.get("https://featuredev.voyanta.com/");
		//driver.findElement(By.linkText("Forgot your Password?")).click();
		

		Test test=new Test();
//	System.out.println(errorMSGProp.getProperty("NotBlank.registerAccountRequest.name"
		driver.get(SignInPageObject.getURL());
		SignInPageObject signInPage=new SignInPageObject();
		
		
		PageFactory.initElements(driver, signInPage);
		signInPage.signIn("george.sandpitt@sandpitt.com", "v0yanta!");
		UploadPage uploadpage=new UploadPage();
		Thread.sleep(3000);
		driver.get("https://live.voyanta.com/submission/upload");
		PageFactory.initElements(driver, uploadpage);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#fileupload .fileinput-button input")).click();
		//driver.findElement(By.cssSelector(".fileinput-button>input")).sendKeys("C:/Test.txt");
		setClipboardData("C:\\java2.log");
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
		//driver.findElement(By.id("fileupload")).submit();
		//uploadpage.selectFiles("C:/java2.log");
		Thread.sleep(10000);
		driver.quit();
	}
	
}
