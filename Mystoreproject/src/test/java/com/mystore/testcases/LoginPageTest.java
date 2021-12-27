package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.utils.Log;

import junit.framework.Assert;

public class LoginPageTest extends BaseClass  {
	
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchBrowser(browser);
	}
	
	
	@Test(dataProvider ="credentials", dataProviderClass = DataProviders.class, groups = {"Smoke", "Sanity"})
	public void logintest(String uname, String pswd) {
		
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
		Log.startTestCase("loginTest");
		indexpage = new IndexPage();
		Log.info("user is going to click on SignIn");
		loginpage= indexpage.clickOnSignIn();
		Log.info("Enter Username and Password");
		homepage= loginpage.login(uname, pswd);
		String actualURL=homepage.getCurrentURL();
		String expectedURL=prop.getProperty("expectedURL");
		Log.info("Verifying the user");
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		TearDown();
	}
}
