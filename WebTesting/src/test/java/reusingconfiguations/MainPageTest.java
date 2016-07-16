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
		main.serachTitle("Hulk");
	}
	
	@Test
	public void test2(){
		main.launch();
		main.verfiySearchExist();
		main.serachTitle("Iron Man");
	}
	

}
