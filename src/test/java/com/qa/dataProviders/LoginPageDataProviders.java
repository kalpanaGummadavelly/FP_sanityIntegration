package com.qa.dataProviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.qa.utils.TestDataFunction;

public class LoginPageDataProviders {

	static TestDataFunction testDataFunction = new TestDataFunction();
	static String testfile1 = System.getProperty("user.dir") + "\\src\\test\\resourses\\FP_LoginPageTest.xlsx";
	
	@DataProvider(name="ValidateLoginPageTitle")
	public static Object[][] ValidateLoginPageTitle() throws IOException{
		return testDataFunction.readAllExcel(testfile1, "validateLoginPageTitle");
	}
	
	@DataProvider(name="ValidateAivanteLogo")
	public static Object[][] ValidateAivanteLogo() throws IOException{
		return testDataFunction.readAllExcel(testfile1, "validateAivanteLogo");
	}
	
	@DataProvider(name="ValidateLoginDetails")
	public static Object[][] ValidateLoginDetails() throws IOException{
		return testDataFunction.readAllExcel(testfile1, "validateLoginDetails");
	}
	
	
}
