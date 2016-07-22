package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.Factory;
import page.MainPage;
import page.header.ConsumerMainNavigation;

public class NavigationMenuTest {
	
	WebDriver driver;
	MainPage main;
	ConsumerMainNavigation consumerMainNav;
	
	@BeforeTest
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		main = Factory.getPage(MainPage.class, driver);
		consumerMainNav= Factory.getPage(ConsumerMainNavigation.class, driver);
	}
	
	@Test
	public void navigationTest(){
		main.launch();
		consumerMainNav.clickOnTitleMenuNav("TV");
	}
	
	@AfterTest
	public void destory(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
