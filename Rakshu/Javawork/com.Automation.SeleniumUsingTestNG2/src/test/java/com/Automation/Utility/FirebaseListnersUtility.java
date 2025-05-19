package com.Automation.Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Automation.Base.BaseTest;

public class FirebaseListnersUtility extends BaseTest implements ITestListener,ISuiteListener{
	private Logger mylog = LogManager.getLogger(FirebaseListnersUtility.class);
	private ExtentReportsUtility extentReportUtility = ExtentReportsUtility.getInstance();
	
	@Override
	public void onStart(ISuite suite) {
		mylog.info(suite.getName()+" started......");
		extentReportUtility.startExtentReport();
	}
	
	@Override
	public void onFinish(ISuite suite) {
		mylog.info(suite.getName()+" ended.....");
		extentReportUtility.endReport();
	}
	
	
	@Override
	public void onStart(ITestContext context) {
		mylog.info(context.getName()+"  started---------");
	
	}

	@Override
	public void onFinish(ITestContext context) {
		mylog.info(context.getName()+" MyTest ended-----------");
	
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		mylog.info(result.getMethod()+"  started-----------");
		extentReportUtility.startSingleTestReport(result.getMethod()+ "ended with success.....");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		mylog.info(result.getMethod()+" @Test is ended with success-----------");
		extentReportUtility.logTestpassed(result.getMethod().getMethodName()+"ended with success....");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		mylog.error(result.getMethod().getMethodName()+"  ended with failure-----------");
		extentReportUtility.logTestFailedWithException(result.getThrowable());
		String fileName = new SimpleDateFormat("yyyy_MM_HH_mm_ss").format(new Date());
		String path = Constants.SCREENSHOTS_DIRECTORY_PATH+ fileName+".png";
		takeScreenshot(path);
		extentReportUtility.logTestWithscreenshot(path);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		mylog.warn(result.getMethod().getMethodName()+"  skipped-----------");
		extentReportUtility.logTestFailed(result.getMethod().getMethodName()+"end with skip.....  ");
	}

}
