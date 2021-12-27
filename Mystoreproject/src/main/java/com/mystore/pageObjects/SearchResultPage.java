package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDrivers.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	@FindBy(xpath="(//a[contains(text(),'Faded Short Sleeve T-shirts' )])[2]")
	WebElement productResult;
	
	@FindBy(xpath="//span[contains(text(), 'Quick view')]")
	WebElement quickview;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean productavailabilty() {
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage SelectProduct() {
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
	
	

}
