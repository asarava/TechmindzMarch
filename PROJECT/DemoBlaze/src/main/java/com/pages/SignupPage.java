package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TestBase.TestBase;
import com.Utilities.Wrapper;

public class SignupPage extends TestBase {
	Wrapper wrrobj = new Wrapper();
	@FindBy(id = "signin2")
	WebElement pSignUpButton;

	@FindBy(xpath = "(//*[@type='button'])[6]")
	WebElement pSignUpLog;

	@FindBy(id = "sign-username")
	WebElement pSignUserName;

	@FindBy(id = "sign-password")
	WebElement pSignPassword;

	@FindBy(xpath = "(//*[@type='button'])[5]")
	WebElement pSignUpClose;

	@FindBy(id = "nameofuser")
	WebElement pUsername;

	public SignupPage() {
		PageFactory.initElements(driver, this);
	}

	public String SigninwithValidusernameandPassword(String Username, String Password) {
		pSignUpButton.click();
		wrrobj.explictWaitElementToBeClickable(driver, pSignUserName);
		pSignUserName.sendKeys(Username);
		pSignPassword.sendKeys(Password);
		pSignUpLog.click();
		wrrobj.explictWaitAlert(driver);
		wrrobj.AlertClose(driver);
		pSignUpClose.click();
		wrrobj.Cleardata(pSignUserName, pSignPassword);
		return Password;
	}

	public String SigninwithAlreadyExistedUsernameandPassword(String Username, String Password) {
		pSignUpButton.click();
		wrrobj.explictWaitElementToBeClickable(driver, pSignUserName);
		pSignUserName.sendKeys(Username);
		pSignPassword.sendKeys(Password);
		pSignUpLog.click();
		wrrobj.explictWaitAlert(driver);
		wrrobj.alertText(driver);
		String Expectedmsg = "This user already exist.";
		wrrobj.AlertClose(driver);
		pSignUpClose.click();
		wrrobj.Cleardata(pSignUserName, pSignPassword);
		return Expectedmsg;
	}

	public String SigninwithEmptyUsenameandPassword() {
		pSignUpButton.click();
		wrrobj.explictWaitElementToBeClickable(driver, pSignUpLog);
		pSignUpLog.click();
		wrrobj.explictWaitAlert(driver);
		wrrobj.alertText(driver);
		String Expectedmsg = "Please fill out Username and Password.";
		wrrobj.AlertClose(driver);
		pSignUpClose.click();
		return Expectedmsg;

	}

	public String SigninwithUsernameOnly() {
		pSignUpButton.click();
		wrrobj.explictWaitElementToBeClickable(driver, pSignUpLog);
		pSignUserName.sendKeys("Username");
		pSignUpLog.click();
		wrrobj.explictWaitAlert(driver);
		wrrobj.alertText(driver);
		String Expectedmsg = "Please fill out Username and Password.";
		wrrobj.AlertClose(driver);
		pSignUpClose.click();
		wrrobj.Cleardata(pSignUserName, pSignPassword);
		return Expectedmsg;

	}

	public String signinwithPasswordonly() {
		pSignUpButton.click();
		wrrobj.explictWaitElementToBeClickable(driver, pSignUpLog);
		pSignPassword.sendKeys("password");
		wrrobj.CheckPasswordlength("password");
		pSignUpLog.click();
		wrrobj.explictWaitAlert(driver);
		wrrobj.alertText(driver);
		String Expectedmsg = "Please fill out Username and Password.";
		wrrobj.AlertClose(driver);
		pSignUpClose.click();
		wrrobj.Cleardata(pSignUserName, pSignPassword);
		return Expectedmsg;

	}

}