package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TC_DltCategoryPOM {
	private WebDriver driver; 
	
	public TC_DltCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="input-username")
	private WebElement userName; 

	
	@FindBy(xpath = "//*[@id='form-category']/div/table/tbody/tr[1]/td[1]")
    private WebElement dltcat;
	
	@FindBy(xpath = "//*[@id='content']/div[1]/div/div/button/i")
    private WebElement deletebtn;
	
	@FindBy(xpath = "//*[@id='content']/div[2]/div[1]")
    private WebElement success;

	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	
	public void clickDeleteBtn() throws InterruptedException {
		Assert.assertEquals(false, this.dltcat.isSelected());
		
		this.deletebtn.click(); 
		
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	public void checkcategory() throws InterruptedException {
		this.dltcat.click();
		Thread.sleep(2000);
		Assert.assertEquals(true, this.success.isDisplayed());		
	}
	
}
