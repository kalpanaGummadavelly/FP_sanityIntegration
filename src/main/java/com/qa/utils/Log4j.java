package com.qa.utils;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.aventstack.extentreports.Status;



public class Log4j extends ExtentReportsUtility {
	private static Logger Log = Logger.getLogger(Log4j.class.getName());
	static StringBuffer sb=new StringBuffer();
	static boolean isTrue = false;
	public Log4j(){
		DOMConfigurator.configure("log4j.xml");
	}

	public static void info(String message){
		Log.info(message);
		if (test==null){ 
			sb.append(message);	
		}else if (isTrue == false){
			test.log(Status.INFO, sb.toString());
			isTrue = true;
			test.log(Status.INFO, message);
		}else{
			test.log(Status.INFO, message);
		}
	}
	
	public static void warn(String message){
		Log.warn(message);
		test.log(Status.WARNING, message);
	}
	
	public static void error(String message) {
	    Log.error(message);
	    test.log(Status.ERROR, message);
		}
	 
	public static void exception(String message, Exception e){
	Log.error(message, e);	
	test.log(Status.ERROR, e.getStackTrace().toString());
	}
	
	 public static void fatal(String message) {
	    Log.fatal(message);
	    System.exit(1);
	    return;
		}
	 
	 public static void debug(String message) {
	    Log.debug(message);
		}
}


