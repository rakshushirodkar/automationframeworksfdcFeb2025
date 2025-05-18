package com.Appium.Android.Demo;

import java.net.URL;

public class DragNdrop {
	

	public static void main(String[] args) throws Exception {
		UiAutomator2Options uia=new UiAutomator2Options();

		uia.setCapability("appPackage","com.motorola.android.contacts");
		uia.setCapability("appActivity","com.motorola.android.contacts.contactslist.PeopleActivity");
		uia.setCapability("deviceName","ce011821c463571704");
		uia.setCapability("platformName","Android");
		uia.setCapability("platformVersion","14");

		URL url=new URL("http://127.0.0.1:4723/wd/hub");

		AndroidDriver driver=new AndroidDriver(url,uia);
		Thread.sleep(3000);
	
	}	
}	


	
	
	
	
	
		



