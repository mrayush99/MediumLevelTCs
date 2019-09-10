package com.training.pom;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TC_loginPOM {
private WebDriver driver; 
	
	public TC_loginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id='content']/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement loginBtn; 

	@FindBy(xpath = "//*[@id='menu-catalog']/a/i")
    private WebElement catalog;
	
	@FindBy(xpath = "//*[@id='menu-catalog']/ul/li[1]/a")
    private WebElement cateogories;
	
	@FindBy(linkText="Categories")
	private WebElement category;
	
	@FindBy(linkText="Products")
	private WebElement Products;
	
	@FindBy(linkText="Category Name")
	private WebElement CategoryName;
	
	@FindBy(linkText="Sort Order")
	private WebElement SortOrder;

	@FindBy(xpath = "//*[@id='form-category']/div/table/thead/tr/td[4]")
    private WebElement actions;

	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickcatalog() {
	this.catalog.click();
	
	Assert.assertEquals(true, this.category.isDisplayed());
	
	Assert.assertEquals(true, this.Products.isDisplayed());
	
	}
	
	public void clickcateogories() {
	this.category.click();
		
		Assert.assertEquals(true, this.CategoryName.isDisplayed());
		Assert.assertEquals(true, this.SortOrder.isDisplayed());
		 Assert.assertEquals(true, this.actions.isDisplayed());
			}
	
		
			}
	
	
	

