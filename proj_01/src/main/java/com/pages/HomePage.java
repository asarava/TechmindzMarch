package com.pages;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testbase.TestBase;
import com.utilities.Wrapper;


public class HomePage extends TestBase {
	Wrapper wrapobject=new Wrapper();
	@FindBy(id="signin2") 	
	WebElement pSignup;
	@FindBy(xpath="//input[@id='sign-username']") WebElement pSignInUserName;
	@FindBy(xpath="//input[@id='sign-password']") WebElement pSignInUserPassword;
	@FindBy(xpath="//button[@onclick='register()']") WebElement pSignupButton;
	@FindBy(xpath="(//button[@data-dismiss='modal'])[4]") WebElement pSignupClose;
	@FindBy(id="login2") 
	WebElement pLogin;
	@FindBy(xpath="//input[@id='loginusername']") WebElement pLogInUserName;
	@FindBy(xpath="//input[@id='loginpassword']") WebElement pLogInPassword;
	@FindBy(xpath="//button[@onclick='logIn()']") WebElement pLogInButton;
	@FindBy(id="logout2") WebElement pLogOut;
	@FindBy(xpath="(//button[@data-dismiss='modal'])[6]") WebElement pLoginClose;
	@FindBy(xpath="//a[@id='nameofuser']") WebElement pText;
	@FindBy(xpath="(//a[@data-toggle='modal'])[1]") WebElement pContactMenu;
	@FindBy(xpath="//button[@onclick='send()']") WebElement pSend;
	@FindBy(xpath="//input[@id='recipient-email']") WebElement pContactemail;
	@FindBy(xpath="//input[@id='recipient-name']") WebElement pContactName;
	@FindBy(xpath="//textarea[@id='message-text']") WebElement pTextArea;
	@FindBy(xpath="//h5[contains(text(),'New message')]") WebElement pContactTitle;
	@FindBy(xpath="(//button[@data-dismiss='modal'])[1]") WebElement pContactClose;
	@FindBy(xpath="(//a[@data-toggle='modal'])[2]") WebElement pAboutUs;
	@FindBy(xpath="(//button[@data-dismiss='modal'])[8]") WebElement pAboutUsClose;
	@FindBy(xpath="//button[@class='vjs-big-play-button']") WebElement pPlayButton;
	@FindBy(xpath="//button[@title='Fullscreen']") WebElement pFullScreen;
	@FindBy(xpath="//button[@title='Non-Fullscreen']") WebElement pNonFullScreen;
	@FindBy(xpath="//div[@class='vjs-volume-control vjs-control vjs-volume-horizontal']") WebElement pDragFrom;
	@FindBy(xpath="//button[@title='Pause']") WebElement pPauseButton;
	String message;
	String actualMessage;
	boolean flag=true;
	@FindBy(xpath="(//a[@class='nav-link'])[1]") WebElement pHomeLink;   
	@FindBy(xpath="(//a[@class='nav-link'])[4]") WebElement pCart;  
	@FindBy(xpath="//button[contains(text(),'Place Order')]") WebElement pPlaceOrder;
	@FindBy(xpath="//input[@id='name']") WebElement pPlaceorderName;
	@FindBy(xpath="//input[@id='card']") WebElement pPlaceorderCard;
	@FindBy(xpath="//button[@onclick='purchaseOrder()']") WebElement pPlaceorderButton;
	@FindBy(xpath="(//button[@data-dismiss='modal'])[5]") WebElement pPlaceorderclose;
	@FindBy(xpath="(//a[@id='itemc'])[1]") WebElement pPhone;
	@FindBy(xpath="(//a[@id='itemc'])[2]") WebElement pLaptop;
	@FindBy(xpath="(//a[@id='itemc'])[3]") WebElement pMonitor;
	@FindBy(xpath="//a[contains(text(),'Iphone 6 32gb')]") WebElement pIphone;
	@FindBy(xpath="//a[contains(text(),'MacBook')]") WebElement pMacBook;
	@FindBy(xpath="//a[contains(text(),'Apple monitor 24')]") WebElement pAppleMonitor;
	@FindBy(xpath="//a[contains(text(),'Add to cart')]") WebElement pAddtoCart;
	@FindBy(xpath="//a[contains(text(),'Delete')]") WebElement pCartDelete;
	@FindBy(xpath="//button[@class='confirm btn btn-lg btn-primary']") WebElement pAlertOk;
	String url="https://www.demoblaze.com/index.html";
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		}

   public void inputDetails(String userName,String password) {
	    driver.navigate().to(url);
		wrapobject.waitDriver(pSignup, driver);
		pSignup.click();
		wrapobject.waitDriver(pSignInUserName, driver);
		pSignInUserName.clear();
		pSignInUserName.sendKeys(userName);
		pSignInUserPassword.clear();
		pSignInUserPassword.sendKeys(password);
			
	  }

   public void checkSignup() {
	   
		pSignupButton.click();
      }
   public String messageCheck(String pMessage) { 
		wrapobject.waitDriverAlert(driver);
		actualMessage=wrapobject.alertHandle(driver);
	   	return actualMessage;
	  }
	   		 
  public void logInClose() {
	    try {
	      pLoginClose.click();
	    	}catch(ElementNotInteractableException e) {
	  		e.getStackTrace();
            }
       } 
  public void signInClose() {
	    try {
	     pSignupClose.click();
         }catch(ElementNotInteractableException e) {
	  		e.getStackTrace();
            }
       } 
  public void loginInput(String userName,String password) {
	    driver.navigate().to(url);
	    wrapobject.waitDriver(pLogin, driver);
	    pLogin.click();
		wrapobject.waitDriver(pLogInUserName, driver);
		pLogInUserName.clear();
		pLogInUserName.sendKeys(userName);
		pLogInPassword.clear();
		pLogInPassword.sendKeys(password);
     }
     
  public void clickLogIn() {
	   
	    pLogInButton.click();
	    wrapobject.waitDriver(pText, driver);   
	    System.out.println(pText.getText());
	   
    }
	   
  public void logOut() {
	   wrapobject.waitDriver(pLogOut, driver);
	   pLogOut.click();
    }
  
  public boolean logInValidations() throws InterruptedException  {
	   boolean flag=true;
	     try {
	     pLogInButton.click();
	     wrapobject.waitDriverAlert(driver);
	     wrapobject.alertHandle(driver);
	    // driver.manage().wait(1000);
	     if(pText.isDisplayed()) {
			flag=false;
			}else {
			flag=true;
		 }
		
	     }catch(NoAlertPresentException e){
	    	e.getStackTrace();
	    }
	    return flag;
	}
   
  public void navigations() {
	    driver.navigate().to(url);
	    Assert.assertTrue(pHomeLink.isDisplayed());
        Assert.assertTrue(pContactMenu.isDisplayed());
        Assert.assertTrue(pAboutUs.isDisplayed());
        Assert.assertTrue(pCart.isDisplayed());
    }
  public void categorySelect() {
	    driver.navigate().to(url);
	    pHomeLink.click();
	    wrapobject.waitDriver(pPhone, driver);
	    pPhone.click();
	    wrapobject.waitDriver(pIphone, driver);
	    Assert.assertTrue(pIphone.isDisplayed());
	    pLaptop.click();
	    wrapobject.waitDriver(pMacBook, driver);
	    Assert.assertTrue(pMacBook.isDisplayed());
	    pMonitor.click();
	    wrapobject.waitDriver(pAppleMonitor, driver);
	    Assert.assertTrue(pAppleMonitor.isDisplayed());
	  }

  public void addToCart() {
	    try {
	    driver.navigate().to(url);
	    pHomeLink.click();
	    wrapobject.waitDriver(pPhone, driver);
	    pPhone.click();
	    wrapobject.waitDriver(pIphone, driver);
	    pIphone.click();  
	    wrapobject.waitDriver(pAddtoCart, driver);
	    pAddtoCart.click();
	    wrapobject.waitDriverAlert(driver);
	    wrapobject.alertHandle(driver);
	    wrapobject.waitDriver(pCart, driver);
	    pCart.click();
	    wrapobject.waitDriver(pCartDelete, driver);
	    wrapobject.getPageSource(driver, "Iphone");
	     }catch(NoAlertPresentException e) {
	    	e.printStackTrace();
	       }
   }
	     
  public void deleteFromCart() {
	   // wrapobject.waitDriver(pCartDelete, driver);   
	    pCartDelete.click();
   }
  public void cartAccess() {
	    wrapobject.waitDriver(pCart, driver);
	    pCart.click();
	    pPlaceOrder.isDisplayed();
  }
  public void clickPlaceOrderButton() {
	    pHomeLink.click();
	    wrapobject.waitDriver(pMonitor, driver);
	    pMonitor.click();
	    wrapobject.waitDriver(pAppleMonitor, driver);
	    pAppleMonitor.click();  
	    wrapobject.waitDriver(pAddtoCart, driver);
	    pAddtoCart.click();
	    wrapobject.waitDriverAlert(driver);
	    wrapobject.alertHandle(driver);
	    wrapobject.waitDriver(pCart, driver);
	    pCart.click();
	    wrapobject.waitDriver(pPlaceOrder, driver);
	    pPlaceOrder.click();
    }

  public void inputOrderDetails() {
	    wrapobject.waitDriver(pPlaceorderName, driver);
	    pPlaceorderName.sendKeys("Sumi");
	    wrapobject.waitDriver(pPlaceorderCard, driver);
	    pPlaceorderCard.sendKeys("123456789112");
       }
  public void orderSubmitClick() throws InterruptedException {
	    pPlaceorderButton.click();
	    Thread.sleep(1000);
	    pAlertOk.click();
	    if(driver.getCurrentUrl().equalsIgnoreCase("https://www.demoblaze.com/index.html")) {
	    	Assert.assertTrue(true);
	    }
	    else {
	    	Assert.assertTrue(false);
	    }
	    System.out.println(driver.getCurrentUrl());
	 }
  public void OrderCloseClick() {
	    wrapobject.waitDriver(pPlaceorderclose, driver);
	    pPlaceorderclose.click();
    }
  
  @SuppressWarnings("deprecation")
  public void checkElementIsPresent(String value) {
	    pHomeLink.click();
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    }
  public void contactInput(String email,String name,String text) {
	    driver.navigate().to(url);
	    wrapobject.waitDriver(pContactMenu, driver);
	    pContactMenu.click();
	    wrapobject.waitDriver(pContactemail, driver);
	    pContactemail.sendKeys(email);
	    pContactName.sendKeys(name);
	    pTextArea.sendKeys(text);
	  
   }
  
  public void clickContact()  {
	    pSend.click();
  }   
	   
  public void contactAccessibleCheck() {
	    driver.navigate().to(url);
	    wrapobject.waitDriver(pContactMenu, driver);
	    pContactMenu.click();
	    wrapobject.waitDriver(pContactClose, driver);
	    pContactClose.isDisplayed();
    }   
  public void contactClose() {
	    wrapobject.waitDriver(pContactClose, driver);
	    pContactClose.click();
        }
 
  public void clickAboutUs() throws InterruptedException {
	    driver.navigate().to(url);
		wrapobject.waitDriver(pAboutUs, driver);
		pAboutUs.click();
		wrapobject.waitDriver(pAboutUsClose, driver);
		WebElement title=driver.findElement(By.id("videoModalLabel"));
		title.isDisplayed();
		 }
		
  public void clickAboutUsClose() {
	    wrapobject.waitDriver(pAboutUsClose, driver);
		pAboutUsClose.click();
        }
  public void playVideoCheck() {
	    wrapobject.waitDriver(pPlayButton, driver);
		pPlayButton.click();
		
		}
  public void pauseVideoCheck() {
	    wrapobject.waitDriver(pPauseButton, driver);
	    pPauseButton.click();
        }
  public void volumeControl() {
	    Actions builder =new Actions(driver);
  	    Action dragDropElement=builder.dragAndDropBy(pDragFrom, 10, 10).build();
  	    dragDropElement.perform();
		}
  public void fullScreen() {
	  //wrapobject.waitDriver(pFullScreen, driver);
	  pFullScreen.click();
	  wrapobject.waitDriver(pNonFullScreen, driver);
	  pNonFullScreen.click();
      }
   }
