package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDrivers.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(id ="email")
	WebElement emailaddress;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement submitbtn;
	
	@FindBy(xpath ="//input[@id='email']")
	WebElement emailaddress1;
	
	@FindBy(xpath ="//input[@id='passwd']")
	WebElement password1;
	
	@FindBy(id="email_create")
	WebElement emailforNewAccount;
	
	@FindBy(id="SubmitCreate")
	WebElement submitforNewAccount;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname, String pwd) {
		Action.type(emailaddress, uname);
		Action.type(password, pwd);
		Action.click(getDriver(), submitbtn);
		return new HomePage();
	}
	
	
	public AddressPage login1(String uname, String pwd) {
		Action.type(emailaddress1, uname);
		Action.type(password1, pwd);
		Action.click(getDriver(), submitbtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createAccount(String newemail) {
		Action.type(emailforNewAccount, newemail );
		Action.click(getDriver(), submitforNewAccount);
		return new AccountCreationPage();
	}

}
