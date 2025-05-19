package com.Automation.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseProfileuser extends BaseSalesforceuser {
	
	public void selectMyProfile() {
		WebElement userMenu = driver.findElement(By.xpath("//*[@id='userNavButton']"));
		clickElement(userMenu, "userMenu");
		WebElement myProfile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		
	}

}
