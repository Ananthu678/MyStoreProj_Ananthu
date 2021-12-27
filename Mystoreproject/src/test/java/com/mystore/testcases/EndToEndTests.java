/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.AddressPage;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.pageObjects.OrderConfirmationPage;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.OrderSummary;
import com.mystore.pageObjects.PaymentPage;
import com.mystore.pageObjects.SearchResultPage;
import com.mystore.pageObjects.ShippingPage;
import com.mystore.utils.Log;

/**
 * @author I322911
 *
 */
public class EndToEndTests extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummary ordersummary;
	OrderConfirmationPage orderconfirmationpage;
	HomePage homepage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchBrowser(browser);
	}
	
	
	  @Test (groups = "Regression")
	  public void endtoendtest() {
	  
	  String uname=prop.getProperty("username"); 
	  String pword=prop.getProperty("password");
	  
	  Log.startTestCase("loginTest"); 
	  indexpage = new IndexPage(); 
	  loginpage=indexpage.clickOnSignIn(); Log.info("logging in"); homepage =
	  loginpage.login(uname, pword); 
	  searchresultpage =indexpage.Searchproduct("t-shirts"); Log.info("selected product");
	  addtocartpage = searchresultpage.SelectProduct();
	  addtocartpage.selectquantity("2");
	  addtocartpage.selectsize("M");
	  addtocartpage.addToCart();
	  orderpage =addtocartpage.clickproceedtocheckout(); 
	  addresspage=orderpage.proceedtochecoutorderpage1(); 
	  shippingpage =addresspage.clickproceedinaddresspage(); 
	  Log.info("AddressPage Successful");
	  //shippingpage.selecttermsandconditions(); 
	  paymentpage =shippingpage.prcdtocheckshippingpage(); 
	  Log.info("ShippingPage Successful");
	  ordersummary = paymentpage.bankwiremethod(); 
	  orderconfirmationpage =ordersummary.confirmorder(); 
	  String actualmessage =orderconfirmationpage.validatemessgae(); 
	  String expectedmessage ="Your order on My Store is complete."; 
	  Assert.assertEquals(actualmessage,expectedmessage);
	  
	  }
	 
	
		/*
		 * @Test(dataProvider ="credentials",dataProviderClass = DataProviders.class)
		 * public void endtoendtest1(String uname, String pword) {
		 * 
		 * Log.startTestCase("loginTest"); indexpage = new IndexPage(); loginpage
		 * =indexpage.clickOnSignIn(); Log.info("logging in"); homepage =
		 * loginpage.login(uname, pword); searchresultpage =
		 * indexpage.Searchproduct("t-shirts"); Log.info("selected product");
		 * addtocartpage = searchresultpage.SelectProduct();
		 * addtocartpage.selectquantity("2"); addtocartpage.selectsize("M");
		 * addtocartpage.addToCart(); orderpage =
		 * addtocartpage.clickproceedtocheckout(); addresspage=
		 * orderpage.proceedtochecoutorderpage1(); shippingpage =
		 * addresspage.clickproceedinaddresspage(); Log.info("AddressPage Successful");
		 * shippingpage.selecttermsandconditions(); paymentpage =
		 * shippingpage.prcdtocheckshippingpage(); Log.info("ShippingPage Successful");
		 * ordersummary = paymentpage.bankwiremethod(); orderconfirmationpage =
		 * ordersummary.confirmorder(); String actualmessage =
		 * orderconfirmationpage.validatemessgae(); String expectedmessage =
		 * "Your order on My Store is complete."; Assert.assertEquals(actualmessage,
		 * expectedmessage);
		 * 
		 * }
		 */
	
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		TearDown();
	}
}
