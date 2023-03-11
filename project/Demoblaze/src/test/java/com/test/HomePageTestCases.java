package com.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.page.AboutUs;
import com.page.Cartpage;
import com.page.Categories;
import com.page.Contact;
import com.page.HomePage;
import com.page.LoginPage;
import com.page.SignUpPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testbase.TestBase;
import com.utilities.Utilities;
import com.utilities.Wrapper;



public class HomePageTestCases extends TestBase {

	HomePage homePage;
	SignUpPage signup;
	LoginPage login;
	AboutUs about;
	Categories category;
	Cartpage cartpage;
	Contact contact;
	Wrapper objWrapperTest;
	Utilities objUtilities;

	public ExtentReports extent;
	public ExtentTest extentTest;

	public HomePageTestCases() {
		super();
	}

	@BeforeTest
	public void setExtent() {
	extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
	extent.addSystemInfo("Host Name", "Greeshma N G");
	extent.addSystemInfo("User Name", "Greeshma N G");
	extent.addSystemInfo("Environment", "Learning");
	}

	@BeforeClass
	public void setUp() {
		initialization();
		homePage = new HomePage();
		login = new LoginPage();
		signup = new SignUpPage();
		about = new AboutUs();
		category = new Categories();
		cartpage = new Cartpage();
		contact = new Contact();
		objUtilities = new Utilities();
	}

	@DataProvider(name = "dataprovider2")
	public Object[][] dpMethod2() {
		Object newTestData[][] = Utilities.getTestData("Sheet1");
		System.out.print("hiiii gteee" + newTestData);
		return newTestData;
	}

	// signup

	@Test(priority = 1, dataProvider = "dataprovider2" )

	public void clickSigninButton(String uname, String pword) {
		
		extentTest = extent.startTest("clickSigninButton");
		signup.clickSignin(uname, pword);
	}

	// signup

	@DataProvider(name = "dataprovider3")
	public Object[][] dpMethod3() {
		Object newTestData[][] = Utilities.getTestData("Sheet2");
		System.out.print(newTestData);
		return newTestData;
	}

	// login

	@Test(priority = 2, dataProvider = "dataprovider3")
	public void clickLogininButton(String uname, String pword) {
		extentTest = extent.startTest("clickLogininButton");

		login.clickloginin(uname, pword);
	}
	// login

	// About Us

	@Test(priority = 3,groups= {"First"})
	public void aboutUs() {
		extentTest = extent.startTest("aboutUs");
		about.clickAboutUs();
	}

	@Test(priority = 4,groups= {"First"})
	public void videoplay() {
		extentTest = extent.startTest("videoplay");
		about.play();
	}

	@Test(priority = 5,groups= {"First"})
	public void screen() {
		extentTest = extent.startTest("screen");
		about.fullScreen();
		about.nonFullScreen();

	}

	@Test(priority = 6,groups= {"First"})
	public void volume() {
		extentTest = extent.startTest("volume");
		about.volumnMute();
		about.volumnUnMute();

	}

	@Test(priority = 7,groups= {"First"})
	public void videopause() {
		extentTest = extent.startTest("videopause");
		about.pause();

	}

	@Test(priority = 8,groups= {"First"})
	public void clickAboutClose() {
		extentTest = extent.startTest("clickAboutClose");
		about.aboutUsClose();
	}

	// About Us

	// Home categories

	@Test(priority = 9,groups= {"Second"})
	public void selectCategory() {
		extentTest = extent.startTest("selectCategory");
		category.categoriesclick();

	}

	@Test(priority = 10,groups= {"Second"})
	public void addtoCart() {
		extentTest = extent.startTest("addtoCart");
		category.selectItem();
	}
	// Search

	@Test(priority = 11,groups= {"Second"})
	public void searchBar() {
		extentTest = extent.startTest("searchBar");
		category.serachAvail();
	}

	@Test(priority = 12,groups= {"Second"})
	public void review() {
		extentTest = extent.startTest("review");
		category.reviewavail();
	}

	@Test(priority = 13,groups= {"Second"})
	public void filter() {
		extentTest = extent.startTest("filter");
		category.reviewavail();
	}

	@Test(priority = 14,groups= {"Second"})
	public void sort() {
		extentTest = extent.startTest("sort");
		category.reviewavail();
	}

	@Test(priority = 14,groups= {"Second"})
	public void cartPage() {
		extentTest = extent.startTest("cartPage");
		cartpage.cart();
	}

	@Test(priority = 15,groups= {"Second"})
	public void clickDelete() {
		extentTest = extent.startTest("clickDelete");
		cartpage.delete();
	}
	
	//cart

	@Test(priority = 16,groups= {"Third"})
	public void clickOrderPlace() {
		extentTest = extent.startTest("clickOrderPlace");
		cartpage.orderPlace();
	}

	@Test(priority = 17,groups= {"Third"})
	public void validTest() {
		extentTest = extent.startTest("validTest");
		cartpage.enterValidata("Greeshma", "India", "Kochi", "9632145588", "March", "2020");
	}

	@Test(priority = 18,groups= {"Third"})
	public void inValidTest() {
		extentTest = extent.startTest("inValidTest");
		cartpage.invaliData("", "", "", "", "", "");
	}

	
	//contact
	
	@Test(priority = 19,groups= {"Fourth"})
	public void validContact() {
		extentTest = extent.startTest("validContact");
		contact.clickContact();
		contact.validData("grees@hh.cc", "Greeshma", "Test message");
	}

	@Test(priority = 20,groups= {"Fourth"})
	public void invalidContact() {
		extentTest = extent.startTest("invalidContact");
		contact.clickContact();
		contact.invalidData("", "", "");
	}

	@Test(priority = 21,groups= {"Fourth"})
	public void invalidContactmsg() {
		extentTest = extent.startTest("invalidContactmsg");
		contact.clickContact();
		contact.validDatamsg100("greesh@jj.mm", "greeshma",
				"The newspaper is the mirror of the world. It plays a vital role in modern civilization. "
						+ "In our country newspapers are published in many languages. It helps us to acquire general knowledge. Newspapers provide reports, "
						+ "speeches, reviews on trade and commerce, films, sports, etc, and puzzles. Sometimes it publishes articles written by great scholars. "
						+ "People read newspapers for both profit and pleasure. It brings to the public valuable views, acts of injustice, oppression, and maladministration."
						+ " It exposes the grievances of the people and criticizes the authorities for their failure. It shapes public opinion. Therefore, freedom of the press should not be barred.");
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
