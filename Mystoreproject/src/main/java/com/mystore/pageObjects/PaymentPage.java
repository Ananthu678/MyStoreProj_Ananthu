package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDrivers.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass{

	@FindBy(xpath="//a[@class='bankwire']")
	WebElement bankwiremethod;
	
	@FindBy(xpath="//a[contains(text(), 'Pay by check')]")
	WebElement paybycheck;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummary bankwiremethod() {
		Action.fluentWait(getDriver(), bankwiremethod, 10);
		Action.click(getDriver(), bankwiremethod);
		return new OrderSummary();
	}
	
	public OrderSummary paybycheckmethod() {
		Action.click(getDriver(), paybycheck);
		return new OrderSummary();
	}
}
