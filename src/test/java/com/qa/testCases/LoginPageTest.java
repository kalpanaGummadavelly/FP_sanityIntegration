package com.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.dataProviders.DataProviders;
import com.qa.dataProviders.LoginPageDataProviders;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestBaseClass;

public class LoginPageTest extends TestBaseClass {
	LoginPage loginpage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() throws IOException {
		initialization();
		loginpage = new LoginPage();

	}

	
	  @Test(priority=1,dataProvider ="ValidateLoginPageTitle",dataProviderClass = LoginPageDataProviders.class) 
	  public void loginPageTitleTest(String Execute) { 
	  String Title=loginpage.validateLoginPageTitle(); 
	  System.out.println("Title is "+Title);
	  Assert.assertEquals(Title,"AiVante Solutions Login");
	  }
	  
	  @Test(priority=2,dataProvider ="ValidateAivanteLogo",dataProviderClass = LoginPageDataProviders.class)
	  public void AivanteLogoTest(String Execute) { 
	   boolean flag =loginpage.validateAivanteLogo(); 
	   Assert.assertTrue(flag); 
	  }
	  
	  @Test(priority = 3,dataProvider ="ValidateLoginDetails",dataProviderClass = LoginPageDataProviders.class)
	public void loginTest(String Execute,String userName,String passWord) throws Exception {
		homePage = loginpage.login(userName,passWord);
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
