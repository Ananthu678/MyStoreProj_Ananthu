package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDrivers.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass{
	
	@FindBy(xpath = "//input[@id='cgv']")
	WebElement termsandconditions;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement prcdtocheckoutshipping;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	/*
	 * public void selecttermsandconditions() { Action.fluentWait(driver,
	 * termsandconditions, 10); Action.click(driver, termsandconditions); }
	 */
	
	public PaymentPage prcdtocheckshippingpage() {
		Action.fluentWait(getDriver(), prcdtocheckoutshipping, 10);
		Action.click(getDriver(), prcdtocheckoutshipping);
		return new PaymentPage();
	}

}
