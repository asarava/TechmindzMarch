package com.testbase;

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
	public static Properties configProp;
	public TestBase() {
	configProp=new Properties();
	try {
	FileInputStream readConfig= new FileInputStream("D:\\Project_Techmindz\\proj_01\\src\\main\\java\\com\\config\\globalconfig");
	configProp.load(readConfig);
	}catch(FileNotFoundException e) {
	e.printStackTrace();
	}
	catch(IOException e) {
	e.printStackTrace();
	}
	}
	@SuppressWarnings("deprecation")
	public void initialization() {
		String driverLoc=null;
	String browserName=configProp.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome")) {
	driverLoc = configProp.getProperty("driverlocation"); 			
	System.setProperty("webdriver.chrome.driver", driverLoc);
	driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
	driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.get(configProp.getProperty("URL"));
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	} 


}
