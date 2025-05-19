package com.Automation.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseSalesforceuser extends BaseTest{
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void setUpReport() {
	ExtentSparkReporter spark = new ExtentSparkReporter("Screenshots/ExtentReports/Spark.html");
	extent = new ExtentReports();
	extent.attachReporter(spark);
	}
	
	public void loginSalesForce(String username, String password) throws InterruptedException {
		enterUserNameAndPassword(username, password);
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		clickElement(loginButton, "login");
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void enterUserNameAndPassword(String username, String password) {
		WebElement userName = driver.findElement(By.xpath("//*[@id='username']"));
		enterText(userName, username, "userName");
		WebElement passWord = driver.findElement(By.xpath("//*[@id='password']"));
		enterText(passWord,password,"password");
		
	}
	
	public String rememberLogin(String username, String password) throws InterruptedException {
		enterUserNameAndPassword(username,password);
		WebElement rememberCheckbox = driver.findElement(By.id("rememberUn"));
		if(!rememberCheckbox.isSelected()) {
			rememberCheckbox.click();
		}
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='Login']"));
		clickElement(loginButton, "login");
		Thread.sleep(2000);
		logOutSalesforce();
		return driver.findElement(By.id("username")).getAttribute("value");
		
	}
	
	public void forgotPassword(String username) throws InterruptedException{
		WebElement passwordForgot = driver.findElement(By.id("forgot_password_link"));
		clickElement(passwordForgot, "forgotpassword");
		Thread.sleep(2000);
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"un\"]"));
		enterText(userName, username, "username");
		WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
		clickElement(continueButton, "continue");
		Thread.sleep(2000);
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setUpBeforeMethod(@Optional("chrome") String browser) throws InterruptedException{
		enterBrowser(browser);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
String url = PropertiesUtility.readDataFromPropertyFile(Constants.SALESFORCE_PROPERTIES, "url");
		getURL(url);
		
	}

	private void getURL(String url) {
		// TODO Auto-generated method stub
		
	}

	private void enterBrowser(String browser) throws InterruptedException {
	String url = PropertiesUtility.readDataFromPropertyFile(Constants.SALESFORCE_PROPERTIES, "url");
		goToUrl(url);
		Thread.sleep(2000);
		
	}

	private void logOutSalesforce() throws InterruptedException {
	  WebElement logout_button = driver.findElement(By.xpath("//*[@title='Logout']"));
	  clickElement(logout_button, "logout");	
	  Thread.sleep(2000);
	
		
	}

}
