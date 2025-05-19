package com.Automation.Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Automation.Base.BaseSalesforceuser;
import com.Automation.Utility.PropertiesUtility;

public class UsermenuTest extends BaseSalesforceuser {
	
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
	public void userProfile() throws Exception {
		WebElement userProfile = driver.findElement(By.xpath("//*[@id='userNavLabel']"));
		clickElement(userProfile, "username");
		WebElement userDropDownList = driver.findElement(By.id("//*[@id=\"userNav-menuItems\"]/a[1]"));
		 userDropDownList.click();
		 Thread.sleep(3000);
	}
	@Test
	public void user() throws Exception {
		WebElement user = driver.findElement(By.xpath("//*[@id='userNavLabel']"));
		user.click();
		Thread.sleep(3000);
		 
	}
	@Test
	public void switchtoMenu() throws Exception {
		 
 WebElement switchToMenu =driver.findElement(By.xpath("//div[@id = 'userNavMenu']"));
	
	 Actions actions = new Actions (driver); //mouse & keyboard operation (build().perform()0
actions.moveToElement(switchToMenu).build().perform();
	 
	 Thread.sleep(5000);
		
	}
	@Test
	public void MySetting() throws Exception {
	WebElement MySetting = driver.findElement(By.xpath("My Settings"));
	MySetting.click();
	Thread.sleep(3000);
  
	}
	@Test
	public void personal() throws Exception {
		WebElement personal = driver.findElement(By.xpath("//*[@id='PersonalInfo_font']"));
		personal.click();
		Thread.sleep(5000);
	}
	@Test
	public void loginHistory() throws Exception {
		WebElement loginHistory = driver.findElement(By.linkText("Login History"));
		loginHistory.click();
		Thread.sleep(3000);
	}
	@Test
	public void devConsole() throws Exception {
		 WebElement devConsole = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[3]"));
		 devConsole.click();
		 Thread.sleep(3000);
    }
	@Test
	public void logoutButton() throws Exception {
		WebElement logoutbutton = driver.findElement(By.xpath("//*[@title='Logout']"));
		//	logout_button.click();
			clickElement(logoutbutton, "logout");
			Thread.sleep(3000);
			
	}
}
	

