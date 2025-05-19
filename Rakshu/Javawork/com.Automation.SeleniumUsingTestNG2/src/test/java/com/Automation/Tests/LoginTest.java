package com.Automation.Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Automation.Base.BaseSalesforceuser;
import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;

public class LoginTest extends BaseSalesforceuser {
	
	@Test
	public void testSuccessfulLogin() throws Exception {
	String usernameData=PropertiesUtility.readDataFromPropertyFile("src/test/resources/SalesforceProperties.properties", "username");
	String passwordData=PropertiesUtility.readDataFromPropertyFile("src/test/resources/SalesforceProperties.properties", "password");
	String username = null;
	String password = null;
	loginSalesForce(username, password);
	Thread.sleep(2000);
	try {
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message:" + alert.getText());
		alert.accept();
	}catch(NoAlertPresentException e) {
		System.out.println("No alert");
		
	}
	
}
	@Test
	public void testUnSuccessfulLogin() throws Exception {
		loginSalesForce("abc", "123");
		Thread.sleep(2000);
		WebElement errorMsg = driver.findElement(By.xpath("//*[@id='error']"));
		Assert.assertEquals
	(errorMsg.getText(), "Please check your username and password." +"If you still can't log in, contact your salesforce administrator. ");
		
}
	@Test
	public void testRememberUsernameCheck() throws Exception  {
		String username = PropertiesUtility.readDataFromPropertyFile
			("src/test/resources/SalesforceProperties.properties", "username");
		String password = PropertiesUtility.readDataFromPropertyFile
			("src/test/resources/SalesforceProperties.properties", "password");
		String rememberedUsername = rememberLogin(username, password);
		Assert.assertEquals(rememberedUsername, username);
		
 }
	@Test
	public void testForgotPassword() throws Exception {
		String username = PropertiesUtility.readDataFromPropertyFile
				("src/test/resources/SalesforceProperties.properties", "username");
		forgotPassword(username);
		Assert.assertEquals(((Alert) driver.findElements
				(By.xpath("//a[contains(text(),'Return to Login')]"))).getText(), "Return to Login");
	}
	
}
