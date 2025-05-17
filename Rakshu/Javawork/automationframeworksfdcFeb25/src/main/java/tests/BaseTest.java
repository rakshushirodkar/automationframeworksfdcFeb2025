package tests;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import listerns.TestListeners;
import utils.ReportManager;

@Listeners(TestListeners.class)

public class BaseTest {
	
	public static ExtentReports report;
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> threadLocalTest = new ThreadLocal<ExtentTest>();
	public static Logger logger = LogManager.getLogger("BaseTest");
	
	public static void setDriver(String browserName, boolean headless) {
		WebDriver driver = BaseTest.getBrowserDriver(browserName, headless);
		logger.debug("BaseTest : setDriver : Browser object is set for "+browserName);
		threadLocalDriver.set(driver);
	}
	
	public static WebDriver getBrowser() {
		return threadLocalDriver.get();
	}
	
	@Parameters("bName")
	@BeforeMethod
	public void setupBrowser(@Optional("chrome") String browserName, Method name) {
		System.out.println("BrowserName = " + browserName);
		BaseTest.setDriver(browserName, false);
		logger.debug("BaseTest : setupBrowser : Browser is setting up..");
		ExtentTest test = report.createTest(name.getName());
		report.attachReporter();
		logger.debug("BaseTest : setupBrowser : test object is set for function"+ name.getName());
		threadLocalTest.set(test);
	}

	@AfterMethod
	public void closeBrowser() {
		logger.debug("BaseTest : closeBrowser : Qutting browser..");
		threadLocalDriver.get().quit();
		threadLocalDriver.remove();
		logger.debug("BaseTest : closeBrowser : browser is quit and removed browser instance");
		
	}
	@BeforeSuite
	public static void setup() {
		report = ReportManager.getInstance();
		logger.debug("BaseTest : setup : initializing report manager..");

	}

	@AfterSuite
	public static void tearDown() {
		report.flush();
		
		logger.debug("BaseTest : tearDown : flushing the report");
	}

	public static WebDriver getBrowserDriver(String bName, boolean headless) {
		String browserName = bName.toLowerCase();
		WebDriver driver = null;
		switch (browserName) {
		case "chrome":
			if (headless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("Only supported drivers are chrome, safari, edge, firefox");
		}
		return driver;
	}

}
