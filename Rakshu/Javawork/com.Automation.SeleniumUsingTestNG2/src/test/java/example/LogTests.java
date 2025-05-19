package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LogTests {
	Logger mylog;
	ExtentReports extent = null;
	ExtentSparkReporter spark = null;
	
	
	@BeforeClass
	public void setUp()
	{
		 mylog =LogManager.getLogger(LogTests.class);
		 extent = new ExtentReports();
		 
		 spark = new ExtentSparkReporter("Screenshot/Spark.html");
		 
		 spark.config().setDocumentTitle("Test Execution Report");
		 spark.config().setReportName("firebase regression test");
		 spark.config().setTheme(Theme.DARK);
		 
		 extent.setSystemInfo("Host Name", "Firebase App");
		 extent.setSystemInfo("Environment", "QA");
		 extent.setSystemInfo("Username", "Rakshita");
		 extent.attachReporter(spark);
	}
	
	@AfterClass
	public void tearDown()
	{
		extent.flush();     //closing the reports
	}
	
	
	@Test
	public void test1()
	{
		ExtentTest test = extent.createTest("test1");
		try {
		//	int a =10/0;
//		System.out.println("test1 completed with success");
		mylog.info("test1 completed with success");	
		test.pass("test1 completed with success");
	//	test.log(Status.PASS, "test1 completed with success");
		
	
	}
		catch(ArithmeticException e)
		{
		//	System.out.println("Test1 completed with failure");
			mylog.error("test1 completed with failure");
		//	test.fail("test1 completed with failure");
		//	test.log(Status.FAIL, "test1 completed with failure");
			test.log(Status.FAIL, e);
			
		}
	}	
	
	@Test
	public void test2()
	{
		ExtentTest test = extent.createTest("test2");
	//	System.out.println("test2 completed with success");
		mylog.debug("test2 started");
		test.info("test2 started");
	}
	
	@Test
	public void test3()
	{
		ExtentTest test = extent.createTest("test3");
	//	System.out.println("driver is started");
		mylog.debug("driver is started");
		test.warning("driver is started");
	}
	
	

}
