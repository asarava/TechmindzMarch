package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;
import com.Utilities.Wrapper;

public class AboutusPage extends TestBase {
	Wrapper wrrobj = new Wrapper();
	@FindBy(xpath = "//a[@data-target='#videoModal']")
	WebElement pAboutUs;

	@FindBy(xpath = "//button[@title='Play Video']")
	WebElement pPlayvideo;

	@FindBy(xpath = "//button[@title='Pause']")
	WebElement pPause;

	@FindBy(xpath = "//button[@title='Unmute']")
	WebElement pUnmute;

	@FindBy(xpath = "//button[@title='Mute']")
	WebElement pMute;

	@FindBy(xpath = "//button[@title='Fullscreen']")
	WebElement pFullscreen;

	@FindBy(xpath = "//button[@title='Non-Fullscreen']")
	WebElement pNonfullscreen;

	@FindBy(xpath = "(//button[text()='Close'])[4]")
	WebElement pAboutClose;

	@FindBy(id = "example-video-html5-api")
	WebElement pVideo;

	public AboutusPage() {
		PageFactory.initElements(driver, this);
	}

	public void PlayVideo() {
		wrrobj.explictWaitElementToBeClickable(driver, pAboutUs);
		pAboutUs.click();
		wrrobj.explictWaitElementToBeClickable(driver, pPlayvideo);
		pPlayvideo.click();

	}

	public void Screen() {
		wrrobj.explictWaitElementToBeClickable(driver, pFullscreen);
		pFullscreen.click();
		wrrobj.explictWaitElementToBeClickable(driver, pNonfullscreen);
		pNonfullscreen.click();

	}

	public void Volume() {
		wrrobj.explictWaitElementToBeClickable(driver, pMute);
		pMute.click();
		wrrobj.explictWaitElementToBeClickable(driver, pUnmute);
		pUnmute.click();

	}

	public void pause() {
		wrrobj.explictWaitElementToBeClickable(driver, pPause);
		pPause.click();
	}

	public void AboutusClose() {
		wrrobj.explictWaitElementToBeClickable(driver, pAboutClose);
		pAboutClose.click();

	}

}
