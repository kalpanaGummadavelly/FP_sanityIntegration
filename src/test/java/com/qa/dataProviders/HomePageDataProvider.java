package com.qa.dataProviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.qa.utils.TestDataFunction;

public class HomePageDataProvider {
	
	static TestDataFunction testDataFunction = new TestDataFunction();
	static String testfile = System.getProperty("user.dir") + "\\src\\test\\resourses\\FP_HomePageTest.xlsx";
	
	@DataProvider(name="addNewContent")
	public static Object[][] addNewContent() throws IOException{
		return testDataFunction.readAllExcel(testfile, "AddNewContent");
	}
	
	@DataProvider(name="clickOnPDF")
	public static Object[][] clickOnPDF() throws IOException{
		return testDataFunction.readAllExcel(testfile, "ClickOnPDF");
	}
	@DataProvider(name="help")
	public static Object[][] helpTest() throws IOException{
		return testDataFunction.readAllExcel(testfile, "HelpIcon");
	}
	@DataProvider(name="changePassword")
	public static Object[][] changePasswordTest() throws IOException{
		return testDataFunction.readAllExcel(testfile, "ChangePassword");
	}


}
