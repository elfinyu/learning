package page;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import core.Factory;
import page.MainPage;

public class MainPageTest {
	
	static WebDriver driver;
	static MainPage main;
	
	@BeforeClass
	public static void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		main = Factory.getPage(MainPage.class, driver);
	}
	
	@Test
	public void test(){
		main.launch();
		main.verfiySearchExist();
		main.serachTitle("Hulk");
	}
	
	@AfterClass
	public static void destroy(){
		driver.quit();
	}

}
