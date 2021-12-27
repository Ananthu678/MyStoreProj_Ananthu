package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.AccountCreationPage;
import com.mystore.pageObjects.AddressPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;

import junit.framework.Assert;

public class AccountCreationPageTest extends BaseClass{
	
	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountcreationpage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchBrowser(browser);
	}
	
	@Test(groups = "Sanity")
	public void checkformTitle() {
		indexpage = new IndexPage();
        loginpage = indexpage.clickOnSignIn();
	    accountcreationpage = loginpage.createAccount("thala.ananthu1@gmail.com");
		boolean result=accountcreationpage.checkformtitle();
		Assert.assertTrue(result);
	}
	
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		TearDown();
	}
}
