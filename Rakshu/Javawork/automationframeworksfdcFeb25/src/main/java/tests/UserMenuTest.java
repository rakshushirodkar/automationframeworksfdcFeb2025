package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listerns.TestListeners;
import pages.HomePage;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.FileUtils;
import utils.WaitUtils;

@Listeners(TestListeners.class)

public class UserMenuTest extends BaseTest{
	
	String uName ;
	String pass;
	@BeforeMethod()
	public void preConditions() throws FileNotFoundException, IOException {
		uName = FileUtils.readLoginPropertiesFile("valid.username");
		pass = FileUtils.readLoginPropertiesFile("valid.password");
	}
	
	@Test
	public void verifyMyProfile_TC06() throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		LoginPage lp  = new LoginPage(driver);
		HomePage hp  = lp.loginToApp(driver, uName, pass);
		WaitUtils.waitForElement(driver, hp.userMenu);
		hp.clickUserMenu();
		assertTrue(hp.verifyUserMenuOptions(), "user menu options should be verified");
		UserMenuPage ump = hp.navigateToMyProfilePage(driver);
		WaitUtils.waitForElement(driver, ump.profilePage);
		assertTrue(ump.profilePage.isDisplayed(), "Profile page should be displayed");
		ump.waitAndclickEditProfileIcon(driver);
		assertTrue(ump.verifyContactIframeAvailability(driver), "Contact iframe should be verified");
		assertTrue(ump.verifyAboutTab(driver), "About tab should be verified");
		assertTrue(ump.verifyLastNameChange(), "Last name should be changed");
		assertTrue(ump.verifyCreatePost(driver, "hello java"), "create post should be verified");
		assertTrue(ump.verifyFileUpload(driver), "file upload should be verified");
		ump.clickOnAddPhoto(driver);
		assertTrue(ump.verifyAddPhoto(driver), "add photo should be verified");
	}

	@Test(enabled = false)
	public void verifyMyProfile_TC07() {
		System.out.println("TC 07 executed");
	}

}
