package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC_FilterPOM {

private WebDriver driver; 
	
	public TC_FilterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@id='menu-catalog']/ul/li[2]/a")
    private WebElement products;
	
	@FindBy(xpath = "//*[@id='content']/div[2]/div/div[1]/h3")
    private WebElement productlist;
	
	
	@FindBy(id="input-name")
	private WebElement ProdName; 
	
	@FindBy(id="button-filter")
	private WebElement Filterbtn; 
	
	
	@FindBy(id="input-price")
	private WebElement Pricetxt; 
	
	@FindBy(id="input-status")
	private WebElement status; 
	
	@FindBy(id="input-model")
	private WebElement modelname; 
	
	@FindBy(id="input-image")
	private WebElement image; 
	
	@FindBy(xpath = "//*[@id='form-product']/div/table/tbody")
    private WebElement searchresult;

	
	
	
	public void clickProducts() {
		
		this.products.click(); 
	}
	
	//filter using productname
	public void entrprod(String a) {
	    this.ProdName.clear();
		this.ProdName.sendKeys(a);
		this.Filterbtn.click();
		Assert.assertEquals(true, this.searchresult.isDisplayed());

		}
	
	//filter using price
	public void entrprice(String a) {
	    this.ProdName.clear();
		this.Pricetxt.sendKeys(a);
		this.Filterbtn.click();
		Assert.assertEquals(true, this.searchresult.isDisplayed());
		}
	
	//filter using status enabled
	public void entrstatus() {
	    this.ProdName.clear();
		this.Pricetxt.clear();
		Select bc = new Select(status);
		bc.selectByIndex(1);
		this.Filterbtn.click();
		Assert.assertEquals(true, this.searchresult.isDisplayed());
		}
	//filter using modelname
	public void entermodel(String a) {
	    this.ProdName.clear();
		this.Pricetxt.clear();
		this.modelname.sendKeys(a);
		Select bc = new Select(status);
		bc.selectByIndex(0);
		this.Filterbtn.click();
		Assert.assertEquals(true, this.searchresult.isDisplayed());
		}

	//filter using image-enabled
	public void enableimage() {
	    this.ProdName.clear();
		this.Pricetxt.clear();
		this.modelname.clear();
		Select bc = new Select(status);
		bc.selectByIndex(0);
		Select bc1 = new Select(image);
		bc1.selectByIndex(1);
		this.Filterbtn.click();
		Assert.assertEquals(true, this.searchresult.isDisplayed());
		}
	
	
	}

	

