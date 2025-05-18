package com.Appium.Android.Demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;

public class Calcy {
	
	public static void main(String[] args) throws MalformedURLException {

		UiAutomator2Options uia=new UiAutomator2Options();

		uia.setCapability("appPackage"," com.google.android.calculator");
		uia.setCapability("appActivity","com.android.calculator2.Calculator t209");
		uia.setCapability("deviceName","ZY22KXK9LD");
		uia.setCapability("platformName","Android");
		uia.setCapability("platformVersion","14");
		

		URL url=new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver driver=new AndroidDriver(url,uia);
		
		/*
		 * driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")).click();
		 * driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Plus\"]")).click();
		 * driver.findElement(AppiumBy.accessibilityId("2")).click();
		 */
		
		PointerInput finger=new PointerInput(Kind.TOUCH,"finger");
		Point tapPoint=new Point(420,1528);
		Sequence tap=new Sequence(finger, 1);
		tap.addAction(finger.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint.x,tapPoint.y));
		tap.addAction(finger.createPointerDown(0));
		tap.addAction(finger.createPointerUp(0));
		driver.perform(Arrays.asList(tap));
		
		
		PointerInput finger2=new PointerInput(Kind.TOUCH,"finger");
		Point tapPoint2=new Point(900,1730);
		Sequence tap2=new Sequence(finger2, 1);
		tap2.addAction(finger2.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint2.x,tapPoint2.y));
		tap2.addAction(finger2.createPointerDown(0));
		tap2.addAction(finger2.createPointerUp(0));
		driver.perform(Arrays.asList(tap2));
		
		
		PointerInput finger3=new PointerInput(Kind.TOUCH,"finger");
		Point tapPoint3=new Point(420,1730);
		Sequence tap3=new Sequence(finger3, 1);
		tap3.addAction(finger3.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint3.x,tapPoint3.y));
		tap3.addAction(finger3.createPointerDown(0));
		tap3.addAction(finger3.createPointerUp(0));
		driver.perform(Arrays.asList(tap3));
		
	}

}
