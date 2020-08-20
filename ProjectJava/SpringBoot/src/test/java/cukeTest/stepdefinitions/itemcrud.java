package cukeTest.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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

public class itemcrud {
	
	private WebDriver driver;
	private WebElement target;
	private String username = ("user64316");
	
	@Before
	public void init() {
	System.setProperty("webdriver.chrome.driver",
			"/Users/ahmadnaeem/Documents/Work/QA Consulting/PracticalProject/ProjectJava/SpringBoot/resources/chromedriver");
	driver = new ChromeDriver();
	}
	
	@Given("^I am on the homepage$")
	public void i_am_on_the_homepage() throws Throwable {
	    driver.get("http://127.0.0.1:5500/login.html");
	    target = driver.findElement(By.xpath("//*[@id=\"inputUsername\"]"));
	    target.sendKeys(username);
	    target = driver.findElement(By.xpath("//*[@id=\"inputPassword\"]"));
	    target.sendKeys("root");
	    target = driver.findElement(By.xpath("/html/body/div/center/div/button"));
	    target.click();
	    Thread.sleep(2000);
	    assertEquals("http://127.0.0.1:5500/homepage.html", driver.getCurrentUrl());
	}

	@When("^I click on the add a task button on the navbar$")
	public void i_click_on_the_add_a_task_button_on_the_navbar() throws Throwable {
	    target = driver.findElement(By.xpath("/html/body/div/nav/a[2]"));
	    target.click();
	}

	@Then("^I should be taken to the add task page$")
	public void i_should_be_taken_tot_the_add_task_page() throws Throwable {
	    assertEquals("http://127.0.0.1:5500/addTask.html", driver.getCurrentUrl());
	}

	@Given("^I am on the add task page$")
	public void i_am_on_the_add_task_page() throws Throwable {
	    driver.get("http://127.0.0.1:5500/login.html");
	    target = driver.findElement(By.xpath("//*[@id=\"inputUsername\"]"));
	    target.sendKeys(username);
	    target = driver.findElement(By.xpath("//*[@id=\"inputPassword\"]"));
	    target.sendKeys("root");
	    target = driver.findElement(By.xpath("/html/body/div/center/div/button"));
	    target.click();
	    Thread.sleep(3000);
	    target = driver.findElement(By.xpath("/html/body/div/nav/a[2]"));
	    target.click();
	    assertEquals("http://127.0.0.1:5500/addTask.html", driver.getCurrentUrl());
	}

	@When("^I enter the information for a new task$")
	public void i_enter_the_information_for_a_new_task() throws Throwable {
	    target = driver.findElement(By.xpath("//*[@id=\"inputTitle\"]"));
	    target.sendKeys("New Title");
	    target = driver.findElement(By.xpath("//*[@id=\"inputDescription\"]"));
	    target.sendKeys("New Description");
	    target = driver.findElement(By.xpath("//*[@id=\"inputDueDate\"]"));
	    target.sendKeys("01/12/2021");
	}

	@When("^press register$")
	public void press_register() throws Throwable {
	    target = driver.findElement(By.xpath("/html/body/div/center/div/div[3]/div[2]/button"));
	    target.click();
	}

	@Then("^the task should be created$")
	public void the_task_should_be_created() throws Throwable {
		Thread.sleep(3000);
		assertEquals("http://127.0.0.1:5500/homepage.html", driver.getCurrentUrl());
	}

	@Given("^I am on the mainpage$")
	public void i_am_on_the_mainpage() throws Throwable {
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

	@Then("^I should be able to see tasks on the screen$")
	public void i_should_be_able_to_see_tasks_on_the_screen() throws Throwable {
		target = driver.findElement(By.xpath("//*[@id=\"todos\"]/p[1]"));
		assertNotNull(target.getText());
	}

	@Given("^there is a task thats currently incomplete$")
	public void there_is_a_task_thats_currently_incomplete() throws Throwable {
		driver.get("http://127.0.0.1:5500/login.html");
	    target = driver.findElement(By.xpath("//*[@id=\"inputUsername\"]"));
	    target.sendKeys(username);
	    target = driver.findElement(By.xpath("//*[@id=\"inputPassword\"]"));
	    target.sendKeys("root");
	    target = driver.findElement(By.xpath("/html/body/div/center/div/button"));
	    target.click();
	    Thread.sleep(3000);
	    assertEquals("http://127.0.0.1:5500/homepage.html", driver.getCurrentUrl());
	    target = driver.findElement(By.xpath("//*[@id=\"todos\"]/p"));
	    System.out.println(target.getText());
	    System.out.println(target.toString());
	    assertTrue(target.getText().contains("Completed: false"));
	}

	@When("^I type the item ID in the text box$")
	public void i_type_the_item_ID_in_the_text_box() throws Throwable {
		target = driver.findElement(By.xpath("//*[@id=\"todos\"]/p"));
		String result = target.getText();
		int index_of_id = result.indexOf("ID") + 4;
		String id = result.substring(index_of_id, index_of_id+2);
		target = driver.findElement(By.xpath("//*[@id=\"input1\"]"));
		target.sendKeys(id);
	}

	@When("^press Mark Task as Complete$")
	public void press_Mark_Task_as_Complete() throws Throwable {
	    target = driver.findElement(By.xpath("/html/body/div/center/button[3]"));
	    target.click();
	}

	@Then("^the task should be marked as complete$")
	public void the_task_should_be_marked_as_complete() throws Throwable {
		Thread.sleep(3000);
		assertEquals("http://127.0.0.1:5500/homepage2.html", driver.getCurrentUrl());
		target = driver.findElement(By.xpath("/html/body/div/center/button[1]"));
		target.click();
		Thread.sleep(1000);
		target = driver.findElement(By.xpath("//*[@id=\"todos\"]/p"));
		assertTrue(target.getText().contains("Completed: true"));
	}

	@Given("^you are on the main page$")
	public void you_are_on_the_main_page() throws Throwable {
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

	@When("^you click on show incomplete tasks$")
	public void you_click_on_show_incomplete_tasks() throws Throwable {
	    target = driver.findElement(By.xpath("/html/body/div/center/button[2]"));
	    target.click();
	}

	@Then("^there should be no tasks showing$")
	public void there_should_be_no_tasks_showing() throws Throwable {
		target = driver.findElement(By.xpath("//*[@id=\"todos\"]"));
	    assertEquals("", target.getText());
	}

	
	
	@When("^you type in the item ID in the input box$")
	public void you_type_in_the_item_ID_in_the_input_box() throws Throwable {
		Thread.sleep(3000);
		target = driver.findElement(By.xpath("//*[@id=\"todos\"]/p"));
		String result = target.getText();
		int index_of_id = result.indexOf("ID") + 4;
		String id = result.substring(index_of_id, index_of_id+2);
		target = driver.findElement(By.xpath("//*[@id=\"input1\"]"));
		target.sendKeys(id);
	}

	@When("^you click on delete a task$")
	public void you_click_on_delete_a_task() throws Throwable {
	    target = driver.findElement(By.xpath("/html/body/div/center/button[4]"));
	    target.click();
	}

	@Then("^the task should be deleted$")
	public void the_task_should_be_deleted() throws Throwable {
		Thread.sleep(1000);
		target = driver.findElement(By.xpath("//*[@id=\"todos\"]"));
	    assertEquals("", target.getText());
	}
	
	@After
	public void close() {
		driver.quit();
	}
}
