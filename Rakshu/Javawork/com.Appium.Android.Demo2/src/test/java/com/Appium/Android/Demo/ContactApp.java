package com.Appium.Android.Demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ContactApp {
	
	private static Object AppiumBy;

	public static void main(String[] args) throws Exception {
		UiAutomator2Options uia=new UiAutomator2Options();

		uia.setCapability("appPackage","com.motorola.android.contacts");
		uia.setCapability("appActivity","com.motorola.android.contacts.contactslist.PeopleActivity");
		uia.setCapability("deviceName","ce011821c463571704");
		uia.setCapability("platformName","Android");
		uia.setCapability("platformVersion","9");

		URL url=new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver driver=new AndroidDriver(url,uia);
		Thread.sleep(3000);
		
		/*
		 * PointerInput finger=new PointerInput(Kind.TOUCH,"finger"); 
		 * Point tapPoint=new Point(455,1337); 
		 * Sequence tap=new Sequence(finger, 1);
		 * tap.addAction(finger.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint.x,tapPoint.y));
		 * tap.addAction(finger.createPointerDown(0));
		 * tap.addAction(finger.createPointerUp(0)); driver.perform(Arrays.asList(tap));
		 * Thread.sleep(3000);
		 * driver.findElement(AppiumBy.id("com.samsung.android.contacts:id/display_name_card_alternate_icon")).click();
		 * Thread.sleep(3000);
		 * driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("This is my Feb,2025 batch"); 
		 * driver.hideKeyboard(); // hide or close the keyboard
		 */
		/*
		 * // LongPress 
		 * PointerInput finger=new PointerInput(Kind.TOUCH,"finger"); 
		 * Point tapPoint=new Point(455,1337); Sequence tap=new Sequence(finger, 1);
		 * tap.addAction(finger.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint.x,tapPoint.y));
		 * tap.addAction(finger.createPointerDown(0)); 
		 * tap.addAction(new Pause(finger,Duration.ofSeconds(1)));
		 * tap.addAction(finger.createPointerUp(0)); 
		 * driver.perform(Arrays.asList(tap));
		 * 
		 */
		
	
	//	System.out.println(driver.manage().window().getSize());
	/*
	 * // scroll Dimension size=driver.manage().window().getSize(); 
	 * int startY=(int)(size.height*0.7); 
	 * int endY=(int)(size.height*0.3); 
	 * int center=size.width/2;
	 * PointerInput finger= new PointerInput(Kind.TOUCH,"finger"); 
	 * Sequence scroll=new Sequence(finger, 0);
	 * scroll.addAction(finger.createPointerMove(Duration.ofSeconds(0),Origin.viewport(), center,startY)); 
	 * scroll.addAction(finger.createPointerDown(0));
	 * scroll.addAction(finger.createPointerMove(Duration.ofSeconds(1),Origin.viewport(), center,endY)); 
	 * scroll.addAction(finger.createPointerUp(0));
	 * 
	 * driver.perform(Arrays.asList(scroll));
	 */
		
		
		// another way for scroll
		driver.findElement(AppiumBy.an
				("new UiScrollable(new UiSelector()."
						+ "resourceId(\"com.samsung.android.contacts:id/contact_list\")).scrollForward()"));
		
		
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("customer care")).click();
	}

}
