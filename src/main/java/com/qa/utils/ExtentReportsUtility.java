package com.qa.utils;

import java.lang.reflect.Method;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;






public class ExtentReportsUtility{
	protected static ExtentReports extent;	
	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentTest test, logger;
	
	

	@BeforeTest(alwaysRun = true)
	public void startReport(){
		
		 Date d=new Date();
		 String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test report\\" + fileName);
		 htmlReporter.config().setDocumentTitle(" Financial Planner ");
		 htmlReporter.config().setReportName("Financial Planner Tests ");
		 htmlReporter.config().setTheme(Theme.STANDARD);
		 htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		 
		 extent = new ExtentReports();
		 extent.setSystemInfo("Host Name ", "Aivante");
		 extent.attachReporter(htmlReporter);
	
}
	@BeforeMethod(alwaysRun = true)
	public void startTest(Method method){
		String className = this.getClass().getSimpleName();
		logger = extent.createTest(method.getName().toString());	
		TestBaseClass testBaseClass = new TestBaseClass();
		testBaseClass.setExtentTest(logger);
	}
	@AfterMethod(alwaysRun = true)
	 public void getResult(ITestResult result){
		 if(result.getStatus() == ITestResult.FAILURE) {
	        	try{
	        		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	        		logger.fail(result.getThrowable());
	
	        	}catch(Exception e){e.printStackTrace();}
	            	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	        	logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	        	logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	        	logger.skip(result.getThrowable());
	        }
		 }
		 
		 @AfterTest(alwaysRun = true)
			public void endReport(){
				extent.flush();
		  
}
	
	
	}
