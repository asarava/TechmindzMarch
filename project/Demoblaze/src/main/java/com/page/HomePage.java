package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;
import com.utilities.Wrapper;

public class HomePage extends TestBase {
	Wrapper wrobj = new Wrapper();
	/*@FindBy(id = "signin2")
	WebElement pSignIn;
	@FindBy(id = "sign-username")
	WebElement pSingnUsername;
	@FindBy(id = "sign-password")
	WebElement pSingnPword;
	@FindBy(xpath = "(//button[@class=\"btn btn-primary\"])[2]")
	WebElement pSigninButton;*/
	@FindBy(id = "login2")
	WebElement pLoginin;
	@FindBy(id = "loginusername")
	WebElement pLoginUserName;
	@FindBy(id = "loginpassword")
	WebElement pLoginPword;
	@FindBy(xpath = "(//button[@class=\"btn btn-primary\"])[3]")
	WebElement pLoginPwordButton;
	@FindBy(id = "nameofuser")
	WebElement pUsename;
	
	@FindBy(xpath = "//*[text()=\"Contact\"]")
	WebElement pContactButton;
	@FindBy(xpath = "//*[text()=\"Send message\"]")
	WebElement pSendButton;
	@FindBy(id = "recipient-name")
	WebElement pNameSend;
	@FindBy(id = "recipient-email")
	WebElement pUserNameSend;
	@FindBy(id = "message-text")
	WebElement pMsgSend;
	@FindBy(xpath = "(//*[text()=\"About us\"])[2]")
	WebElement pAboutUsButton;
	@FindBy(xpath = "(//button[@class=\"btn btn-secondary\"])[4]")
	WebElement pCloseAboutUS;
	@FindBy(xpath = "(//button[@data-dismiss=\"modal\"])[4]")
	WebElement pSignUpClose;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
// Sign in

	/*public void clickSignin(String uname,String pword) {
		pSignIn.click();
		wrobj.explicitWait(driver, pSigninButton);
		pSingnUsername.clear();		
		pSingnUsername.sendKeys(uname);
		pSingnPword.clear();
		pSingnPword.sendKeys(pword);
		pSigninButton.click();
		wrobj.explicitWaitAlert(driver);
		wrobj.alertClose(driver);
		pSignUpClose.click();

	}*/

	// Login

	public void login() {
		pLoginin.click();
		wrobj.explicitWait(driver, pLoginUserName);
		pLoginUserName.sendKeys("Sreeshmang123yy");
		pLoginPword.sendKeys("Sreeshmang123");
		pLoginPwordButton.click();
		wrobj.explicitWait(driver, pUsename);
		String pWelcomeUsername = pUsename.getText();
		System.out.print(pWelcomeUsername);

	}

	// Send message without message

	/*public String contactEmptySendMessage() {

		pContactButton.click();
		wrobj.explicitWait(driver, pSendButton);
		pSendButton.click();
		wrobj.explicitWaitAlert(driver);
	//	String textMsg = wrobj.alertText(driver);
		//return textMsg;

	}
// Send message with message

	public String contactSendMessage() {
		wrobj.alertClose(driver);
		pContactButton.click();
		wrobj.explicitWait(driver, pSendButton);
		pUserNameSend.sendKeys("Sreeshmang123yy");
		pNameSend.sendKeys("Sreeshma");
		pMsgSend.sendKeys("HI How are u");
		pSendButton.click();
		wrobj.explicitWaitAlert(driver);
		//String textMsg = wrobj.alertText(driver);
		wrobj.alertClose(driver);
		//return textMsg;

	}
	// About us

	public void aboutUs() {

		wrobj.explicitWait(driver, pAboutUsButton);
		pAboutUsButton.click();
		wrobj.explicitWait(driver, pCloseAboutUS);
		pCloseAboutUS.click();

	}*/
	
}
