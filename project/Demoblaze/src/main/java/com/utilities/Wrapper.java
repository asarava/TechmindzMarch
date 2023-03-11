package com.utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrapper {

	public void explicitWait(WebDriver driver, WebElement e1) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(e1));

	}

	public void alertClose(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public void explicitWaitAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

	}

	public void alertText(WebDriver driver) {
		
		
		System.out.println("working");
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("working");
		alert.accept();
		System.out.println(alertText);

		
	}
	
	
	public void moveToElemenet(WebDriver driver, WebElement ele) {
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();

	}
}
