package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.ActionDrivers.Action;
import com.mystore.utils.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	
	@BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		try {
			  prop=new Properties();
			  FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			  prop.load(fs);
			  
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
	public static void launchBrowser(String browsername) {
		   //String browsername =prop.getProperty("browser");
		   
		   if(browsername.equalsIgnoreCase("Chrome")) {
			   WebDriverManager.chromedriver().setup();
			   ChromeOptions chromeOptions = new ChromeOptions();
			   chromeOptions.addArguments("headless");
			   chromeOptions.addArguments("window-size=1980,1080");
				driver.set(new ChromeDriver(chromeOptions));
		   } 
		   else if(browsername.equalsIgnoreCase("Firefox"))
		   {
			   WebDriverManager.firefoxdriver().setup();
				driver.set(new FirefoxDriver());
		   }
		   else if(browsername.equalsIgnoreCase("IE"))
		   {
			   WebDriverManager.iedriver().setup();
			   driver.set(new InternetExplorerDriver());
		   }
		   
		   getDriver().manage().window().maximize();
		   getDriver().manage().deleteAllCookies();
		   getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		   getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
		   getDriver().get(prop.getProperty("url"));
		
	}
	
	public static void TearDown() {
		getDriver().quit();
	}
	
	@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
	public void AfterSuite() {
		ExtentManager.endReport();
	}

}
