package com.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties propconfig;

	public TestBase() {
		propconfig = new Properties();
		try {
			FileInputStream fileConfig = new FileInputStream(
					"C:\\Users\\acer\\Desktop\\WorkSpace\\Project\\Assessment1\\src\\main\\java\\com\\config\\Config");
			propconfig.load(fileConfig);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initialization() {
		String browserName = propconfig.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(propconfig.getProperty("URL"));

	}
}