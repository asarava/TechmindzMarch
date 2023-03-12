package com.test;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testbase.TestBase;
import com.utilities.Utilities;
import com.utilities.Wrapper;


public class HomePageTestCases extends TestBase {
		HomePage homePage;
		Wrapper wrapobject;
		Utilities objUtilities;
		public ExtentReports extent;
		public ExtentTest extentTest;
		boolean flag=true;
		String message,actualMsg;
		
		public HomePageTestCases() {
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
		wrapobject = new Wrapper();
		objUtilities = new Utilities();
		}
		
		@DataProvider(name="dataprovider0")
	    public Object[][] dpMethod0(){
	      return new Object [][] {{"Sumiksss11335","Sumi2011"}};
	      }
	      
		@Test(priority=1,dataProvider="dataprovider0",groups= {"SignUp","ProcessFlow"})
		
		public void Signup(String userName,String password) throws InterruptedException {
		  extentTest = extent.startTest("clickOnSignUp");
		  homePage.inputDetails(userName,password);
		  message="Sign up successful.";
		  homePage.checkSignup();
		  actualMsg=homePage.messageCheck(message);
		  homePage.signInClose();
		  Assert.assertEquals(actualMsg, message);
		  
		  }
		
		@Test(priority=2,dataProvider="dataprovider0",groups= {"Login","ProcessFlow"})
		
		public void logIn(String userName,String password) throws InterruptedException {
		  extentTest = extent.startTest("clickOnLogin");
		  homePage.loginInput(userName, password);
		  homePage.clickLogIn();
		  homePage.logOut();
		  }
		  
		@Test(priority=3,groups= {"Category","ProcessFlow"})
		
		public void selectCategory() {
			extentTest = extent.startTest("categorySelect");
			homePage.categorySelect();
			}
			
		@Test(priority=4,groups= {"Cart","ProcessFlow","Validations"})
		
		public void addToCart() {
			extentTest = extent.startTest("addToCart");
			homePage.addToCart();
			}
			
		@Test(priority=5,groups= {"Cart","ProcessFlow"},dependsOnMethods={"addToCart"})
		
		public void placeOrderCheck() throws InterruptedException {
			extentTest = extent.startTest("OrderPlace");
		    homePage.clickPlaceOrderButton();
			homePage.inputOrderDetails();
			homePage.orderSubmitClick();
		    }
		    
		@Test(priority=13,groups= {"Cart","Validations"},dependsOnMethods={"addToCart"})
		
		public void placeOrderClose() {
			extentTest = extent.startTest("OrderPlaceButton");
			homePage.cartAccess();
			homePage.clickPlaceOrderButton();
			homePage.inputOrderDetails();
			homePage.OrderCloseClick();
		    }
		    
		@Test(priority=14,groups= {"Cart","Validations"},dependsOnMethods={"addToCart"})
		
		public void deleteCart() {
			extentTest = extent.startTest("DeleteOrder");
		    homePage.addToCart();
			homePage.deleteFromCart();
			}
		@Test(priority=12,groups= {"Cart","Validations"})
		public void cartAccessCheck() {
			homePage.cartAccess();
		}
		    
		@DataProvider (name = "dataprovider2")
		public Object[][] dpMethod2() {
		    Object newTestData[][] = Utilities.getTestData("Sheet4");
		    return newTestData;
		    }	
				        
		@Test(priority=15,dataProvider="dataprovider2",groups= {"GeneralValidations","Validations"})
		public void checkOptionPresent(String value) {
			extentTest = extent.startTest("ElementIsPresent");
			homePage.checkElementIsPresent(value);
			flag=wrapobject.getPageSource(driver, value);
			Assert.assertTrue(flag); 		
			}
			
				 
	    @Test(priority=7,groups= {"Contacts","ProcessFlow"})
		public void contactAccessibilityCheck() {
			 extentTest = extent.startTest("contactAccessibility");
			 homePage.contactAccessibleCheck();
			 homePage.contactClose();
		}
		
		@DataProvider(name="dataprovider4")
	    public Object[][] dpMethod4(){
	      return new Object [][] {{"sumi6965@gmail.com","Sumi","Testing"}};
	      }
		
		@Test(priority=8,dataProvider="dataprovider4",groups= {"Contacts","ProcessFlow"})
		
		public void validContactsCheck(String email,String name,String text) throws InterruptedException {
			extentTest = extent.startTest("Contacts");
			homePage.contactInput(email, name, text);
			homePage.clickContact();
			message="Thanks for the message!!";
			actualMsg=homePage.messageCheck(message);
			Assert.assertEquals(actualMsg, message);
			}
			
			
		@Test(priority=6,groups= {"AboutUs"})
		public void clickAudio() throws InterruptedException {
			extentTest = extent.startTest("VideoPlayAndPause");
			homePage.clickAboutUs();
			homePage.playVideoCheck();
			homePage.volumeControl();
			homePage.pauseVideoCheck();
			homePage.fullScreen();
			homePage.clickAboutUsClose();
		}	
		
