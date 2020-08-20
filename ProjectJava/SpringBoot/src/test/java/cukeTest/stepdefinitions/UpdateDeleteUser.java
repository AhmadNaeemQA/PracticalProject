package cukeTest.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UpdateDeleteUser {
	
	private WebDriver driver;
	private WebElement target;
	private String username = ("user64316");
	
	@Before
	public void init() {
	System.setProperty("webdriver.chrome.driver",
			"/Users/ahmadnaeem/Documents/Work/QA Consulting/PracticalProject/ProjectJava/SpringBoot/resources/chromedriver");
	driver = new ChromeDriver();
	}
	
	@Given("^you are on the main page two$")
	public void you_are_on_the_main_page_two() throws Throwable {
		driver.get("http://127.0.0.1:5500/login.html");
	    target = driver.findElement(By.xpath("//*[@id=\"inputUsername\"]"));
	    target.sendKeys(username);
	    target = driver.findElement(By.xpath("//*[@id=\"inputPassword\"]"));
	    target.sendKeys("root");
	    target = driver.findElement(By.xpath("/html/body/div/center/div/button"));
	    target.click();
	    Thread.sleep(3000);
	    assertEquals("http://127.0.0.1:5500/homepage.html", driver.getCurrentUrl());
	}
	
	@When("^you click on the update personal details button on navbar$")
	public void you_click_on_the_update_personal_details_button_on_navbar() throws Throwable {
		Thread.sleep(3000);
	    target = driver.findElement(By.xpath("/html/body/div/nav/a[3]"));
	    target.click();
	}

	@Then("^it should take you to the update personal details page$")
	public void it_should_take_you_to_the_update_personal_details_page() throws Throwable {
		Thread.sleep(10000);
		assertEquals("http://127.0.0.1:5500/updateUser.html", driver.getCurrentUrl());
	    
	}

	@Given("^you are on the update personal details page$")
	public void you_are_on_the_update_personal_details_page() throws Throwable {
	    driver.get("http://127.0.0.1:5500/login.html");
	    target = driver.findElement(By.xpath("//*[@id=\"inputUsername\"]"));
	    target.sendKeys(username);
	    target = driver.findElement(By.xpath("//*[@id=\"inputPassword\"]"));
	    target.sendKeys("root");
	    target = driver.findElement(By.xpath("/html/body/div/center/div/button"));
	    target.click();
	    Thread.sleep(2000);
	    assertEquals("http://127.0.0.1:5500/homepage.html", driver.getCurrentUrl());
	    target = driver.findElement(By.xpath("/html/body/div/nav/a[3]"));
	    target.click();
	    Thread.sleep(10000);
		assertEquals("http://127.0.0.1:5500/updateUser.html", driver.getCurrentUrl());
	}

	@When("^you enter your new details$")
	public void you_enter_your_new_details() throws Throwable {
	    target = driver.findElement(By.xpath("//*[@id=\"inputEmail\"]"));
	    target.sendKeys("NewEmail@email.com");
	    target = driver.findElement(By.xpath("//*[@id=\"inputFirstName\"]"));
	    target.sendKeys("NewFirstName");
	    target = driver.findElement(By.xpath("//*[@id=\"inputSurname\"]"));
	    target.sendKeys("NewSirName");
	}

	@When("^you click update$")
	public void you_click_update() throws Throwable {
	    target = driver.findElement(By.xpath("/html/body/div/center/div/button[1]"));
	    target.click();
	}

	@Then("^it should update you details$")
	public void it_should_update_you_details() throws Throwable {
		Thread.sleep(1000);
	    assertEquals("http://127.0.0.1:5500/homepage.html", driver.getCurrentUrl());
	}
	
	@When("^you click on the log out button on the navbar$")
	public void you_click_on_the_log_out_button_on_the_navbar() throws Throwable {
		Thread.sleep(3000);
	    driver.findElement(By.xpath("/html/body/div/nav/a[4]")).click();
	}

	@Then("^it should take you to the welcome page$")
	public void it_should_take_you_to_the_welcome_page() throws Throwable {
	    Thread.sleep(1000);
	    assertEquals("http://127.0.0.1:5500/index.html", driver.getCurrentUrl());
	}

	@When("^you click on delete account$")
	public void you_click_on_delete_account() throws Throwable {
	    driver.findElement(By.xpath("/html/body/div/center/div/button[2]")).click();
	}

	@Then("^it should delete your account and take you to the welcome page$")
	public void it_should_delet_your_account_and_take_you_to_the_welcome_page() throws Throwable {
	    Thread.sleep(1000);
	    assertEquals("http://127.0.0.1:5500/index.html", driver.getCurrentUrl());
	}
	
	@After
	public void close() {
		driver.quit();
	}
}
