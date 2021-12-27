package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;

import junit.framework.Assert;

public class HomePageTest extends BaseClass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchBrowser(browser);
	}
	
	@Test(groups = "Smoke")
	public void wishListTest() {
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
		indexpage = new IndexPage();
		loginpage= indexpage.clickOnSignIn();
		homepage= loginpage.login(username, password);
		boolean result1 = homepage.validatewishlist();
		Assert.assertTrue(result1);
	}
	
	@Test(groups = "Smoke")
	public void orderHistoyDetailsPageTest() {
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
		indexpage = new IndexPage();
		loginpage= indexpage.clickOnSignIn();
		homepage= loginpage.login(username, password);
		boolean result2 = homepage.validateorderhistoryDetails();
		Assert.assertTrue(result2);
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		TearDown();
	}
}
