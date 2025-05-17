package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.poi.hpsf.Array;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import listerns.TestListeners;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.FileUtils;
import utils.WaitUtils;

@Listeners(TestListeners.class)

public class LoginTest extends BaseTest {
	

	@Test(dataProvider = "LoginData")
	public void loginErrorMsg_TC01(Method name, String uname, String pass) throws InterruptedException, FileNotFoundException, IOException {
		ExtentTest test2 = threadLocalTest.get();
		SoftAssert sa = new SoftAssert();
		WebDriver driver = BaseTest.getBrowser();
		LoginPage lp = new LoginPage(driver);
		driver.get("https://login.salesforce.com");
		logger.debug("BaseTest : loginErrorMsg_TC01 : Launched sfdc application ");
		test2.log(Status.INFO, "chrome browser launched with sfdc app");
		lp.username.sendKeys(uname);
		System.out.println(uname);
		System.out.println(pass);
		logger.debug("BaseTest : loginErrorMsg_TC01 : Launched sfdc application ");
		lp.loginButton.click();
		logger.debug("BaseTest : loginErrorMsg_TC01 : Launched sfdc application ");
		test2.log(Status.INFO, "login button clicked");
		WaitUtils.waitForElement(driver, lp.errorMsg);
		logger.debug("BaseTest : loginErrorMsg_TC01 :fetched error message"+" ");
		sa.assertTrue(lp.verifyLoginErrorMessage(driver), "Error message should be validated");
		logger.debug("BaseTest : loginErrorMsg_TC01 : login error msg validated ");
		sa.assertAll();
		try {
			
		} catch(Exception e) {
			logger.error("BaseTest : loginErrorMsg_TC01 : login error msg validated "+e.getMessage());
		}
		
	}
	
	@Test(priority = 1)
	public void rememberMe_TC02(Method name) throws InterruptedException {
		ExtentTest test2 = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get("https://login.salesforce.com");
		LoginPage lp = new LoginPage(driver);
		HomePage hp = lp.loginToApp(driver, "jul22.mithun@ta.com", "Mac@1234");
		WaitUtils.waitForElement(driver, hp.userMenu);
		lp = hp.logoutFromApp(driver);
		WaitUtils.waitForElement(driver, lp.password);
		String actualUsername = lp.getSavedUsername();
	}
	
	
	@DataProvider(name = "LoginCredentials")
	public Object[][] loginCreds() {
		// read data file
		
		return new Object[][] {{"mithun.r@tekarch.com","Mithun123"}, 
			{"deek.r@tekarch.com","deek123"}};
	}
	
	@DataProvider(name = "LoginData")
	public Object[][] loginCreds2() {
		// read data file
		
		return new Object[][] {{"mithun.r@tekarch.com","Mithun123"}, 
			{"deek.r@tekarch.com","deek123"}};
	}

}
