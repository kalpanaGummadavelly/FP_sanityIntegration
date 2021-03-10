package com.qa.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestBaseClass;

public class LoginPage extends TestBaseClass{
	
	//object repository
	@FindBy(name="email")WebElement username;
	@FindBy(name="password")WebElement password;
	@FindBy(xpath="//button[@id='submit']")WebElement signUpBtn;
	@FindBy(xpath="//body/main[1]/div[1]/div[1]/img[1]")WebElement dzeeLogo;
	@FindBy(xpath="//div[@id='login_page_message']")WebElement loginPageMessage;
	
	
	//initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	  public String validateLoginPageTitle() { 
		  return driver.getTitle(); 
		  }
	  
	  public boolean validateAivanteLogo() { 
		  return dzeeLogo.isDisplayed(); 
		  }
	   
	 	
		  public HomePage login(String userName,String passWord) throws Exception {
			  
			username.sendKeys(userName);
			password.sendKeys(passWord);
			Thread.sleep(1000);
			jsClick(signUpBtn);
			Thread.sleep(1000);
			String message = loginPageMessage.getText();
			System.out.println("loginPageMessage "+message);
			assertTrue(message.equals("loginPageMessage Email / User ID or Password is invalid!\r\n" + 
					"×"));
			return new HomePage();
		}
		  
		  public HomePage fplogin(String userName,String passWord,String userType) throws Exception {
			  if(userType.equalsIgnoreCase(userType)) {
				username.sendKeys(userName);
				password.sendKeys(passWord);
				TestBaseClass.takeScreenshot();
				Thread.sleep(1000);
				jsClick(signUpBtn);
				Thread.sleep(1000);
			  }else {
				  System.out.println("provided userName and password are in correct");
			  }
				return new HomePage(); 
			}
	
	
	

}
