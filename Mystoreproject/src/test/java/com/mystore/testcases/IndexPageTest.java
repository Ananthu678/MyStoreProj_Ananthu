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
import com.mystore.pageObjects.IndexPage;

/**
 * @author I322911
 *
 */
public class IndexPageTest extends BaseClass {
	
	IndexPage indexpage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchBrowser(browser);
	}
	
	@Test(groups = "Smoke")
	public void verifylogo() {
		indexpage=new IndexPage();
		boolean result=indexpage.validatelogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void verifytitle() {
		String actualtitle = indexpage.PageTitle();
		//String expectedtitle="My Store";
		Assert.assertEquals(actualtitle, "My Store");
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		TearDown();
	}
}
