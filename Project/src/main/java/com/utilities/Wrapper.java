package com.utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrapper {
	public void explictWaitElementToBeClickable(WebDriver driver, WebElement pElement) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pElement));
	}
	public void AlertClose(WebDriver driver) {
		Alert alert= driver.switchTo().alert();
		alert.accept();
		
	}
	public void explictWaitAlert(WebDriver driver) {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.alertIsPresent());
	
}
	public String alertText(WebDriver driver) {
		Alert alert =driver.switchTo().alert();
		String alertText =alert.getText();
		return alertText;
		
	}
	}


