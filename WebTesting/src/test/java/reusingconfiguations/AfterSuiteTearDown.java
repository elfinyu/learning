package reusingconfiguations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Guice;

import com.google.inject.Inject;

import configuration.TestConfiguration;

@Guice(modules = TestConfiguration.class)
public class AfterSuiteTearDown {

	@Inject
	WebDriver driver;
	
	@AfterSuite
	public void destroy(){
		driver.quit();
	}
}
