package facebooksignup;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookSignUp {
	final static String DATETIME = getDateTime();
	final static String OS = getOS();
	final static String USERNAME = getUsername();
	final static double JAVAVERSION = getVersion();
	
	//declare variables
	WebDriver driver;
	String Url, firstname,lastname, email, password, birthMonth, birthDay, birthYear;
			
	@BeforeTest
	public void setup() throws Exception {
		//initialize variables
		//System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		//start the browser
		driver = new ChromeDriver();
		//maximize the browser
		
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
	
	@Test(enabled = true, priority = 0)
	public void machineInfo(){
    	//susyem information
		systemInfo();
	}
	
	@Test(enabled = true, priority = 1)
	public void signup() throws Exception   {
		//Step 1: go Url
		driver.navigate().to(Url);
		Thread.sleep(3000);
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
	
	@AfterTest
	public void closeBrowser() throws Exception {
		driver.close();
	}
	
	
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
