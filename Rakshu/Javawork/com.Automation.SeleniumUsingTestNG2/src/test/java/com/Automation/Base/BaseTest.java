package com.Automation.Base;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Automation.Utility.ExtentReportsUtility;
import com.google.common.io.Files;

import example.LogTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	Logger mylog =LogManager.getLogger(LogTests.class);
	protected ExtentReportsUtility extentReportUtility = ExtentReportsUtility.getInstance();
	
//	private static final String objName = null;
//	private static final Alert ele = null;
	protected static WebDriver driver=null;
	private WebDriverWait wait=null;
	private WebElement ele;
	private String objName;

	public void launchBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		default:
			break;
		}
	}
	
	public void goToUrl(String url){
		driver.get(url);
   }
	
	public void closeDriver(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	 }
	
	public void enterText(WebElement ele,String data,String objName) {
		if(ele.isDisplayed())
		{
			ele.clear();
			ele.sendKeys(data);
			mylog.info("data is entered to "+objName);
			extentReportUtility.LogTestInfo("data is entered to " +objName);
		}
		else
		{
			mylog.error(objName+ "textbox is not displayed");
			extentReportUtility.logTestFailedWithException(objName+" textbox is not displayed");
		
	    }
	}
		
	public String getTextFromElement(){
			String data =null;
			if(ele.isDisplayed()) {
				data  = ele.getText();
			}
			else {
				mylog.info(objName+" not dispalyed");
			}
			return data ;
		}

    public void clickElement(WebElement ele,String objName) {
			if(ele.isEnabled())
			{
				ele.click();
				mylog.info(objName+" button is clicked");
				extentReportUtility.LogTestInfo(objName+ " button is clicked");
			}
			else {
				mylog.info(objName+" button is not displayed");
				extentReportUtility.logTestFailedWithException(objName+" button is not displayed");
			}
		}

	public void selectCheckBox(WebElement ele,String objectName) {
			if(!ele.isSelected()) {
				ele.click();

			}
			else{
				mylog.error(objectName+" button is already selected");
			}
		}
	public void waitUntilAlertPresent(int sec) {

		}


		// ******************************Select class reusable method starts*************************************

	public void selectByValueData(WebElement ele, String value) {

			Select select = new Select(ele);
			select.selectByValue(value);
		}

	public void selectByTextData(WebElement ele, String value) {

			Select select = new Select(ele);
			select.selectByVisibleText(value);;
		}
	public void selectByIndexData(WebElement ele, int value) {

			Select select = new Select(ele);
			select.selectByIndex(value);
		}




		// ******************************select class reusable method ends**************************************

		// ******************************alert starts**************************************

	public Alert switchToAlert() {
			return null;

		}

    public String getAlertText(Alert alert, String objectname) {
			return objectname;


		}
	public void AcceptAlert(Alert alert) {
			alert.accept();
			mylog.info("Alert accepted");

		}
	public void CancelAlert(Alert alert) {
			alert.dismiss();
			mylog.info("Alert cancelled");

		}
		// ******************************alert ends**************************************

		// ******************************Action class reusable methods**************************************


		public void mouseOverOnElement(WebElement ele, String objName) {

		}

		public void ContextClickOnElement(WebElement ele, String objName) {

		}



		//*********************************************waits reusable methods start*************************************


		public void waitForVisibility(WebElement ele,long timeInSec,String ObjectName) {
			mylog.info(ObjectName+ "waiting for visibility for maximum of "+timeInSec+ "sec");
			wait=new WebDriverWait(driver,timeInSec);
			wait.until(ExpectedConditions.visibilityOf(ele));
		}

		public void waitForAlertToPresent(long timeInSec,String ObjectName) {

		}

		public void waitForElementToClickable(WebElement ele,long timeInSec,String ObjectName) {

		}


		public void waitForVisibility(WebElement ele, int time, int pollingtime, String objectName) {

		}

		public void takeScreenshot(String filepath) {
			TakesScreenshot screenCapture=(TakesScreenshot)driver;
			File src= screenCapture.getScreenshotAs(OutputType.FILE);
			File destFile=new File(filepath);
			try {
				Files.copy(src, destFile);
				mylog.info("screen captured");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mylog.error("problem occured during screenshot taking");
			}
		}




	}
	
	

