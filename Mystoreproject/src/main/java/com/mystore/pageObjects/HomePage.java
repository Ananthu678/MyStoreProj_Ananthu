package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDrivers.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
 
	 @FindBy(xpath ="//span[contains(text(), 'My wishlists')]")
	 WebElement wishlist;
	 
	 @FindBy(xpath="//span[contains(text(), 'Order history and details')]")
	 WebElement OrderhistoryDetails;
	 
	 @FindBy (id ="search_query_top")
		WebElement searchbox;
		
	@FindBy (name = "submit_search")
	WebElement searchbutton;
	 
	 public HomePage() {
		 PageFactory.initElements(getDriver(), this);
	 }
	 
	 public boolean validatewishlist() {
		 return Action.isDisplayed(getDriver(), wishlist);	 
	 }
	 
	 public boolean validateorderhistoryDetails() {
		 return Action.isDisplayed(getDriver(), OrderhistoryDetails);	 
	 }
	 
	 public String getCurrentURL() {
		 String url=getDriver().getCurrentUrl();
		 return url;
	 }
	 
	 public SearchResultPage Searchproduct(String productname) {
		 Action.type(searchbox, productname);
		 Action.click(getDriver(), searchbutton);
		 return new SearchResultPage();
	 }
}
