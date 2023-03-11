package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;
import com.utilities.Wrapper;

public class Contact extends TestBase {

	Wrapper wrobj = new Wrapper();
	@FindBy(xpath = "//a[text()=\"Contact\"]")
	WebElement pContact;
	@FindBy(id = "recipient-email")
	WebElement pEmail;
	@FindBy(id = "recipient-name")
	WebElement pname;
	@FindBy(id = "message-text")
	WebElement pmessage;
	@FindBy(xpath = "(//button[text()=\"Close\"])[1]")
	WebElement pClose;
	@FindBy(xpath = "(//button[text()=\"Send message\"])")
	WebElement pSendMsg;
	
	
	
	public Contact() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickContact() {
		
		pContact.click();
		
	}
	public void validData(String mail,String Name,String msg) {
		wrobj.explicitWait(driver, pSendMsg);
		pContact.sendKeys(mail);
		pname.sendKeys(Name);
		pmessage.sendKeys(msg);
		pSendMsg.click();
		wrobj.explicitWaitAlert(driver);
		wrobj.alertClose(driver);
		
		
	}
	public void invalidData(String mail,String Name,String msg) {
		wrobj.explicitWait(driver, pSendMsg);
		pContact.sendKeys(mail);
		pname.sendKeys(Name);
		pmessage.sendKeys(msg);
		pSendMsg.click();
		wrobj.explicitWaitAlert(driver);
		wrobj.alertClose(driver);
		
		
	}
	public void validDatamsg100(String mail,String Name,String msg) {
		wrobj.explicitWait(driver, pSendMsg);
		pContact.sendKeys(mail);
		pname.sendKeys(Name);
		pmessage.sendKeys(msg);
		pSendMsg.click();
		wrobj.explicitWaitAlert(driver);
		wrobj.alertClose(driver);
		
		
	}
}
