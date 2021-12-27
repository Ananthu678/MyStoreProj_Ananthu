package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDrivers.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement proceedtocheckoutbtn1;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickproceedinaddresspage() {
		Action.fluentWait(getDriver(), proceedtocheckoutbtn1, 10);
		Action.click(getDriver(), proceedtocheckoutbtn1);
		return new ShippingPage();
	}
	
	

}
