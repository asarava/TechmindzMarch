package com.test;



import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testbase.TestBase;
import com.utilities.Utilities;
import com.utilities.Wrapper;


public class AddScreenshotsToReport extends TestBase{
	HomePage homePage;
	Wrapper objWrapperTest;
	Utilities objUtilities;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	public AddScreenshotsToReport() {
	super();
	}
	@BeforeTest
	public void setExtent() {
	extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
	extent.addSystemInfo("Host Name", "Sumi K");
	extent.addSystemInfo("User Name", "Sumi K");
	extent.addSystemInfo("Environment", "Project");
	}
	@BeforeClass
	public void setUp() {
	initialization();
	homePage = new HomePage();
	objWrapperTest = new Wrapper();
	objUtilities = new Utilities();
	}
	@Test
	public void clickOnSignUpButton() throws InterruptedException {
	extentTest = extent.startTest("clickOnSignUpButton");
	//homePage.clickSignUp();
	//homePage.clickSignUpCloseButton();
	Assert.assertTrue(false);
	}
/*	@Test
	public void clickOnLoginButton() {
	extentTest = extent.startTest("clickOnLoginButton");
	homePage.clickLoginButton();
	homePage.clickLogInCloseButton();
	Assert.assertTrue(true);
	}*/
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



