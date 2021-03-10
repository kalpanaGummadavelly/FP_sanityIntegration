package com.qa.testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.dataProviders.HomePageDataProvider;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestBaseClass;

public class HomePageTest extends TestBaseClass {

	LoginPage loginpage;
	HomePage homePage;
	SoftAssert softassert = new SoftAssert();
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod()
	public void setUp() throws Exception {
		initialization();
		loginpage = new LoginPage();
        homePage =loginpage.fplogin(TestBaseClass.loginMap.get("userName"), TestBaseClass.loginMap.get("passWord"),TestBaseClass.loginMap.get("userType"));
		Thread.sleep(1000);
		
	}
	@Test(dataProvider = "addNewContent",dataProviderClass = HomePageDataProvider.class)
	public void addNewContentWithEmailIdTest(String Execute,String emailId) throws Exception {
		homePage.addNewContentWithEmailId(emailId);
		softassert.assertAll();
		
	}
	
	@Test(dataProvider = "clickOnPDF",dataProviderClass = HomePageDataProvider.class)
	public void clickOnPDFInAddContentTest(String Execute) throws Exception {
		homePage.clickOnPDFInAddContent();
		softassert.assertAll();
	}
	@Test(dataProvider = "help",dataProviderClass = HomePageDataProvider.class)
	public void helpTest(String Execute) throws Exception {
		homePage.Help();
		softassert.assertAll();
	}
	@Test(dataProvider = "changePassword",dataProviderClass = HomePageDataProvider.class)
	public void changePasswordTest(String Execute,String OldPassword,String NewPassword,String ConfirmNewPassword) {
		homePage.ChangePassword(OldPassword, NewPassword, ConfirmNewPassword);
		softassert.assertAll();
	}
	
	
	@AfterMethod()
	public void tearDown() {
	driver.quit();	
	}
	
}
