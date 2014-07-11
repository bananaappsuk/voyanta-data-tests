package com.voyanta.data.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPageObject extends BasePage {


	 private static String url="https://test.voyanta.com/dashboard/";
	 
	 @FindBy(how = How.NAME, using = "search")
	    private WebElement formSearch;
	
	 @FindBy(how = How.CSS, using = ".default.ui-autocomplete-input")
	    private WebElement inputSearch;
	 
	 @FindBy(how = How.ID, using = "search-submit")
	    private WebElement buttonSearch;
	 
	 //@FindBy(how=How.ID, using="Report")
	   
	 
	 public MainPageObject (){
		if(!driver.getCurrentUrl().equals(url))
		{
			
			System.out.println(driver.getCurrentUrl());
			driver.get(url);
		}
	 }
	 
	 public void searchByNameAndRef(String searchKey) throws InterruptedException{
		 
		inputSearch.sendKeys(searchKey);
	//	inputSearch.sendKeys(Keys.ENTER);
    	 System.out.println("this is the search Key? "+ searchKey);
   	//     Thread.sleep(10000);
		 buttonSearch.click();
		 try{
				Thread.sleep(5000);
				}
				catch(InterruptedException i){
					System.out.println("sleep error");
				}
		 
	 }
	 
	 public void searchByTag(){
		 
	 }
	 

}

