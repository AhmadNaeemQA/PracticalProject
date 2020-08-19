package cukeTest.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationLogin {

	private WebDriver driver;
	private WebElement target;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/ahmadnaeem/Documents/Work/QA Consulting/PracticalProject/AutomatedTesting/src/test/resources/chromedriver");
		driver = new ChromeDriver();
	}

//	@After
//	public void close() {
//		driver.quit();
//	}

	@Given("^I am at http://localhost:(\\d+)/$")
	public void i_am_at_http_localhost(int arg1) throws Throwable {
		driver.get("http://127.0.0.1:5500/index.html");
		assertEquals("http://127.0.0.1:5500/index.html", driver.getCurrentUrl());
		// Write code here that turns the phrase above into concrete actions
	}

	@When("^I click on the register button$")
	public void i_click_on_the_register_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^I should be taken to the registration page$")
	public void i_should_be_taken_to_the_registration_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

}
