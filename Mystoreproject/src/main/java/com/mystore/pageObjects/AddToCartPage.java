package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDrivers.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass{

	 @FindBy(xpath="//input[@id='quantity_wanted']")
	 WebElement quantityelement;
	 
	 @FindBy(xpath="//select[@id='group_1']")
	 WebElement sizeelement;
	 
	 @FindBy(xpath="//p[@id='add_to_cart']")
	 WebElement addtocart;
	 
	 @FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	 WebElement AddToCartMessage;
	 
	 @FindBy(xpath="//span[contains(text(), 'Proceed to checkout')]")
	 WebElement proceedtocheckout;
	 
		/*
		 * @FindBy(xpath="//span[text()= 'Add to cart']") WebElement addtocart;
		 */
	 
	 public AddToCartPage() {
		 PageFactory.initElements(getDriver(), this);
	 }
	
	 public void selectquantity(String quantity) {
		 Action.type(quantityelement,quantity);
		 
	 }
	 
	 public void selectsize(String size) {
		Action.selectByVisibleText(size, sizeelement);
	 }
	 
	 public void addToCart() {
		 Action.fluentWait(getDriver(), addtocart, 5);
		 Action.click(getDriver(), addtocart);
	 }
	 
	 public boolean validateaddtocartmessage() {
		 Action.fluentWait(getDriver(),AddToCartMessage,10);
		 return Action.isDisplayed(getDriver(), AddToCartMessage);
	 }
	 
	 public OrderPage clickproceedtocheckout() {
		 Action.fluentWait(getDriver(),proceedtocheckout,10);
		 Action.JSClick(getDriver(), proceedtocheckout);
		 return new OrderPage();
	 }
	 
	 public String getPageURL() {
		String actualURL=getDriver().getCurrentUrl();
		return actualURL;
		 
	 }
}
