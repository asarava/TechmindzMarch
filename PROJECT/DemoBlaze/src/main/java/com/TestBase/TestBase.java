package com.TestBase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties ConfigProp;

	public TestBase() {
		ConfigProp = new Properties();
		
		try {
			 FileInputStream readConfiguration = new FileInputStream(
					"C:\\Users\\HP\\Desktop\\PROJECT\\DemoBlaze\\src\\main\\java\\com\\Config\\globalConfig\\");
		
			ConfigProp.load(readConfiguration);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void Initialization() {
		String browserName = ConfigProp.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(ConfigProp.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		

	}
}
