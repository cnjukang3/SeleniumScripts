package com.devops1.DevOpsStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook extends App {

	//declare variables
	String Url, firstname,lastname, email, password, birthMonth, birthDay, birthYear;
	
	//default constructor
	public Facebook(){}
	
	//create a super class cpnstructor
	public Facebook(WebDriver driver){
		super(driver);
	}
	
	//initialize variables method
	public void initialize(){
		//start the browser
		driver = new ChromeDriver();
		//assign the Url
		Url = "https://www.facebook.com/r.php";
		//initialize variables
		firstname = "Lora";
		lastname = "Bush";
		email = "lorabush@yahoo.com";
		password = "12345#$$$$";
		birthMonth = "Dec";
		birthDay = "20";
		birthYear = "1988";
	}
	
	//create a test method
	public void facebookSignUp() throws Exception {
		//Step 2: find out the first name text box and enter first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
		Thread.sleep(2000);
		log(firstname);
		//Step 3: find out the last name text and enter last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		Thread.sleep(2000);
		log(lastname);
		//Step 4: find out the mobile number or email text box and enter it
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(email);
		Thread.sleep(2000);
		log(email);
		//Step 5: find out the mobile number or email and re-enter it
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(email);
		Thread.sleep(2000);
		log(email);
		//Step 6: find out the password text box and enter password
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(password);
		Thread.sleep(2000);
		log(password);
		//Step 7: find out the month of birth and select it
		driver.findElement(By.xpath("//select[@id='month']")).sendKeys(birthMonth);
		Thread.sleep(2000);
		log(birthMonth);
		//Step 8: find out the day of birth and select it
		driver.findElement(By.xpath("//select[@id='day']")).sendKeys(birthDay);
		Thread.sleep(2000);
		log(birthDay);
		//Step 9: find out the year of birth and select it
		driver.findElement(By.xpath("//select[@id='year']")).sendKeys(birthYear);
		Thread.sleep(2000);
		log(birthYear);
		//Step 10: find out the gender radio button and click
		driver.findElement(By.xpath("//input[@value='1']")).click();
		Thread.sleep(5000);
	}
	
	//navigate to Url
	public void navigateToUrl() throws Exception{
		driver.navigate().to(Url);
		Thread.sleep(3000);
	}
}
