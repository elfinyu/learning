package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.Factory;
import page.LinkCheckerUtils;
import page.MainPage;

public class MainPageTest {
	
	WebDriver driver;
	MainPage main;
	
	@BeforeClass
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		main = Factory.getPage(MainPage.class, driver);
	}
	
	@Test
	public void test(){
		main.launch();
		main.verfiySearchExist();
		main.searchTitle("Hulk");
		String actual=main.getCurrentPageTitle();
		String expected="Find - IMDb";
		Assert.assertEquals(actual, expected);
		main.getSearchedResult();
		
		System.out.println(main.getCurrentPageTitle());
		//main.checkAllLinks();
		
		
		LinkCheckerUtils.checkAllLinks(main);
	}
	
//	@AfterClass
//	public void destroy(){
//		driver.quit();
//		//driver.close();
//	}

}