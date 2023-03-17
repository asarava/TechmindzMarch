package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testbase.TestBase;
import com.utilities.Wrapper;

public class HomePage extends  TestBase {
	Wrapper Wrppobj = new Wrapper();
	
	@FindBy(id="signin2")
	WebElement pSignUpButton;
	
	@FindBy(id="sign-username")
	WebElement pSignUserName;
	
	@FindBy(id="sign-password")
	WebElement pSignPassword;
	
	@FindBy(xpath="(//*[@type='button'])[5]")
	WebElement pSignUpClose;
	
	@FindBy(id="login2")
	WebElement pLogInButton;
	
	@FindBy(id="loginusername")
	WebElement pLogInUserName;
	
	@FindBy(id="loginpassword")
	WebElement pLogInPassword;
	
	@FindBy(xpath="//*[@type='button'])[9]")
	WebElement pLogIn;
	
	@FindBy(xpath="(//[@type='button'][1]")
	WebElement pLogInClose;
	
	@FindBy(id="catur")
	WebElement pCartButton;
	
	@FindBy(xpath="(//[@type='button']")
	WebElement pPlaceOrder;
	
	@FindBy(id="name")
	WebElement pname;
	
	@FindBy(id="country")
	WebElement pCountry;
	
	@FindBy(id="city")
	WebElement pCity;
	
	@FindBy(id="card")
	WebElement pCard;
	
	@FindBy(id="month")
	WebElement pMonth;
	
	@FindBy(id="year")
	WebElement pYear;
	
	@FindBy(xpath="//button[text()='purchase']")
	WebElement pPurchaseButton;
	
	
	
	
	@FindBy(xpath="(//[@class='nav-linl'])[2]")
	WebElement pContact;
	
	@FindBy(xpath="(//button[@type='bbutton'])[3]")
	WebElement pSendMessage;
	
	@FindBy(id="recipient-email")
	WebElement pEmail;
	
	@FindBy(id="recipient-name")
	WebElement pName;
	
	@FindBy(id="message-text")
	WebElement pText;
	
	
	
	@FindBy(xpath="//a[@class='nav-link'])[3]")
	WebElement pAboutUsButton;
	
	@FindBy(xpath="(//button[@type='button'])[25]")
	WebElement pCloseAboutUs;
	
	@FindBy(xpath="(//a[text()='Phones']")
	WebElement pPhones;
	
	@FindBy(xpath="//a[text()='Laptops]")
	WebElement pLaptops;
	
	@FindBy(xpath="//a[text()='Moniotrs]")
	WebElement pMonitors;
	
	@FindBy(xpath="//a[text()'Serach']")
	WebElement pSearch;
	
	@FindBy(xpath="//a[text()'Review']")
	WebElement pReview;
	
	@FindBy(xpath="//a[text()'VoiceSearch']")
	WebElement pVoiceSearch;
	
	@FindBy(xpath="//a[text()'Filter']")
	WebElement pFilter;
	
