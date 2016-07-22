package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.Factory;
import page.MainPage;
import page.header.DropDownSuggestionSearch;

public class DropDownSearchTest {
	WebDriver driver;
	MainPage main;
	DropDownSuggestionSearch dropdownSuggestion;
	
	@BeforeClass
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		main = Factory.getPage(MainPage.class, driver);
		dropdownSuggestion = Factory.getPage(DropDownSuggestionSearch.class,driver);
	}
	
	@Test
	public void searchDorpDownTest(){
		main.launch();
		main.verfiySearchExist();
		main.getSearchBar().sendKeys("Hulk");
		dropdownSuggestion.selectDropDownSuggestion("The Incredible Hulk (1978)");
	}
	
	@AfterClass
	public void destroy(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		//driver.close();
	}
}
