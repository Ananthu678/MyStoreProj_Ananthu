package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDrivers.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath = "//a[contains(text(), 'Sign in')]")
	WebElement signInbutton;
	
	@FindBy (xpath = "//img[@class='logo img-responsive']")
	WebElement logo;
	
	@FindBy (id ="search_query_top")
	WebElement searchbox;
	
	@FindBy (name = "submit_search")
	WebElement searchbutton;
	
	 public IndexPage() {
		 PageFactory.initElements(getDriver(),this);
	 }
	
	 public LoginPage clickOnSignIn() {
		 Action.click(getDriver(), signInbutton);
		 return new LoginPage();
	 }
	 
	 public boolean validatelogo(){
		 return Action.isDisplayed(getDriver(), logo);
	 }
	 
	 public String PageTitle() {
		 String titlepage = getDriver().getTitle();
		 return titlepage;
		 
	 }
	 
	 public SearchResultPage Searchproduct(String productname) {
		 Action.type(searchbox, productname);
		 Action.click(getDriver(), searchbutton);
		 return new SearchResultPage();
	 }

}
