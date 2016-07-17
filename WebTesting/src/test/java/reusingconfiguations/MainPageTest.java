package reusingconfiguations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

import configuration.TestConfiguration;
import page.MainPage;

@Guice(modules = TestConfiguration.class)
public class MainPageTest {
	
	@Inject
	WebDriver driver;
	
	@Inject
	MainPage main;
	
	@Test
	public void test(){
		main.launch();
		main.verfiySearchExist();
		main.searchTitle("Hulk");
	}
	
	@Test
	public void test2(){
		main.launch();
		main.verfiySearchExist();
		main.searchTitle("Iron Man");
	}
	

}
