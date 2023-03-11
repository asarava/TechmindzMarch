package com.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;
import com.utilities.Wrapper;

public class LoginPage extends TestBase{
	Wrapper wrobj = new Wrapper();

	@FindBy(id = "login2")
	WebElement pLoginin;
	@FindBy(id = "loginusername")
	WebElement pLoginUserName;
	@FindBy(id = "loginpassword")
	WebElement pLoginPword;
	@FindBy(xpath = "(//button[@class=\"btn btn-primary\"])[3]")
	WebElement pLoginPwordButton;
	@FindBy(xpath = "(//button[@class=\"btn btn-secondary\"])[3]")
	WebElement pLoginClose;


	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickloginin(String uname,String pword) {
		pLoginin.click();
		wrobj.explicitWait(driver, pLoginPwordButton);
		pLoginUserName.clear();		
		pLoginUserName.sendKeys(uname);
		pLoginPword.clear();
		pLoginPword.sendKeys(pword);
		pLoginPwordButton.click();
		
		
		wrobj.explicitWaitAlert(driver);
		Alert alert = driver.switchTo().alert();
		String s1 = alert.getText();
		System.out.println("s1"+s1);
		wrobj.alertClose(driver);
		pLoginClose.click();

	}
}



