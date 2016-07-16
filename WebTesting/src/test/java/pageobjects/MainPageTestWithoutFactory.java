package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.Factory;
import page.MainPage;

public class MainPageTestWithoutFactory {
	
	WebDriver driver;
	MainPage main;
	
	@BeforeClass
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		main = new MainPage(driver);
	}
	
	@Test
	public void test(){
		main.launch();
		main.verfiySearchExist();
		main.serachTitle("Hulk");
	}
	
	@AfterClass
	public  void destroy(){
		driver.quit();
	}

}