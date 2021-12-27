package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.SearchResultPage;

import junit.framework.Assert;

public class OrderPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchBrowser(browser);
	}
	
	@Test(groups = "Regression")
	public void verifytotalprice() {
		indexpage = new IndexPage();
		searchresultpage = indexpage.Searchproduct("t-shirts");
		addtocartpage = searchresultpage.SelectProduct();
		addtocartpage.selectquantity("2");
		addtocartpage.selectsize("S");
		addtocartpage.addToCart();
		orderpage = addtocartpage.clickproceedtocheckout();
		Double unitprice = orderpage.getUnitPrice();
		Double totalunitprice = orderpage.gettotalUnitPrice();
		Double totalexpectedprice = (unitprice*1)+2;
		Assert.assertEquals(totalexpectedprice, totalunitprice);
	}
	
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		TearDown();
	}
}
