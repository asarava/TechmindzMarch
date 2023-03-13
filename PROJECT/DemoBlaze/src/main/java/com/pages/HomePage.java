package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TestBase.TestBase;
import com.Utilities.Wrapper;

public class HomePage extends TestBase {

	Wrapper wrrobj = new Wrapper();

	@FindBy(xpath = "(//a[@class='list-group-item'])[2]")
	WebElement pPhones;

	@FindBy(xpath = "//a[text()='Sony xperia z5']")
	WebElement pSony;

	@FindBy(xpath = "//a[@class='list-group-item'][3]")
	WebElement pLaptops;

	@FindBy(xpath = "//a[text()='MacBook Pro']")
	WebElement pMacBook;

	@FindBy(xpath = "(//a[@class='list-group-item'])[4]")
	WebElement pMonitors;

	@FindBy(xpath = "(//a[@class='hrefch'])[2]")
	WebElement pASUS;

	@FindBy(xpath = "//a[@onclick='addToCart(14)']")
	WebElement pAddToCart;

	@FindBy(xpath = "//a[text()='Search']")
	WebElement pSearch;

	@FindBy(xpath = "(//a[@class='nav-link'])[1]")
	WebElement pHome;

	@FindBy(xpath = "//a[@onclick='addToCart(6)']")
	WebElement pAddToCarts;

	@FindBy(xpath = "//a[text()='Review']")
	WebElement pReview;

	@FindBy(xpath = "//*[text()='Filters']")
	WebElement pFilters;

	@FindBy(xpath = "//*[text()='Sort By']")
	WebElement pSortBy;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void ClickPhones() {
		pPhones.click();
		wrrobj.explictWaitElementToBeClickable(driver, pLaptops);

	}

	public void ClickLaptops() {
		pLaptops.click();
		wrrobj.explictWaitElementToBeClickable(driver, pMonitors);

	}

	public String ClickMonitors() {
		pHome.click();
		wrrobj.explictWaitElementToBeClickable(driver, pMonitors);
		pMonitors.click();
		wrrobj.explictWaitElementToBeClickable(driver, pASUS);
		pASUS.click();
		wrrobj.explictWaitElementToBeClickable(driver, pAddToCart);
		pAddToCart.click();
		wrrobj.explictWaitAlert(driver);
		String Actualmsg = wrrobj.alertText(driver);
		wrrobj.AlertClose(driver);
		return Actualmsg;

	}

	public String Addtocart() {
		pHome.click();
		pPhones.click();
		wrrobj.explictWaitElementToBeClickable(driver, pSony);
		pSony.click();
		wrrobj.explictWaitElementToBeClickable(driver, pAddToCarts);
		pAddToCarts.click();
		wrrobj.explictWaitAlert(driver);
		String Actualmsg = wrrobj.alertText(driver);
		wrrobj.AlertClose(driver);
		return Actualmsg;

	}

	public void ClickSearch() {
		pHome.click();
		pSearch.click();
		wrrobj.explictWaitElementToBeClickable(driver, pPhones);

	}

	public void ClickReview() {
		pPhones.click();
		wrrobj.explictWaitElementToBeClickable(driver, pSony);
		pSony.click();
		wrrobj.explictWaitElementToBeClickable(driver, pReview);
		pReview.click();

	}

	public void ClickFiltersAndSortBy() {
		pHome.click();
		wrrobj.explictWaitElementToBeClickable(driver, pLaptops);
		pLaptops.click();
		wrrobj.explictWaitElementToBeClickable(driver, pFilters);
		pFilters.click();
		wrrobj.explictWaitElementToBeClickable(driver, pSortBy);
		pSortBy.click();

	}

}