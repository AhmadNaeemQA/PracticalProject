package cukeTest.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationLogin {

	private WebDriver driver;
	private WebElement target;
	private String username = ("user64316");
	
	@Before
	public void init() {
	System.setProperty("webdriver.chrome.driver",
			"/Users/ahmadnaeem/Documents/Work/QA Consulting/PracticalProject/ProjectJava/SpringBoot/resources/chromedriver");
	driver = new ChromeDriver();
	}
	
		
	@Given("^I am at http://localhost:(\\d+)/$")
	public void i_am_at_http_localhost(int arg1) throws Throwable {
		driver.get("http://127.0.0.1:5500/index.html");
		assertEquals("http://127.0.0.1:5500/index.html", driver.getCurrentUrl());
	}
	
	@When("^I click on the register button$")
	public void i_click_on_the_register_button() throws Throwable {
		target = driver.findElement(By.xpath("/html/body/div/center/div/button[2]"));
		target.click();
	}

	@Then("^I should be taken to the registration page$")
	public void i_should_be_taken_to_the_registration_page() throws Throwable {
	    assertEquals("http://127.0.0.1:5500/register.html" , driver.getCurrentUrl());
	}
	
	@Given("^I am on the registration page$")
	public void i_am_on_the_registration_page() throws Throwable {
		driver.get("http://127.0.0.1:5500/register.html");
	    assertEquals("http://127.0.0.1:5500/register.html" , driver.getCurrentUrl());
	}

	@When("^I fill in al the details correctly$")
	public void i_fill_in_al_the_details_correctly() throws Throwable {
		
	    target = driver.findElement(By.xpath("//*[@id=\"inputUsername\"]"));
	    target.sendKeys(username);
	    target = driver.findElement(By.xpath("//*[@id=\"inputPassword\"]"));
	    target.sendKeys("root");
	    target = driver.findElement(By.xpath("//*[@id=\"inputEmail\"]"));
	    target.sendKeys("auto@email.com");
	    target = driver.findElement(By.xpath("//*[@id=\"inputFirstName\"]"));
	    target.sendKeys("cukeFirstName");
	    target = driver.findElement(By.xpath("//*[@id=\"inputSurname\"]"));
	    target.sendKeys("cukeSirName");
	    target = driver.findElement(By.xpath("/html/body/div/center/div/button"));
	}

	@When("^I press submit$")
	public void i_press_submit() throws Throwable {
	    target.click();
	}

	@Then("^I am taken to my homepage$")
	public void i_am_taken_to_my_homepage() throws Throwable {
		Thread.sleep(3000);
		assertEquals("http://127.0.0.1:5500/homepage.html", driver.getCurrentUrl());
	}
	
	@Given("^I am on http://localhost:(\\d+)/$")
	public void i_am_on_http_localhost(int arg1) throws Throwable {
		driver.get("http://127.0.0.1:5500/index.html");
		assertEquals("http://127.0.0.1:5500/index.html", driver.getCurrentUrl());
	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
	    target = driver.findElement(By.xpath("/html/body/div/center/div/button[1]"));
	    target.click();
	}

	@Then("^I should be taken to the login page$")
	public void i_should_be_taken_to_the_login_page() throws Throwable {
	    assertEquals("http://127.0.0.1:5500/login.html", driver.getCurrentUrl());
	}

	@Given("^I am on the login page$")
	public void i_am_on_the_login_page() throws Throwable {
	    driver.get("http://127.0.0.1:5500/login.html");
	    assertEquals("http://127.0.0.1:5500/login.html", driver.getCurrentUrl());
	}

	@When("^I enter the details correctly$")
	public void i_enter_the_details_correctly() throws Throwable {
	    target = driver.findElement(By.xpath("//*[@id=\"inputUsername\"]"));
	    target.sendKeys(username);
	    target = driver.findElement(By.xpath("//*[@id=\"inputPassword\"]"));
	    target.sendKeys("root");
	}

	@When("^I press login$")
	public void i_press_login() throws Throwable {
	    target = driver.findElement(By.xpath("/html/body/div/center/div/button"));
	    target.click();
	}

	@Then("^I should be taken to my homepage$")
	public void i_should_be_taken_to_my_homepage() throws Throwable {
		Thread.sleep(3000);
		assertEquals("http://127.0.0.1:5500/homepage.html", driver.getCurrentUrl());
	}
	
	@After
	public void close() {
		driver.quit();
	}
}
