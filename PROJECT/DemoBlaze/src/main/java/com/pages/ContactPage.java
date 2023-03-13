package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TestBase.TestBase;
import com.Utilities.Wrapper;

public class ContactPage extends TestBase {
	Wrapper wrrobj = new Wrapper();
	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	WebElement pContact;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	WebElement pSendmessage;

	@FindBy(id = "recipient-email")
	WebElement pEmail;

	@FindBy(id = "recipient-name")
	WebElement pName;

	@FindBy(id = "message-text")
	WebElement pText;

	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	public String ContactWithValidData(String Email, String Name, String Text) {
		wrrobj.explictWaitElementToBeClickable(driver, pContact);
		pContact.click();
		wrrobj.explictWaitElementToBeClickable(driver, pEmail);
		pEmail.sendKeys(Email);
		pName.sendKeys(Name);
		pText.sendKeys(Text);
		pSendmessage.click();
		wrrobj.explictWaitAlert(driver);
		wrrobj.alertText(driver);
		String Expectedmsg="Thanks for the message!!";
		wrrobj.AlertClose(driver);
		return Expectedmsg;
		
	}

	public String ContactWithEmptyData() {
		wrrobj.explictWaitElementToBeClickable(driver, pContact);
		pContact.click();
		wrrobj.explictWaitElementToBeClickable(driver, pSendmessage);
		pSendmessage.click();
		wrrobj.explictWaitAlert(driver);
		wrrobj.alertText(driver);
		String Expectedmsg="Error message";
		wrrobj.AlertClose(driver);
		return Expectedmsg;
		

	}
	public String ContactWithInvalidData(String Email, String Name, String Text) {
		pContact.click();
		wrrobj.explictWaitElementToBeClickable(driver, pEmail);
		pEmail.sendKeys(Email);
		pName.sendKeys(Name);
		pText.sendKeys(Text);
		pSendmessage.click();
		wrrobj.explictWaitAlert(driver);
		wrrobj.alertText(driver);
		String Expectedmsg="Error message";
	    wrrobj.AlertClose(driver);
		return Expectedmsg;
	}

	

}
