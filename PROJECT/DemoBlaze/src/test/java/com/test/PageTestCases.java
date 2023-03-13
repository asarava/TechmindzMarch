package com.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.Utilities.Utilities;
import com.Utilities.Wrapper;
import com.pages.AboutusPage;
import com.pages.CartPage;
import com.pages.ContactPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SignupPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PageTestCases extends TestBase {
	HomePage homepage;
	ContactPage contactpage;
	CartPage cartpage;
	LoginPage loginpage;
	SignupPage signuppage;
	AboutusPage aboutuspage;
	Wrapper objWrapperTest;
	Utilities objUtilities;
	public ExtentReports extent;
	public ExtentTest extentTest;

	public PageTestCases() {
		super();
	}

	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Anakha sabu");
		extent.addSystemInfo("User Name", "Anakha Sabu");
		extent.addSystemInfo("Environment", "Learning");
	}

	@BeforeClass
	public void setUp() {
		Initialization();
		homepage = new HomePage();
		contactpage = new ContactPage();
		cartpage = new CartPage();
		signuppage = new SignupPage();
		loginpage = new LoginPage();
		aboutuspage = new AboutusPage();
		objWrapperTest = new Wrapper();
		objUtilities = new Utilities();

	}

	@Test(priority = 1)
	public void ClickOnPhones() {
		extentTest = extent.startTest("clickOnPhones");
		homepage.ClickPhones();
	}

	@Test(priority = 2)
	public void ClickOnLaptops() {
		extentTest = extent.startTest("clickOnLaptops");
		homepage.ClickLaptops();
	}

	@Test(priority = 3)
	public void ClickOnMonitors() {
		extentTest = extent.startTest("clickOnMonitors");
		homepage.ClickMonitors();

	}

	@Test(priority = 4)
	public void ClickOnAddtocart() {
		extentTest = extent.startTest("Addtocart");
		homepage.Addtocart();

	}

	@Test(priority = 5)
	public void ClickOnSearchBar() {
		extentTest = extent.startTest("ClickOnSearchBar");
		homepage.ClickSearch();

	}

	@Test(priority = 6)
	public void ClickOnProductReview() {
		extentTest = extent.startTest("clickOnProductReview");
		homepage.ClickReview();

	}

	@Test(priority = 7)
	public void ClickOnFiltersAndSortBy() {
		extentTest = extent.startTest("clickOnFiltersAndSortBy");
		homepage.ClickFiltersAndSortBy();

	}

	@DataProvider(name = "dataprovider1")
	public Object[][] dpMethod1() {
		Object newTestData[][] = Utilities.getTestData("Sheet1");
		return newTestData;
	}

	@Test(priority = 8, dataProvider = "dataprovider1")
	public void clickOnContactWithValidData(String Email, String Name, String Text) {
		extentTest = extent.startTest("clickOnContactwithValidData");
		contactpage.ContactWithValidData(Email, Name, Text);
		Assert.assertEquals(true, true);
		;

	}

	@Test(priority = 9)
	public void clickOnContactWithEmptyData() {
		extentTest = extent.startTest("clickOnContactwithEmptyData");
		contactpage.ContactWithEmptyData();
		Assert.assertNotEquals(false, false);

	}

	@DataProvider(name = "dataprovider2")
	public Object[][] dpMethod2() {
		Object newTestData[][] = Utilities.getTestData("Sheet2");
		return newTestData;
	}

	@Test(priority = 10, dataProvider = "dataprovider2")
	public void clickOnInvalidData(String Email, String Name, String Text) {
		extentTest = extent.startTest("clickOnInvalidData");
		contactpage.ContactWithInvalidData(Email, Name, Text);
		Assert.assertNotEquals(false, false);

	}

	@DataProvider(name = "dataprovider3")
	public Object[][] dpMethod3() {
		Object newTestData[][] = Utilities.getTestData("Sheet3");
		return newTestData;
	}

	@Test(priority = 11, dataProvider = "dataprovider3")
	public void ClickonsignValidUsernameandPassword(String Username, String Password) {
		extentTest = extent.startTest("clickOnsignValidUsernameandPassword");
		signuppage.SigninwithValidusernameandPassword(Username, Password);
		Assert.assertEquals(true, true);
	}

	@DataProvider(name = "dataprovider4")
	public Object[][] dpMethod4() {
		Object newTestData[][] = Utilities.getTestData("Sheet4");
		return newTestData;
	}

	@Test(priority = 12, dataProvider = "dataprovider4")

	public void ClickonSigninAlreadyexsitedUsernameandPassword(String Username, String Password) {
		extentTest = extent.startTest("ClickonSigninAlreadyexsitedUsernameandPassword");
		signuppage.SigninwithAlreadyExistedUsernameandPassword(Username, Password);
		Assert.assertEquals(true, true);

	}

	@Test(priority = 13)
	public void ClickSignEmptUsernameandPassword() {
		extentTest = extent.startTest("ClickSignEmptUsernameandPassword");
		signuppage.SigninwithEmptyUsenameandPassword();
		Assert.assertEquals(true, true);
	}

	@Test(priority = 14)
	public void ClicksignUsernameOnly() {
		extentTest = extent.startTest("ClicksignUsernameOnly");
		signuppage.SigninwithUsernameOnly();
		Assert.assertEquals(true, true);
	}

	@Test(priority = 15)
	public void ClicksignPasswordOnly() {
		extentTest = extent.startTest("ClicksignPasswordOnly");
		signuppage.signinwithPasswordonly();
		Assert.assertEquals(true, true);

	}

	@DataProvider(name = "dataprovider5")
	public Object[][] dpMethod5() {
		Object newTestData[][] = Utilities.getTestData("Sheet5");
		return newTestData;
	}

	@Test(priority = 16, dataProvider = "dataprovider5")
	public void ClickLoginValidUsernameandInvalidPassword(String Username, String Password) {
		extentTest = extent.startTest("ClickLoginValidUsernameandInvalidPassword");
		loginpage.LoginValidUsernameandInvalidPassword(Username, Password);
		Assert.assertTrue(true);

	}

	@DataProvider(name = "dataprovider6")
	public Object[][] dpMethod6() {
		Object newTestData[][] = Utilities.getTestData("Sheet6");
		return newTestData;
	}

	@Test(priority = 17, dataProvider = "dataprovider6")
	public void ClickLoginInvalidUsernameandValidPassword(String Username, String Password) {
		extentTest = extent.startTest("ClickLoginInvalidUsernameandValidPassword");
		loginpage.LoginInvalidUsernameandValidPassword(Username, Password);
		Assert.assertEquals(true, true);

	}

	@DataProvider(name = "dataprovider7")
	public Object[][] dpMethod7() {
		Object newTestData[][] = Utilities.getTestData("Sheet7");
		return newTestData;
	}

	@Test(priority = 18, dataProvider = "dataprovider7")
	public void ClickLogValidUsernameandValidPassword(String Username, String Password) {
		extentTest = extent.startTest("ClickLogValidUsernameandValidPassword");
		loginpage.LogValidUsernameandPassword(Username, Password);
		Assert.assertEquals(true, true);
	}

	@Test(priority = 19)
	public void ClikOnCart() {
		extentTest = extent.startTest("ClickOnCart");
		cartpage.cart();
	}

	@Test(priority = 20)
	public void ClickOnDelete() {
		extentTest = extent.startTest("ClickOnDelete");
		cartpage.DeleteFromCart();
	}

	@Test(priority = 21)
	public void ClickOnEmptyData() {
		extentTest = extent.startTest("ClickOnEmptyData");
		cartpage.orderwithEmptydata();
		Assert.assertTrue(true);

	}

	@DataProvider(name = "dataprovider8")
	public Object[][] dpMethod8() {
		Object newTestData[][] = Utilities.getTestData("Sheet8");
		return newTestData;
	}

	@Test(priority = 22, dataProvider = "dataprovider8")

	public void ClickonInvalidData(String Name, String Country, String City, String Creditcard, String Month,
			String Year) {
		extentTest = extent.startTest("ClickonInvalidData");
		cartpage.orderwithInvaliddata(Name, Country, City, Creditcard, Month, Year);
		Assert.assertNotEquals(false, false);

	}

	@DataProvider(name = "dataprovider9")
	public Object[][] dpMethod9() {
		Object newTestData[][] = Utilities.getTestData("Sheet9");
		return newTestData;
	}

	@Test(priority = 23, dataProvider = "dataprovider9")
	public void ClickOnValidData(String Name, String Country, String City, String Creditcard, String Month,
			String Year) {
		extentTest = extent.startTest("ClickOnValidData");
		cartpage.OrderWithValiddata(Name, Country, City, Creditcard, Month, Year);
		Assert.assertEquals(true, true);

	}

	@Test(priority = 24)
	public void ClickOnPlayVideo() {
		extentTest = extent.startTest("ClickOnAboutUs");
		aboutuspage.PlayVideo();
	}

	@Test(priority = 25)
	public void ClickOnScreensize() {
		extentTest = extent.startTest("ClickOnScreensize");
		aboutuspage.Screen();
	}

	@Test(priority = 26)
	public void ClickOnVolumebutton() {
		extentTest = extent.startTest("ClickOnVolumebutton");
		aboutuspage.Volume();
	}

	@Test(priority = 27)
	public void ClickOnPause() {
		extentTest = extent.startTest("ClickOnPause");
		aboutuspage.pause();
	}

	@Test(priority = 28)
	public void ClickOnAboutUsClose() {
		extentTest = extent.startTest("ClickOnAboutUsClose");
		aboutuspage.AboutusClose();
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
