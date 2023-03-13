package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TestBase.TestBase;
import com.Utilities.Wrapper;

public class LoginPage extends TestBase {

	Wrapper wrrobj = new Wrapper();

	@FindBy(id = "login2")
	WebElement pLogInButton;

	@FindBy(id = "loginusername")
	WebElement pLogInUserName;

	@FindBy(id = "loginpassword")
	WebElement pLogInPassword;

	@FindBy(xpath = "(//button[@type='button'])[9]")
	WebElement pLogIn;

	@FindBy(xpath = "(//button[@type='button'])[8]")
	WebElement pLogclose;

	@FindBy(id = "nameofuser")
	WebElement pUsername;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String LoginValidUsernameandInvalidPassword(String Username, String Password) {
		pLogInButton.click();
		wrrobj.explictWaitElementToBeClickable(driver, pLogInUserName);
		pLogInUserName.sendKeys(Username);
		pLogInPassword.sendKeys(Password);
		wrrobj.explictWaitElementToBeClickable(driver, pLogIn);
		pLogIn.click();
		wrrobj.explictWaitAlert(driver);
		wrrobj.alertText(driver);
		String Expectedmsg = "Wrong password.";
		wrrobj.AlertClose(driver);
		pLogclose.click();
		wrrobj.Cleardata(pLogInUserName, pLogInPassword);
		return Expectedmsg;
	}

	public String LoginInvalidUsernameandValidPassword(String Username, String Password) {
		pLogInButton.click();
		wrrobj.explictWaitElementToBeClickable(driver, pLogInUserName);
		pLogInUserName.sendKeys(Username);
		pLogInPassword.sendKeys(Password);
		wrrobj.explictWaitElementToBeClickable(driver, pLogIn);
		pLogIn.click();
		wrrobj.explictWaitAlert(driver);
		wrrobj.alertText(driver);
		String Expectedmsg = "User does not exist.";
		wrrobj.AlertClose(driver);
		pLogclose.click();
		wrrobj.Cleardata(pLogInUserName, pLogInPassword);
		return Expectedmsg;
	}

	public String LogValidUsernameandPassword(String Username, String Password) {
		pLogInButton.click();
		wrrobj.explictWaitElementToBeClickable(driver, pLogInUserName);
		pLogInUserName.sendKeys(Username);
		pLogInPassword.sendKeys(Password);
		wrrobj.explictWaitElementToBeClickable(driver, pLogIn);
		pLogIn.click();
		String pWelcomeUsername = pUsername.getText();
		System.out.println(pWelcomeUsername);
		return pWelcomeUsername;

	}
}
