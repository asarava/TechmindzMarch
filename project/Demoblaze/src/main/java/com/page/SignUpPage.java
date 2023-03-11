package com.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;
import com.utilities.Wrapper;

public class SignUpPage extends TestBase{
	Wrapper wrobj = new Wrapper();

	@FindBy(id = "signin2")
	WebElement pSignIn;
	@FindBy(id = "sign-username")
	WebElement pSingnUsername;
	@FindBy(id = "sign-password")
	WebElement pSingnPword;
	@FindBy(xpath = "(//button[@class=\"btn btn-primary\"])[2]")
	WebElement pSigninButton;
	@FindBy(xpath = "(//button[@data-dismiss=\"modal\"])[4]")
	WebElement pSignUpClose;
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignin(String uname,String pword) {
		pSignIn.click();
		wrobj.explicitWait(driver, pSigninButton);
		pSingnUsername.clear();		
		pSingnUsername.sendKeys(uname);
		pSingnPword.clear();
		pSingnPword.sendKeys(pword);
		pSigninButton.click();
		wrobj.explicitWaitAlert(driver);
		Alert alert = driver.switchTo().alert();
		String s1 = alert.getText();
	
		wrobj.alertClose(driver);
		pSignUpClose.click();

	}
}



