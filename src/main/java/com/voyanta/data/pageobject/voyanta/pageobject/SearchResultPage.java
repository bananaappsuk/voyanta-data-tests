package com.voyanta.data.voyanta.pageobject;

import com.voyanta.data.pageobject.voyanta.pageobject.BaseClass;
import com.voyanta.data.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Iterator;
import java.util.List;



public class SearchResultPage extends BaseClass {
 
	private static String objectLinkList_CSSLo= ".report-link";
	private static String noResult_CSSLo=".whitebox.w-mid";
	
	private static String noResultMsg="No results found";
	
	@FindBy(how = How.CSS, using = "#content>h1")
    private WebElement title;
	
	 @FindBy(how = How.CSS, using = ".search-result-type")
	 private List<WebElement> objectGroupList;
	 
	 @FindBy(how = How.CSS, using = ".report-link")
	 private List<WebElement> objectLinkList;
	 
	 @FindBy(how = How.CSS, using = ".download-object-all>span")
	    private WebElement buttonDownloadAll;
	 
	@FindBy(how= How.CSS, using=".download-object")
	    private List<WebElement> buttonDownloadList;
	
	public SearchResultPage(String searchTerm) {
		String url="https://test.voyanta.com/search/?q="+searchTerm;
		if(!driver.getCurrentUrl().equals(url)){
			driver.get(url);
		 	System.out.println("input not work");
			try{
			Thread.sleep(5000);
			}
			catch(InterruptedException i){
				System.out.println("sleep error");
			}
				
			}
		}
		
	public boolean no_result(){
		String text=driver.findElement(By.cssSelector(noResult_CSSLo)).getText();
		if(text.equals(noResultMsg)){
			return true;
		}
		return false;
	}
	
	public String get_expected_Title(String searchTerm){
		String expectTitle="Search Results for"+" \""+searchTerm+"\"";
			return expectTitle;
	}
	
	public String get_Title(){
	//	String expectTitle="Search Results for"+" \""+searchTerm+"\"";
			return title.getText();
	}
	
	public WebElement get_button_download_all(){
		return buttonDownloadAll;
	}
	
	public List<WebElement> get_button_download_list(){
		return buttonDownloadList;
	}
	
	 public List<WebElement> get_objectGroup(){
		//objectGroupList= driver.findElements(By.cssSelector(objectGroupList_CSSLo));
		 return  objectGroupList;
	 }
	  
	 public List<WebElement> get_objectLinkList(){
		 objectLinkList= driver.findElements(By.cssSelector(objectLinkList_CSSLo));
		 return  objectLinkList;
	 }
	 
	 public List<WebElement> get_ObjectLinkList_for_Group(String objectGroup){
		 WebElement group= Helper.find_object_based_on_name(objectGroupList, objectGroup);
		 group.click();
		 return get_objectLinkList();
	 }
	 
	 
	 public boolean find_objectGroup(String [] objectGroup){
		 get_objectGroup();
		 return find_elements_in_list(objectGroupList, objectGroup);
	 }
	 
	 public boolean find_objectLink(String [] objectLink){
		 get_objectLinkList();
		 return find_elements_in_list(objectLinkList, objectLink);
	 }
	 
	 
	 public boolean find_elements_in_list(List<WebElement> elementList, String[] objectArr){
		 int length=objectArr.length;
		 if(elementList!=null&&elementList.size()==length){
		 for(int i=0;i<length;i++){
			 Iterator<WebElement> iterator=elementList.iterator();
			 while(iterator.hasNext()) {
				 String currentElementName=iterator.next().getText();
				 
				if( objectArr[i].equals(currentElementName))
					{
					if(i==length-1){return true;}
					else break;
					}
			 }
		 }
		 }
		 return false;
	 }
	
}
