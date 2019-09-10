package com.training.pom;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;


public class TC_RetailPOM {

private WebDriver driver; 
	
	public TC_RetailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(linkText="Integer Vitae Iaculis Massa")
	private WebElement product;
	
	@FindBy(id="button-cart")
	private WebElement cartbtn;
	
	@FindBy(xpath="//*[@id='cart']/ul/li/h3/a/i")
	private WebElement shopcart;
	
	@FindBy(xpath="//*[@id='cart']/ul/li/div/div/h3")
	private WebElement shopcartpopup;
	
	@FindBy(linkText="View Cart")
	private WebElement viewcart;
	
	
	
	@FindBy(xpath="//*[@id='cart_form']/div/table/thead/tr[1]/td[1]")
	private WebElement TE1;
	
	@FindBy(xpath="//*[@id='cart_form']/div/table/thead/tr[1]/td[2]")
	private WebElement TE2;
	
	@FindBy(xpath="//*[@id='cart_form']/div/table/thead/tr[1]/td[3]")
	private WebElement TE3;
	
	@FindBy(xpath="//*[@id='cart_form']/div/table/thead/tr[1]/td[4]")
	private WebElement TE4;
	
	@FindBy(xpath="//*[@id='cart_form']/div/table/thead/tr[1]/td[5]")
	private WebElement TE5;
	
	@FindBy(xpath="//*[@id='cart_form']/div/table/thead/tr[1]/td[6]")
	private WebElement TE6;
	
	@FindBy(xpath="//*[@id='cart_form']/div/table/tbody/tr/td[4]/div/input")
	private WebElement qnt;
	
	@FindBy(xpath="//*[@id='cart_form']/div/table/tbody/tr/td[4]/div/span/button[2]/i")
	private WebElement remove;
	
	@FindBy(xpath="//*[@id='System_V2Exp1o9']/div[1]/p")
	private WebElement empty;
	
	public void MO_product() {
		Actions actions = new Actions(driver);
		actions.moveToElement(product).perform();
		product.click();
	}
	public void Click_Cartbtn() {
		this.cartbtn.click(); 	
	}
	
	
	
	public void Click_remove() {
		this.cartbtn.click(); 	
	}
	
	public void MO_shopcart()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(shopcart).perform();
		Assert.assertEquals(true, this.shopcartpopup.isDisplayed());
		
		}
	

	public void Click_viewbtn() {
		this.viewcart.click(); 	
		Assert.assertEquals(true, this.TE1.isDisplayed());
		Assert.assertEquals(true, this.TE2.isDisplayed());
		Assert.assertEquals(true, this.TE3.isDisplayed());
		Assert.assertEquals(true, this.TE4.isDisplayed());
		Assert.assertEquals(true, this.TE5.isDisplayed());
		Assert.assertEquals(true, this.TE6.isDisplayed());
		
		
	}

	public void clrqnt(String a) {
		//this.qnt.clear();
		this.qnt.click();
		Actions actions = new Actions(driver);
		actions.doubleClick(qnt).perform();
		
		this.qnt.sendKeys(a);
		this.remove.click();
		Assert.assertEquals(true, this.empty.isDisplayed());

	}
	
	
    
}
	

