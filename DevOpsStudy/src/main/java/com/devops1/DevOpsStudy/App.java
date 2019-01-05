package com.devops1.DevOpsStudy;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class App {

	final static String DATETIME = getDateTime();
	final static String OS = getOS();
	final static String USERNAME = getUsername();
	final static double JAVAVERSION = getVersion();
	
    //create variables
	protected static WebDriver driver;
	
	//deafault contructor
	public App(){}
	
	//parameterized constructor
	public App(WebDriver driver){
		App.driver = driver;
	}
    //this returns the webdriver
	public WebDriver getDriver() {
		return driver;
	}
    //this set the webdriver
	public void setDriver(WebDriver driver) {
		App.driver = driver;
	}
	
	//close the browser
	public static void closeBrowser(){
		if(driver != null) driver.close();
	}
	
	//system info
	public static void systemInfo(){
		Reporter.log(DATETIME, true);
		Reporter.log(OS, true);
		Reporter.log(USERNAME, true);
		Reporter.log(String.valueOf(JAVAVERSION), true);
	}
	
	//timestamp method
	public String timeStamp(){
		SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy  hh:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String now = dateformat.format(date);

		return now;
	}

	//log the steps
	public void log(String step){
		//call the reporter.log method
		Reporter.log(timeStamp()+"   "+step, true);
	}

	public static String getDateTime(){
		SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy  hh:mm:ss a");
		Date date = new Date(System.currentTimeMillis());
		String now = dateformat.format(date);

		return now;
	}

	static String getOS(){
		String os = System.getProperty("os.name");

		return os;
	}

	static String getUsername(){
		String username = System.getProperty("user.name");

		return username;
	}

	static double getVersion(){
		String javaVersion = System.getProperty("java.specification.version");

		return Double.parseDouble(javaVersion);
	}
}
