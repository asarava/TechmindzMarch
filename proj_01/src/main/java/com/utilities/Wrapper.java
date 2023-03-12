package com.utilities;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
  
public class Wrapper {
	boolean flag=true;
	String alertText;
	public void waitDriver(WebElement pElement,WebDriver driver){
		WebDriverWait wait=new WebDriverWait(driver,2000);
		wait.until(ExpectedConditions.elementToBeClickable(pElement));
		}
	public String alertText(WebDriver driver) throws InterruptedException {
		Alert alert=driver.switchTo().alert();
		alertText=alert.getText();
		alert.accept();
		return alertText;
				
		}
	public void closePopUp(WebElement button) {
		button.click();
		
	}
	
	public void waitDriverAlert(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.alertIsPresent());
		}
	public  String alertHandle(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alertText=alert.getText();
		alert.accept();
		System.out.println(alertText);	
		return alertText;
		}
    public boolean passwordLengthCheck(String pPassword) {
    	int len=pPassword.length();
        if((len>6) && (len<13)) {
        	System.out.println("Password length is matching length criteria");
      	    flag=true;
      	    }else {
      	    flag=false;	
      	    }
        return flag;
         }
           
    public boolean contactMessageLength(String contactText) {
        int len=contactText.length();
         if((len>100)) {
            flag=false;
          	System.out.println("message should not exceed 100 words");
            }else {
            	flag=true;
            }
         return flag;
         }
    
    public boolean getPageSource(WebDriver driver,String pValue) {
    	 String source=driver.getPageSource();
    	  // System.out.println(source);
    	 if(source.contains(pValue)) {
    		 flag=true;
    	    }else {
    	    flag=false;
    	    }
    	 return flag;
       } 
    	 
    public void dragDrop(WebDriver driver,WebElement pValue) {
    	Actions builder =new Actions(driver);
    	Action dragDropElement=builder.dragAndDropBy(pValue, 10, 10).build();
    	dragDropElement.perform();
        }
     }
	
    	
    	
    	
    
	
