package com.Appium.Android.Demo;

import java.net.MalformedURLException;
import java.net.URL;


public class SoloAppDemo {
	
	public static void main(String[] args) throws MalformedURLException {
		/*
		 * DesiredCapabilities dc=new DesiredCapabilities();
		 * dc.setCapability("appPackage","com.solodroid.solomerce");
		 * dc.setCapability("appActivity",
		 * "com.solodroid.solomerce.activities.ActivitySplash");
		 * dc.setCapability("deviceName","ce011821c463571704");
		 * dc.setCapability("platformName","Android");
		 * dc.setCapability("platformVersion","9");
		 */
		
		UiAutomator2Options uia=new UiAutomator2Options();
		uia.setApp("C:\\Users\\rhianil\\Downloads\\Apk\\Solodroid_E-CommerceApp.apk");
	//	uia.setCapability("appPackage","com.solodroid.solomerce");
	//	uia.setCapability("appActivity","com.solodroid.solomerce.activities.ActivitySplash");
		uia.setCapability("deviceName","ZY22KXK9LD");
		uia.setCapability("platformName","Android");
		uia.setCapability("platformVersion","14");
		
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		
		AndroidDriver driver=new AndroidDriver(url,uia);
		
		
	}

}
