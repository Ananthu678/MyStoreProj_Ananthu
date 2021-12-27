package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDrivers.Action;
import com.mystore.base.BaseClass;

public class OrderSummary extends BaseClass{
	
	@FindBy(xpath="//h3[contains(text(), 'Bank-wire payment')]")
	WebElement bankwireordersummarypage;
	
	@FindBy(xpath="//span[text() = 'I confirm my order']")
	WebElement confirmorder;
	
	public OrderSummary() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void bankwiremethodcheck() {
		Action.isDisplayed(getDriver(), bankwireordersummarypage);
	}
	
	public OrderConfirmationPage confirmorder() {
		Action.click(getDriver(), confirmorder);
		return new OrderConfirmationPage();
	}

}
