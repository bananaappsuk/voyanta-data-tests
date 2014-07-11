package com.voyanta.data.pageobject.voyanta;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.voyanta.regression.WebDriverManager;


//import cucumber.api.Scenario;
//import cucumber.api.java.After;


public class FinancialPerformance extends abstractBaseTest{

   

   
	@SuppressWarnings("deprecation")
	@Test
	public void financialReports() throws InterruptedException  {
		driver.get(URL+"report/");

		WebElement dashboardLink=driver.findElement(By.linkText("Financial Performance"));
		dashboardLink.click();
		Thread.sleep(5000);
		WebElement viewButton=driver.findElement(By.cssSelector(".voyantaButton.small"));
		viewButton.click();
		driver.switchTo().frame("report-page");
		 WebDriverWait wait = new WebDriverWait(driver,30);
		  WebElement element = wait.until(
		           ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div/div")));
		   Assert.assertEquals("Current Selections", element.getText());
		   System.out.println("test case 2 passed");
	}
   
	@Test
	public void financialDashboard() throws InterruptedException  {
//		try {
			driver.get(URL);
			Thread.sleep(5000);
			WebElement dashboardLink=driver.findElement(By.linkText("Financial Performance"));
			dashboardLink.click();
			Thread.sleep(5000);
			driver.switchTo().frame("report-page");
            Thread.sleep(5000);
            WebElement element = driver.findElement(By.xpath("html/body/div[3]/div[1]/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div/div"));
//			 WebDriverWait wait = new WebDriverWait(driver,30);
//			  WebElement element = wait.until(
//			           ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[1]/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div/div")));
			   Assert.assertEquals("Current Selections", element.getText());
			   System.out.println("test case 1 passed");
//		} catch (Exception e) {
//
//			byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//	        Assert.fail(e.getMessage());
//			//.embed(screenshot, "src/test/resources/image.png");
//			e.printStackTrace();
//		}
		   
	}

}