	@FindBy(xpath="//a[text()'SortOption']")
	WebElement pSortOption;
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	public void clickSignUpButton() {
		pSignUpButton.click();
	}
	public String clickSignUpBitton(String Username, String Password) {
		pSignUpButton.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pSignUserName);
		pSignUserName.sendKeys(Username);
		pSignPassword.sendKeys(Password);
		Wrppobj.explictWaitAlert(driver);
		Wrppobj.AlertClose(driver);
		pSignUpClose.click();
		return Password;
		
	}
	
	
	public String ClickSignUpButton(String UserName) {
		pSignUpButton.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pSignPassword);
		pSignUserName.sendKeys(UserName);
		Wrppobj.explictWaitAlert(driver);
		Wrppobj.AlertClose(driver);
		return UserName;
	}
	public String SignUpButton(String Password) {
		pSignUpButton.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pSignUpButton);
		pSignPassword.sendKeys(Password);
		Wrppobj.explictWaitAlert(driver);
		Wrppobj.AlertClose(driver);
		return Password;
	}
	public String clickLogin(String UserName, String Password) {
		pLogInButton.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pLogInUserName);
		pLogInUserName.sendKeys(UserName);
		pLogInPassword.sendKeys(Password);
		pLogInButton.click();
		Wrppobj.explictWaitAlert(driver);
		String pWelcomeUsername =pLogInUserName.getText();
		System.out.println(pWelcomeUsername);
		return pWelcomeUsername;
	}
	public String Login(String UserName, String InvalidPassword) {
		pLogInButton.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pLogInButton);
		pLogInUserName.sendKeys(UserName);
		pLogInButton.sendKeys(InvalidPassword);
		Wrppobj.explictWaitAlert(driver);
		Wrppobj.AlertClose(driver);
		return UserName;
		
	
}
	public String clickonLogin(String invalidUserName,  String Password) {
		pLogInButton.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pLogInPassword);
		pLogInUserName.sendKeys(invalidUserName);
		pLogInPassword.sendKeys(Password);
		Wrppobj.explictWaitAlert(driver);
		Wrppobj.AlertClose(driver);
		return Password;
	}
	public String ClickOnLogin (String invalidUserName,  String invalidPassword) {
		pLogInButton.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pLogInButton);
		pLogInUserName.sendKeys(invalidUserName);
		pLogInPassword.sendKeys(invalidPassword);
		Wrppobj.explictWaitAlert(driver);
		Wrppobj.AlertClose(driver);
		pLogInClose.click();
		return invalidUserName;
	}
	
	public void clickCartButton() {
		pCartButton.click();
	}
	
	public  String clickCart(String name, String Country, String City, String Card, String Month, String Year) {
		pPurchaseButton.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pname);
		pname.sendKeys(name);
		pCountry.sendKeys(Country);
		pCity.sendKeys(City);
		pCard.sendKeys(Card);
		pMonth.sendKeys(Month);
		pYear.sendKeys(Year);
		Wrppobj.explictWaitAlert(driver);
		Wrppobj.AlertClose(driver);
		pPurchaseButton.click();
		return name;
		
	}
	public void clickAboutUs() {
		pAboutUsButton.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pAboutUsButton);
		pCloseAboutUs.click();
	}
	
	public String validContactdatas(String Email, String Name, String Text) {
		Wrppobj.AlertClose(driver);
		Wrppobj.explictWaitElementToBeClickable(driver, pEmail);
		pEmail.sendKeys(Email);
		pName.sendKeys(Name);
		pText.sendKeys(Text);
		pSendMessage.click();
		Wrppobj.explictWaitAlert(driver);
		String Textmsg = Wrppobj.alertText(driver);
		Wrppobj.AlertClose(driver);
		return Textmsg;
	}
	
	public String invalidContactdatas(String Email,String Name, String Text) {
		pContact.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pSendMessage);
		pSendMessage.click();
		Wrppobj.alertText(driver);
		String textmsg= Wrppobj.alertText(driver);
		return textmsg;
	}
	public void Phones() {
		pPhones.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pLaptops);
	}
	public void Laptops() {
		pLaptops.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pMonitors);
	}
	
	public void Monitors() {
		pMonitors.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pMonitors);
	}
	
	public void Search() {
		pSearch.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pReview);
		Assert.assertFalse(false);
	}
	
	public void Review() {
		pReview.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pReview);
		Assert.assertFalse(false);
	}
	
	public void VoiceSeach() {
		pVoiceSearch.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pVoiceSearch);
		Assert.assertFalse(false);
	}
	
	public void Filter() {
		pFilter.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pFilter);
		Assert.assertFalse(false);
	}
	public void SortOption() {
		pSortOption.click();
		Wrppobj.explictWaitElementToBeClickable(driver, pSortOption);
		Assert.assertFalse(false);
	}
	
	
	
	
	
	
	
	
	
}

