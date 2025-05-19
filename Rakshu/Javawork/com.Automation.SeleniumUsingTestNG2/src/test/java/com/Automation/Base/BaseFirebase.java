package com.Automation.Base;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;

public class BaseFirebase extends BaseTest {
	
	public void login_Firebase() {

		String usernameData=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		WebElement usernameEle = driver.findElement(By.xpath("//*[@id=\"email_field\"]"));
		waitForVisibility(usernameEle, 30, "username");
		enterText(usernameEle,usernameData, "username");

		WebElement passwordEle = driver.findElement(By.id("password_field"));
		enterText(passwordEle,passwordData, "password");

		WebElement buttonEle = driver.findElement(By.tagName("button"));
		clickElement(buttonEle, "login button");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}


	@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeMethod(@Optional("chrome") String browserName)
	{
		launchBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		String url=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "url");
		goToUrl(url);
	}

	@AfterMethod
	public void tearDownAfterMethod()
	{
		
         driver.close();
	}	


	
}




