package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.TC_DltCategoryPOM;
import com.training.pom.TC_loginPOM;
import com.training.sanity.tests.TC_loginTest;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import java.util.Properties;

public class TC_DltCategoryTest {
	
	private WebDriver driver;
	private TC_loginTest a;
	private String baseUrl;
	private TC_DltCategoryPOM dltcatPOM;
	private TC_loginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	
	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	
	@BeforeTest
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new TC_loginPOM(driver); 
	    dltcatPOM = new TC_DltCategoryPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest()
	
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		
	}

	@Test
	public void DeleteCategoryTest() throws InterruptedException {
		//this function is to login into the admin workspace
		
		
		//a.validLoginTest();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		String ActualTitle="Dashboard";
		String ExpectedTitle=driver.getTitle();
		AssertJUnit.assertEquals(ActualTitle, ExpectedTitle);
		//this function will click on catalog option
		loginPOM.clickcatalog();
		Thread.sleep(3000);
		screenShot.captureScreenShot("ss1");
		
		//this will select and click categories link from the menu
		loginPOM.clickcateogories();
		screenShot.captureScreenShot("ss2");
		
		dltcatPOM.checkcategory();
		screenShot.captureScreenShot("ss3");
	
		dltcatPOM.clickDeleteBtn();
	screenShot.captureScreenShot("ss4");
	
	}
	
}
