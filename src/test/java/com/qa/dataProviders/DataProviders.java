package com.qa.dataProviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.qa.utils.TestBaseClass;
import com.qa.utils.TestDataFunction;

public class DataProviders{
	
	static TestDataFunction testDataFunction = new TestDataFunction();
	static String testfile = System.getProperty("user.dir") + "\\src\\test\\resourses\\FP_SanityTest.xlsx";
	
	@DataProvider(name="ServerLoginDetails")
	public static Object[][] ServerLoginDetails() throws IOException{
		return testDataFunction.readAllExcel(testfile, "Server&LoginDetails");
	}
	@DataProvider(name="planData1")
	public static Object[][] planData1() throws IOException{
		return testDataFunction.readAllExcel(testfile, "IndividualPlanData");
	}
	
	@DataProvider(name="planData")
	public static Object[][] planData() throws IOException{
		return testDataFunction.readAllExcel(testfile, "FamilyPlanData");
	}
	
	@DataProvider(name="primaryEditPlanData")
	public static Object[][] primaryEditPlanData() throws IOException{
		return testDataFunction.readAllExcel(testfile, "PrimaryEditPlanData");
	}
	@DataProvider(name="familyEditPlanData")
	public static Object[][] familyEditPlanData() throws IOException{
		return testDataFunction.readAllExcel(testfile, "FamilyEditPlanData");
	}
	@DataProvider(name="viewPlanData")
	public static Object[][] viewPlanData() throws IOException{
		return testDataFunction.readAllExcel(testfile, "PrimaryViewPlanData");
	}
	@DataProvider(name="familyViewPlanData")
	public static Object[][] familyViewPlanData() throws IOException{
		return testDataFunction.readAllExcel(testfile, "FamilyViewPlanData");
	}
	@DataProvider(name="deletePlanData")
	public static Object[][] deletePlanData() throws IOException{
		return testDataFunction.readAllExcel(testfile, "DeletePlan");
	}
	@DataProvider(name="reportBuilder")
	public static Object[][] repotBuilder() throws IOException{
		return testDataFunction.readAllExcel(testfile, "ReportBuilder");
	}
	@DataProvider(name="comparePlan")
	public static Object[][] comparePlan() throws IOException{
		return testDataFunction.readAllExcel(testfile, "ComparePlan");
	}

	
	
	
	
	
}
