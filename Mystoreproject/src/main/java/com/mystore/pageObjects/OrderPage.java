package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDrivers.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	
	@FindBy(xpath="//*[@id='product_price_1_1_0']")
	WebElement unitprice;
	
	@FindBy(id="total_price")
	WebElement totalprice;
	
	@FindBy(xpath="//span[text()= 'Proceed to checkout']")
	WebElement proceedtocheckoutbtn;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		
		String unitprice1 = unitprice.getText();
		String unit = unitprice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalunitprice = Double.parseDouble(unit);
		return finalunitprice/100;
	}
	
    public double gettotalUnitPrice() {
		
		String totalunitprice1 = totalprice.getText();
		String totalunit = totalunitprice1.replaceAll("[^a-zA-Z0-9]", "");
		double totalunitprice = Double.parseDouble(totalunit);
		return totalunitprice/100;
	}
    
    public LoginPage proceedtochecoutorderpage() {
    	Action.fluentWait(getDriver(),proceedtocheckoutbtn,10);
    	Action.click(getDriver(), proceedtocheckoutbtn);
    	return new LoginPage();
    }
    
    public AddressPage proceedtochecoutorderpage1() {
    	Action.fluentWait(getDriver(), proceedtocheckoutbtn, 10);
    	Action.click(getDriver(), proceedtocheckoutbtn);
    	return new AddressPage();
    }
	
    
	

}
