package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;
import com.Utilities.Wrapper;

public class CartPage extends TestBase {
	Wrapper wrrobj = new Wrapper();
	@FindBy(id = "cartur")
	WebElement pCart;

	@FindBy(xpath = "(//a[text()='Delete'])[1]")
	WebElement pDeleteFirstItem;

	@FindBy(xpath = "(//button[@type='button'])[30]")
	WebElement pPlaceorder;

	@FindBy(id = "name")
	WebElement pName;

	@FindBy(id = "country")
	WebElement pCountry;

	@FindBy(id = "city")
	WebElement pcity;

	@FindBy(id = "card")
	WebElement pCreditcard;

	@FindBy(id = "month")
	WebElement pMonth;

	@FindBy(id = "year")
	WebElement pYear;

	@FindBy(xpath = "//button[text()='Purchase']")
	WebElement pPurchase;

	@FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
	WebElement pOK1;

	@FindBy(xpath = "(//button[@class='btn btn-secondary'])[3]")
	WebElement pClose1;

	@FindBy(xpath = "//button[text()='Close'][3]")
	WebElement pClose2;

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	public void cart() {
		wrrobj.explictWaitElementToBeClickable(driver, pCart);
		wrrobj.explictWaitElementToBeClickable(driver, pCart);
		pCart.click();

	}

	public void DeleteFromCart() {
		wrrobj.explictWaitElementToBeClickable(driver, pDeleteFirstItem);
		wrrobj.explictWaitElementToBeClickable(driver, pDeleteFirstItem);
		pDeleteFirstItem.click();

	}

	public String orderwithEmptydata() {
		wrrobj.explictWaitElementToBeClickable(driver, pPlaceorder);
		pPlaceorder.click();
		wrrobj.explictWaitElementToBeClickable(driver, pPurchase);
		pPurchase.click();
		wrrobj.explictWaitAlert(driver);
		wrrobj.alertText(driver);
		String Expectedmsg = "Please enter valid datas";
		wrrobj.AlertClose(driver);
		pClose1.click();
		return Expectedmsg;

	}

	public String orderwithInvaliddata(String Name, String Country, String City, String Creditcard, String Month,
			String Year) {
		pPlaceorder.click();
		wrrobj.explictWaitElementToBeClickable(driver, pPurchase);
		pName.sendKeys(Name);
		pCountry.sendKeys(Country);
		pcity.sendKeys(City);
		pCreditcard.sendKeys(Creditcard);
		pMonth.sendKeys(Month);
		pYear.sendKeys(Year);
		pPurchase.click();
		wrrobj.explictWaitElementToBeClickable(driver, pOK1);
		pOK1.click();
		wrrobj.explictWaitElementToBeClickable(driver, pClose1);
		pClose1.click();
		String Expectedmsg = "Please enter valid datas";
		wrrobj.ClearValues(pName, pCountry, pcity, pCreditcard, pMonth, pYear);
		return Expectedmsg;

	}

	public String OrderWithValiddata(String Name, String Country, String City, String Creditcard, String Month,
			String Year) {
		pPlaceorder.click();
		wrrobj.explictWaitElementToBeClickable(driver, pPurchase);
		pName.sendKeys(Name);
		pCountry.sendKeys(Country);
		pcity.sendKeys(City);
		pCreditcard.sendKeys(Creditcard);
		pMonth.sendKeys(Month);
		pYear.sendKeys(Year);
		pPurchase.click();
		wrrobj.explictWaitElementToBeClickable(driver, pOK1);
		pOK1.click();
		String Expectedmsg = "Thank you for your purchase!";
		return Expectedmsg;

	}

}
