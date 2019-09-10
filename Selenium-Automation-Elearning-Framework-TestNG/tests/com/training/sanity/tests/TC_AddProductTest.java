package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.TC_AddProductPOM;
import com.training.pom.TC_FilterPOM;
import com.training.pom.TC_loginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import common.Logger;
//import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;


public class TC_AddProductTest {

	private WebDriver driver;
	private String baseUrl;
	private TC_loginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private TC_AddProductPOM addProd;
	private TC_FilterPOM filterPOM;
	//Logger logger=Logger.getLogger("Log");
	//PropertyConfigurator.configure("log4j.properties");

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new TC_loginPOM(driver); 
		addProd = new TC_AddProductPOM(driver);
		filterPOM= new TC_FilterPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validateAddProductTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("LoggedIn");
		//click on catalog
		loginPOM.clickcatalog();
		//click on product
		filterPOM.clickProducts();
		screenShot.captureScreenShot("ss1");
		//click on addnew btn
		addProd.clickAddnew();
		//set product name
		addProd.Entrprodname("Finger Ring");
		//set metaData
		addProd.EntrMeta("Finger Ring for ladies");
		
		screenShot.captureScreenShot("ss2");
		Thread.sleep(3000);
		//click on data Tab
		addProd.clickDataTab();
		screenShot.captureScreenShot("ss3");
		//set model name
		addProd.EntrModel("SKU-012");
		addProd.InputPrice("500");
		screenShot.captureScreenShot("ss4");
		//set quantity
		addProd.InputQnt("50");
		screenShot.captureScreenShot("ss5");

		Thread.sleep(3000);
		//click on link Tab
		addProd.clickLinkTab();
		screenShot.captureScreenShot("ss6");
		//Set Category
		addProd.InputCategory("EARRINGS");
		screenShot.captureScreenShot("ss7");
		//Click on Save Btn
		addProd.ClickSaveBtn();
		screenShot.captureScreenShot("ss8");

	}
	
}
