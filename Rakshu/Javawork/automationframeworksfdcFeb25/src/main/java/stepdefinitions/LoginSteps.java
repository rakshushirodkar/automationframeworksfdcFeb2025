package stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import tests.BaseTest;

public class LoginSteps {
	
	@Before(value = "@sanity")
	public void setup() {
		System.out.println("Setting up ... ");
	}
	
	@After(value = "@sanity")
	public void teardown() {
		System.out.println("tearing down ... ");
	}
	

	WebDriver driver = null;
	LoginPage lp = null;
	HomePage hp = null;

	@Given("User is on login page")
	public void user_is_on_login_page() {
		driver = BaseTest.getBrowserDriver("chrome", false);
		driver.get("https://login.salesforce.com");
		lp = new LoginPage(driver);
	}

	@When("User enters valid username as {string}")
	public void user_enters_valid_username(String username) {
		lp.enterUsername(username);
	}

	@When("User enters valid password as {string}")
	public void user_enters_valid_password(String pass) {
		lp.enterPassword(pass);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		lp.clickLogin();
	}

	@Then("User should land on home page")
	public void user_should_land_on_home_page() {
		hp = new HomePage(driver);
		assertTrue(hp.verifyHomePage(), "Home page should be visible");
	}

	@When("User enters in-valid id {string}")
	public void user_enters_in_valid_username(String username) {
		lp.enterUsername(username);
	}

	@When("User enters in-valid {string}")
	public void user_enters_in_valid_password(String pass) {
		lp.enterPassword(pass);
	}

	@Then("User should see a error message")
	public void user_should_see_a_error_message() throws FileNotFoundException, IOException {
		assertTrue(lp.verifyLoginErrorMessage(driver), "Login error message should be shown");
	}
	
	@Given("User takes test")
	public void user_takes_test() {
	
	}

	@When("User evaluation is done")
	public void user_evaluation_is_done() {
	  
	}

	@Then("User result is published")
	public void user_result_is_published(DataTable dataTable) {
		
		
		List<String> al = dataTable.asList();
		
		for(String s: al) {
			System.out.println(s);
		}
		
		
	}

}
