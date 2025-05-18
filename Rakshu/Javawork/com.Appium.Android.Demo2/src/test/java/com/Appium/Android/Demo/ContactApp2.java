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

import java.net.URL;

public class ContactApp2 {
	
	private static final String AppiumBy = null;

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
	driver.findElement(AppiumBy.accessibiltyId("Open drawer")).click();
	// driver.findElement(AppiumBy.accessibilityId("Open drawer")).click();
	
	
	int startY=(int)(size.height*0.7); 
	  int endY=(int)(size.height*0.3); 
	  int center=size.width/2;
	  PointerInput finger= new PointerInput(Kind.TOUCH,"finger"); 
	  Sequence scroll=new Sequence(finger, 0);
	  scroll.addAction(finger.createPointerMove(Duration.ofSeconds(0),Origin.viewport(), center,startY)); 
	  scroll.addAction(finger.createPointerDown(0));
	  scroll.addAction(finger.createPointerMove(Duration.ofSeconds(1),Origin.viewport(), center,endY)); 
	  scroll.addAction(finger.createPointerUp(0));
	 
	  driver.perform(Arrays.asList(scroll));
	 

   }
}
