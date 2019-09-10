package com.training.sanity.tests;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.TC_loginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC_loginTest {
	private WebDriver driver;
	private String baseUrl;
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
	public void validLoginTest() {
		//this function is to login into the admin workspace
		
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		String ActualTitle="Dashboard";
		String ExpectedTitle=driver.getTitle();
		AssertJUnit.assertEquals(ActualTitle, ExpectedTitle);
		
		//screenShot.captureScreenShot("First");
	}
	
	//this function is to validate the elements present in cateogories link
	@Test(dependsOnMethods = {"validLoginTest"})
	public void validateCateogories() throws InterruptedException {
		//this function will click on catalog option
		loginPOM.clickcatalog();
		Thread.sleep(3000);
		//this will select and click categories link from the menu
		loginPOM.clickcateogories();
		Thread.sleep(3000);
		
					
		
	}

}
