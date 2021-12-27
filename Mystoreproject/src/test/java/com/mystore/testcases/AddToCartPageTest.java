package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchBrowser(browser);
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void addToCartTest() {
		indexpage = new IndexPage();
		searchresultpage = indexpage.Searchproduct("t-shirts");
		addtocartpage = searchresultpage.SelectProduct();
		addtocartpage.selectquantity("2");
		addtocartpage.selectsize("M");
		addtocartpage.addToCart();
		boolean message =addtocartpage.validateaddtocartmessage();
		Assert.assertTrue(message);
		orderpage = addtocartpage.clickproceedtocheckout();
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		TearDown();
	}
}
