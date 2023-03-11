package com.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testbase.TestBase;
import com.utilities.Wrapper;

public class Categories  extends TestBase{
	
	Wrapper wrobj = new Wrapper();
	@FindBy(xpath = "(//a[@class=\"list-group-item\"])[2]")
	WebElement pPhones;
	@FindBy(xpath = "(//a[@class=\"list-group-item\"])[3]")
	WebElement pLaptops;
	@FindBy(xpath = "(//a[@class=\"list-group-item\"])[4]")
	WebElement pScreen;
	@FindBy(xpath = "//*[text()=\"Samsung galaxy s6\"]")
	WebElement pItem;
	@FindBy(xpath = "//a[text()=\"Add to cart\"]")
	WebElement pAddtoCart;
	
	
	public Categories() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void categoriesclick() {
		wrobj.explicitWait(driver, pPhones);
		pPhones.click();
		pLaptops.click();
		
		pScreen.click();
		wrobj.explicitWait(driver, pPhones);
		pPhones.click();
		
	}
	
	public void selectItem() {
	wrobj.explicitWait(driver, pItem);
	pItem.click();
	wrobj.explicitWait(driver, pAddtoCart);
	pAddtoCart.click();
	
	wrobj.explicitWaitAlert(driver);
	wrobj.alertClose(driver);

	}

	
	public void serachAvail() {
		Assert.assertTrue(driver.getPageSource().contains("Search"));
		
		
	}
	
	
	public void reviewavail() {
		pPhones.click();
		Assert.assertTrue(driver.getPageSource().contains("Review"));
	
	}
	
	public void filterAvail() {
		pPhones.click();
		Assert.assertTrue(driver.getPageSource().contains("Filter"));
	
	}
	public void sortAvail() {
		pPhones.click();
		Assert.assertTrue(driver.getPageSource().contains("Sort"));
	
	}
}
