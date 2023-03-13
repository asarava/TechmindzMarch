package com.Utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Wrapper {
	public void explictWaitElementToBeClickable(WebDriver driver, WebElement pElement) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pElement));
	}

	public void scollElement(WebDriver driver, WebElement ele1) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);

	}

	public void AlertClose(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public void explictWaitAlert(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

	}

	public String alertText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		return alertText;

	}

	public void Cleardata(WebElement Username, WebElement Password) {
		Username.clear();
		Password.clear();

	}

	public void CheckPasswordlength(String pPassword) {
		int len = pPassword.length();
		if ((len < 6) || (len > 13)) {
			Assert.assertEquals(false, true);
		} else {
			Assert.assertEquals(true, true);
		}
	}

	public void ClearValues(WebElement Name, WebElement Country, WebElement City, WebElement Creditcard,
			WebElement Month, WebElement Year) {
		Name.clear();
		Country.clear();
		City.clear();
		Creditcard.clear();
		Month.clear();
		Year.clear();

	}
}