		@Test(priority=9,groups= {"GeneralValidations","Validations"})
		public void navLinkCheck() {
			extentTest = extent.startTest("Navigationcheck");
			homePage.navigations();
		}
		@DataProvider(name="dataprovider1")
	    public Object[][] dpMethod(){
	      return new Object [][] {{"Sumikuttinat1222223","sumi1986","Sign up successful."},{"","sumi","Sign up successful."},{"sumik","","Sign up successful."}};
		  }
		  
		@Test(priority=16,dataProvider="dataprovider1",groups= {"SignUpValidations","Validations"})
		
		public void signUpValidations(String userName,String password,String message) throws InterruptedException {
			extentTest = extent.startTest("clickOnSignUp");
			  homePage.inputDetails(userName,password);
			  homePage.checkSignup();
			  actualMsg=homePage.messageCheck(message);
			  homePage.signInClose();
			  Assert.assertNotEquals(actualMsg, message);
		   }
		   
		@Test(priority=17,groups= {"SignUpValidations","Validations"})
		@Parameters({"username","password"})
		
	      public void signUpValidPasswordLen(String userName,String password) {
	      extentTest = extent.startTest("SignUpValidPasswordLengthCheck");
	      homePage.inputDetails(userName, password);
	      flag=wrapobject.passwordLengthCheck(password);
	      homePage.signInClose();
	      Assert.assertTrue(flag);
	      }
		@Test(priority=18,groups= {"SignUpValidations","Validations"})
		@Parameters({"uname","pword"})
		
	      public void signUpInValidPasswordLen(String userName,String password) {
	      extentTest = extent.startTest("SignUpInValidPasswordLengthCheck");
	      homePage.inputDetails(userName, password);
	      flag=wrapobject.passwordLengthCheck(password);
	      homePage.signInClose();
	      Assert.assertFalse(flag);
	      }
	      
		@DataProvider (name = "dataprovider3")
		public Object[][] dpMethod3() {
		  Object newTestData[][] = Utilities.getTestData("Sheet2");
		  return newTestData;
		  }
		  
		@Test(priority=19,dataProvider="dataprovider3",groups= {"LoginValidations","Validations"})
		
		public void loginValidation(String userName,String password) throws InterruptedException {
		  extentTest = extent.startTest("LoginValidations");
		  homePage.loginInput(userName, password);
		  homePage.logInValidations();
		  homePage.logInClose();
		 }
		  
	   @Test(priority=20,groups= {"LoginValidations","Validations"})
	   @Parameters({"loginName","loginPword"})
	   
	   public void validLoginPasswordLength(String userName,String password) throws InterruptedException {
	     extentTest = extent.startTest("ValidLoginpasslengthCheck");
	     homePage.loginInput(userName, password);
	     flag=wrapobject.passwordLengthCheck(password);
	     homePage.logInClose();
	     Assert.assertTrue(flag);
	     }
		@Test(priority=21,groups= {"LoginValidations","Validations"})
	    @Parameters({"loginName1","loginPword1"})
	   
	     public void inValidLoginPasswordLength(String userName,String password) throws InterruptedException {
	      extentTest = extent.startTest("IvalidLoginpasslengthCheck");
	      homePage.loginInput(userName, password);
	      flag=wrapobject.passwordLengthCheck(password);
	      homePage.logInClose();
	      Assert.assertFalse(flag);
	     }
		
	   	@DataProvider(name="dataprovider5")
	    public Object[][] dpMethod5(){
	      return new Object [][] {{"","Sumi","Testing"},{"sumi6965@gmail","Sumi789",""},{"","",""}};
	      }
		
		@Test(priority=10,dataProvider="dataprovider5",groups= {"ContactValidation","Validations"})
		public void invalidContactsMenuCheck(String email,String name,String text) throws InterruptedException {
			extentTest = extent.startTest("ContactValidation");
			homePage.contactInput(email, name, text);
			homePage.clickContact();
			message="Thanks for the message!!";
			actualMsg=homePage.messageCheck(message);
			Assert.assertNotEquals(actualMsg, message);
		}
		
		@DataProvider (name = "dataprovider6")
		public Object[][] dpMethod6() {
		  Object newTestData[][] = Utilities.getTestData("Sheet3");
		  return newTestData;
		 }
		
		@Test(priority=11,dataProvider="dataprovider6",groups= {"ContactValidation","Validations"})
		
		public void contactTextCheck(String email,String name,String text) throws InterruptedException {
			extentTest = extent.startTest("ContactTextLen>100");
			homePage.contactInput(email, name, text);
			flag=wrapobject.contactMessageLength(text);
			homePage.contactClose();
			Assert.assertTrue(flag);
		}
		
		
		@Test(priority=22,groups= {"GeneralValidations","Validations"})
        public void navigateToLink() {
			extentTest = extent.startTest("NavigationLink");
        	driver.get("https://www.demoblaze.com/");
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
