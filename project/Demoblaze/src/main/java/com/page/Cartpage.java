package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testbase.TestBase;
import com.utilities.Wrapper;

public class Cartpage extends TestBase {

	Wrapper wrobj = new Wrapper();
	
	
	@FindBy(id = "cartur")
	WebElement pCart;
	@FindBy(xpath = "//a[text()=\\\"Delete\\\"]")
	WebElement pDelete;
	@FindBy(xpath = "//button[text()=\"Place Order\"]")
	WebElement pOrderplace;
	
	@FindBy(id = "name")
	WebElement pName;
	@FindBy(id = "country")
	WebElement pCountry;
	@FindBy(id = "city")
	WebElement pCity;
	@FindBy(id = "card")
	WebElement CreditCard;
	@FindBy(id = "month")
	WebElement pMonth;
	@FindBy(id = "year")
	WebElement pYear;
	@FindBy(xpath = "//button[text()=\"Purchase\"]")
	
	WebElement pSubmit;
	@FindBy(xpath = "(//button[text()=\"Close\"])[3]")
	WebElement pClose;
	
	public Cartpage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void cart() {
		pCart.click();
	}
	
	public void delete() {
		wrobj.explicitWait(driver, pDelete);
		pDelete.click();
	}
	
	public void orderPlace() {
		pOrderplace.click();
	}
	
	public void enterValidata(String Name,String Country,String City,String	CreditCard,String Month, String	year) {
		
		
		pName.sendKeys(Name);
		
		pName.sendKeys(Country);
		
		pName.sendKeys(City);
		
		pName.sendKeys(CreditCard);
		
		pName.sendKeys(Month);
		
		pName.sendKeys(year);
		pSubmit.click();
		wrobj.explicitWaitAlert(driver);
		wrobj.alertClose(driver);
		
	}
	
	public void invaliData(String Name,String Country,String City,String CreditCard,String Month,String year) {
        pName.sendKeys(Name);
		
		pName.sendKeys(Country);
		
		pName.sendKeys(City);
		
		pName.sendKeys(CreditCard);
		
		pName.sendKeys(Month);
		
		pName.sendKeys(year);
		pSubmit.click();
		wrobj.explicitWaitAlert(driver);
		wrobj.alertClose(driver);
		
	}
	
	

	
	
}
