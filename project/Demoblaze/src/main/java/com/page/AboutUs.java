package com.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.testbase.TestBase;
import com.utilities.Wrapper;

public class AboutUs extends TestBase {

	Wrapper wrobj = new Wrapper();

	@FindBy(xpath = "//a[@data-target=\"#videoModal\"]")
	WebElement pAboutUs;
	@FindBy(xpath = "//button[@title=\"Play Video\"]")
	WebElement pPlayButton;
	@FindBy(xpath = "//button[@title=\"Pause\"]")
	WebElement pPauseButton;
	@FindBy(xpath = "//button[@title=\"Unmute\"]")
	WebElement pUnmuteAudio;
	@FindBy(xpath = "//button[@title=\"Mute\"]")
	WebElement pMuteAudio;
	@FindBy(xpath = "//button[@title=\"Fullscreen\"]")
	WebElement pFullScreen;
	@FindBy(xpath = "//button[@title=\"Non-Fullscreen\"]")
	WebElement pNonFullScreen;
	@FindBy(xpath = "(//button[@class=\"btn btn-secondary\"])[4]")
	WebElement pAboutUsClose;
	@FindBy(id = "example-video_html5_api")
	WebElement pVideo;
	public AboutUs() {
		PageFactory.initElements(driver, this);

	}

	public void clickAboutUs() {
		wrobj.explicitWait(driver, pAboutUs);
		pAboutUs.click();
	}

	public void play() {
		wrobj.explicitWait(driver, pPlayButton);

		pPlayButton.click();
	}

	public void pause() {
		wrobj.explicitWait(driver, pPauseButton);

		pPauseButton.click();
	}

	public void volumnMute() {
		wrobj.explicitWait(driver, pMuteAudio);
		pMuteAudio.click();

	}

	public void volumnUnMute() {
		wrobj.explicitWait(driver, pUnmuteAudio);
		pUnmuteAudio.click();

	}

	public void fullScreen() {
		wrobj.explicitWait(driver, pFullScreen);
		pFullScreen.click();
	}

	public void nonFullScreen() {
		wrobj.moveToElemenet(driver,pVideo);
		wrobj.explicitWait(driver, pNonFullScreen);
		pNonFullScreen.click();
	}

	public void aboutUsClose() {
		wrobj.explicitWait(driver, pAboutUsClose);
		pAboutUsClose.click();
	}

}
