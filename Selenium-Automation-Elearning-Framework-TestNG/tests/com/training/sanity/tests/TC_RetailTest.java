package com.training.sanity.tests;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import com.training.generics.ScreenShot;
import com.training.pom.TC_RetailPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC_RetailTest {
	private WebDriver driver;
	private String baseUrl;
	private TC_RetailPOM retailTest;
	private static Properties properties;

	@BeforeSuite
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	
	@BeforeTest
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retailTest = new TC_RetailPOM (driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterTest()
	
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		
	}

		@Test
		public void AddtoCart() throws InterruptedException {
			//to move to the given product and click on it
			retailTest.MO_product();
			String ActualTitle="Integer Vitae Iaculis Massa";
			String ExpectedTitle=driver.getTitle();
			AssertJUnit.assertEquals(ActualTitle, ExpectedTitle);
			//to click on add to cart button
			retailTest.Click_Cartbtn();
			Thread.sleep(11000);
			//to move to the shopping cart
			retailTest.MO_shopcart();
			//to click on view cart from the cart drop-down
			retailTest.Click_viewbtn();
			Thread.sleep(3000);
			//to change the quantity to zero
			retailTest.clrqnt("0");
			Thread.sleep(5000);
			String ActualTitle1="Shopping Cart";
			String ExpectedTitle1=driver.getTitle();
			AssertJUnit.assertEquals(ActualTitle, ExpectedTitle);
			
				
		}
	
}