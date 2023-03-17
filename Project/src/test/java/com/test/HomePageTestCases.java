package com.test;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.page.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testbase.TestBase;
import com.utilities.Utilities;
import com.utilities.Wrapper;

public class HomePageTestCases  extends TestBase{
	
	HomePage homepage;
	Wrapper objWrapperTest;
	Utilities objUtilities;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	
	public HomePageTestCases() {
		super();
	}
	
	
	@BeforeClass
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Anju");
		extent.addSystemInfo("User Name", "Anju");
		extent.addSystemInfo("Environment", "Learning");
		}

	
	
	@BeforeClass
	public void  setUp() {
	initialization();
	homepage = new HomePage();
	objWrapperTest= new Wrapper();
	objUtilities = new Utilities();
}
	
	
	@Test(priority=1)
	public void clickSignUpButton() {
		extentTest=extent.startTest("clickSignUpButton");
		homepage.clickSignUpButton();
	}
	
	@DataProvider(name="dataprovider1")
	public Object [][] dpMethod1(){
		Object newTestData[][]=Utilities.getTestData("Sheet1");
		return newTestData;
	}
	
	@Test(priority=2, dataProvider="dataprovider1")
	public void clickSignUpButton( String UserName,String Password) {
		extentTest = extent.startTest("clickSignUpButton");
		homepage.clickSignUpBitton(UserName, Password);
	}
	
	@Test(priority=3)
	public void ClickSignUpButton(String UserName) {
		extentTest = extent.startTest("clickSignUpButton");
		homepage.ClickSignUpButton(UserName);
	}
	
	@DataProvider(name="dataprovider2")
	public Object[][]dpMethod2(){
	Object newTestData[][]= Utilities.getTestData("Sheet2");
	return newTestData;
	}
	
	@Test(priority=4, dataProvider="dataprovider2")
	public void clickLogInButton(String UserName,String Password) {
		extentTest = extent.startTest("clickLohInButton");
		homepage.Login(UserName, Password);
	}
	
	@Test(priority=5)
	public void clickLoginButton(String UserName, String InvalidPassword) {
		extentTest= extent.startTest("clickLogInButton");
		homepage.clickLogin(UserName, InvalidPassword);
	}
	
	@Test(priority=6)
	public void clickonLogin(String invalidUserName,String Password) {
		extentTest= extent.startTest("clickLogInButton");
		homepage.clickonLogin(invalidUserName, Password);
	}
	
	@Test(priority=7)
	public void ClickOnLogin(String invalidUserName,  String invalidPassword ) {
		extentTest= extent.startTest("clickLogInButton");
		homepage.ClickOnLogin(invalidUserName, invalidPassword);
	}
	
	@Test(priority=8)
	public void clickCartButton() {
		extentTest = extent.startTest("clickCartButton");
		homepage.clickCartButton();
	}
	
	@DataProvider(name="dataprovider3")
	public Object [][] dpMethod3(){
		Object newTestData[][]=Utilities.getTestData("Sheet3");
		return newTestData;
	}
	
	
	
	@Test(priority=9,dataProvider="dataprovider3")
	public void clickcart(String name, String Country, String City, String Card, String onth, String year) {
		extentTest = extent.startTest("clickCartButton");
		homepage.clickCart(name, Country, City, Card, onth, year);
	}
	
	
	@Test(priority=10)
	public void clickAboutUs() {
		extentTest=extent.startTest("ClickAboutUs");
		homepage.clickAboutUs();
	}
	@DataProvider(name="dataprovider4")
	public Object[][] dpMethod4(){
		Object newTestData[][]=Utilities.getTestData("sheet4");
		return newTestData;
	}
	
	@Test(priority=11,dataProvider="dataprovider4")
	public void validContactdata(String Email,String Name, String Text) {
		extentTest=extent.startTest("validContactdata");
		homepage.validContactdatas(Email, Name, Text);
	}
	
	@Test(priority=12)
	public void invalidContactdata(String Email, String Name, String Text) {
		extentTest=extent.startTest("invalidContactdata");
		homepage.invalidContactdatas(Email, Name, Text);
	
	}
	
	@Test(priority=13)
	public void Phones() {
		extentTest=extent.startTest("Phones");
		homepage.Phones();
	}
	
	@Test(priority=14)
	public void Laptops() {
		extentTest=extent.startTest("Laptops");
		homepage.Laptops();
	}
	
	@Test(priority=15)
	public void Monitors() {
		extentTest=extent.startTest("Monitors");
		homepage.Monitors();
	}
	
	@Test(priority=16)
	public void Search() {
		extentTest=extent.startTest("Search");
		homepage.Search();
	}
	
	@Test(priority=17)
	public void Review() {
		extentTest=extent.startTest("Review");
		homepage.VoiceSeach();
}
	
	@Test(priority=18)
	public void VoiceSearch() {
		extentTest=extent.startTest("Phones");
		homepage.VoiceSeach();
		
	}
	@Test(priority=19)
	public void Filter() {
		extentTest=extent.startTest("Filter");
		homepage.Filter();
	}
	
	@Test(priority=20)
	public void SortOption() {
		extentTest=extent.startTest("SortOption");
		homepage.SortOption();
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
	if (result.getStatus() == ITestResult.FAILURE) {
	extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());
	extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
	String screenshotPath = objUtilities.getScreenshot(driver, result.getName());
	extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
	} else if (result.getStatus() == ITestResult.SKIP) {
	extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
	} else if (result.getStatus() == ITestResult.SUCCESS) {
	extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
	String screenshotPath = objUtilities.getScreenshot(driver, result.getName());
	extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath));
	}
	extent.endTest(extentTest);
	}
	
	
	@AfterTest
	public void endReport() {
	extent.flush();
	extent.close();
	driver.quit();
	}
	

	
	
	
	
	
	
}




	


