package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TC_AddProductPOM {


private WebDriver driver; 
	
	public TC_AddProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='content']/div[1]/div/div/a")
    private WebElement addnew;
	
	@FindBy(xpath = "//*[@id='content']/div[2]/div/div[1]/h3")
    private WebElement title;
	
	@FindBy(id = "input-name1")
    private WebElement prodname;
	
	@FindBy(id = "input-meta-title1")
    private WebElement metainput;
	
	@FindBy(linkText ="Data")
    private WebElement DataTab;
	
	@FindBy(id ="input-model")
    private WebElement modelname;
	
	@FindBy(id ="input-price")
    private WebElement inputprice;

	@FindBy(id ="input-quantity")
    private WebElement inputqnt;
		
	@FindBy(linkText ="Links")
    private WebElement LinksTab;
	
	@FindBy(id ="input-category")
    private WebElement inputCategory;
	
	@FindBy(xpath = "//*[@id='content']/div[1]/div/div/button")
    private WebElement savebtn;
	
	@FindBy(xpath = "//*[@id='content']/div[2]/div[1]")
    private WebElement success;
	
	
	
    public void clickAddnew() {
		this.addnew.click(); 
	}
	
    public void Entrprodname(String a) {
	    this.prodname.clear();
		this.prodname.sendKeys(a);
    }
    
    public void EntrMeta(String a) {
	    this.metainput.clear();
		this.metainput.sendKeys(a);
    }
	
    public void clickDataTab() {
		this.DataTab.click(); 
	}
    
    public void EntrModel(String a) {
	    this.modelname.clear();
		this.modelname.sendKeys(a);
    }
    
    public void InputPrice(String a) {
	    this.inputprice.clear();
		this.inputprice.sendKeys(a);
    }
    
    public void InputQnt(String a) {
	    this.inputqnt.clear();
		this.inputqnt.sendKeys(a);
    }
    
    public void clickLinkTab() {
		this.LinksTab.click(); 
	}
    
    public void InputCategory(String a) {
	    this.inputCategory.clear();
		this.inputCategory.sendKeys(a);
    }
    public void ClickSaveBtn() {
		this.savebtn.click(); 
		Assert.assertEquals(true, this.success.isDisplayed());
	}
    
}
