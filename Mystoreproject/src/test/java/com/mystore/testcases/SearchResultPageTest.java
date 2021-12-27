package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.SearchResultPage;


public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchBrowser(browser);
	}
	
	@Test(groups = "Smoke")
	public void productavailability() {
		indexpage=new IndexPage();
		searchresultpage = indexpage.Searchproduct("t-shirts");
		boolean result = searchresultpage.productavailabilty();
		Assert.assertTrue(result);
	}
	
	/*
	 * @Test public void Selectproduct() { indexpage=new IndexPage();
	 * searchresultpage = indexpage.Searchproduct("t-shirts"); addtocartpage =
	 * searchresultpage.SelectProduct(); String actualURL =
	 * addtocartpage.getPageURL(); String expectedURL =
	 * "http://automationpractice.com/index.php?id_product=1&controller=product&search_query=t-shirts&results=1";
	 * Assert.assertEquals(actualURL, expectedURL); }
	 */
	
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		TearDown();
	}
}
