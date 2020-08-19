package cukeTest;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.demo.Application;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", glue={"cukeTest/stepdefinitions"})
@SpringBootTest
@ContextConfiguration(classes = Application.class)
public class TestRunner {
	
}
