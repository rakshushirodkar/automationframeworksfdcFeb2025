package com.Automation.Tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.BaseFirebase;
import com.Automation.Utility.Constants;
import com.Automation.Utility.ExcelUtility;
import com.Automation.Utility.ExtentReportsUtility;

public class AutomationScripts extends BaseFirebase {
	private Logger mylog = LogManager.getLogger(AutomationScripts.class);
	
	@Test
	public void invalid_login() throws Exception{
		WebElement username_field =driver.findElement(By.id("email_field"));
		waitForVisibility(username_field,20,"username");
		
		WebElement password_field = driver.findElement(By.id("password_field"));
		enterText(password_field, "admin","password");
		
		WebElement loginButton = driver.findElement(By.tagName("button"));
		clickElement(loginButton, "login");

		Thread.sleep(3000);

		waitForAlertToPresent(20,"Alert Window");

	//	try {
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		mylog.info("alert box accepted and closed, test completed");
		extentReportUtility.LogTestInfo("alert box accepted and closed, test completed");
	//	System.out.println("Alert handled successfully: Passed");
		}
	//	catch(NoAlertPresentException e)
	//	{
	//		System.out.println("Failed");
	//	}
//	}
	
	@DataProvider(name="logindata")
	public Object[][] readData()
	{
		return ExcelUtility.readAllDataFromXlToArray(Constants.LOGINCREDENTIALS_EXCEL, "Sheet1");
	}
	
	@Test
	public void valid_login() throws Exception {
		Thread.sleep(3000);
		login_Firebase();
		Thread.sleep(3000);

		WebElement form_container = driver.findElement(By.cssSelector(".container"));
		String expected_formValue="Student Registration Form";
		String actual_formValue=driver.findElement(By.xpath("//div/h1")).getText();
	//	String actual_formValue=driver.findElement(By.xpath("//div/h2")).getText();   //  if test case failed

		if(actual_formValue.equals(expected_formValue))
		{
			System.out.println("Testcase is passed");
		}
		else
		{
			System.out.println("Testcase is failed");
			File src=form_container.getScreenshotAs(OutputType.FILE);
			String finalname=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			takeScreenshot(Constants.SCREENSHOTS_DIRECTORY_PATH+finalname+".png");
		}
		
		closeDriver();
	}


}
	


	
	


