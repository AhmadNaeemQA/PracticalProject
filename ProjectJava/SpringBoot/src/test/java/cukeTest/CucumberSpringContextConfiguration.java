package cukeTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.demo.Application;

import cucumber.api.java.Before;

@SpringBootTest
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {
	private static final Logger LOG = LoggerFactory.getLogger(CucumberSpringContextConfiguration.class);

	  /**
	   * Need this method so the cucumber will recognize this class as glue and load spring context configuration
	   */
	  @Before
	  public void setUp() {
	    LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
	  }
}
