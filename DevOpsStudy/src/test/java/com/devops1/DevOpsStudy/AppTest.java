package com.devops1.DevOpsStudy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest{ 
   //create an instance of facebook class
	Facebook facebook = new Facebook();
	
 @BeforeTest
 public void setup() throws Exception {
	 //get system info
	 App.systemInfo();
	 //call the initialized method
	 facebook.initialize();
 }
 
 @Test
 public void signUp() throws Exception {
	 //go to Url
	 facebook.navigateToUrl();
	 //create new user account
	 facebook.facebookSignUp();
 }
 
 
 @AfterTest
 public void tearDown() throws Exception {
	 App.closeBrowser();
 }
}
