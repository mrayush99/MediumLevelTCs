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
import com.training.pom.LoginPOM;
import com.training.pom.TC_FilterPOM;
import com.training.pom.TC_loginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
//import com.relevantcodes.extentreports.LogStatus;

public class TC_FilterTest {
	
	private WebDriver driver;
	private String baseUrl;
	private TC_loginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private TC_FilterPOM filterPOM;
	//ExtentTest logger;
	
	

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
		filterPOM = new TC_FilterPOM(driver);
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
	public void validFilterTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		loginPOM.clickcatalog();
		filterPOM.clickProducts();
		
		//Filter using ProductName
		filterPOM.entrprod("Integer vitae iaculis massa");
		Thread.sleep(3000);
		screenShot.captureScreenShot("First");
		
		//Filter using Price
		filterPOM.entrprice("515");
		System.out.println("Filter using price is successfull");
		Thread.sleep(2000);
		screenShot.captureScreenShot("second");
		
		//Filter using Status Enabled
		filterPOM.entrstatus();
		System.out.println("Filter using status is successfull");
		Thread.sleep(2000);
		screenShot.captureScreenShot("third");
		
		//Filter using Model
		filterPOM.entermodel("SKU-003");
		System.out.println("Filter using modelname is successfull");
		Thread.sleep(2000);
		screenShot.captureScreenShot("fourth");
		//Filter using Image Enabled
		
		filterPOM.enableimage();
		System.out.println("Filter using image-enabled is successfull");
		screenShot.captureScreenShot("fifth");
	}

}
