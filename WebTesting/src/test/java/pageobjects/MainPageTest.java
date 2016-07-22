package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.Factory;
import page.LinkCheckerUtils;
import page.MainPage;
import page.searchresult.ResultPage;

public class MainPageTest {
	
	WebDriver driver;
	MainPage main;
	ResultPage result;
	
	@BeforeClass
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		main = Factory.getPage(MainPage.class, driver);
		result = Factory.getPage(ResultPage.class, driver);
	}
	
	@Test
	public void test(){
		main.launch();
		main.verfiySearchExist();
//		System.out.println("Links in main page: "+LinkCheckerUtils.getAllLinksCount(main));
		
		main.searchTitle("Hulk");
//		String actual=main.getCurrentPageTitle();
//		String expected="Find - IMDb";
//		Assert.assertEquals(actual, expected);
		
//		System.out.println("Change page object to ResultPage");
//		result.getSearchedResult();
		System.out.println("Links in result page: "+LinkCheckerUtils.getAllLinksCount(result));
		LinkCheckerUtils.clickLink("Hulk", result);

	}
	
	@Test
	public void myTest(){
	
		main.launch();
		main.verfiySearchExist();
		main.searchTitle("Hulk");
		Assert.assertEquals(result.getTitleResultsCount("Hulk"), 10,"Should have 10 results");
		Assert.assertEquals(result.getTitleResultsCountOfLinks("Hulk"), 10,"Should have 10 results");
		Assert.assertEquals(result.getTitleResultsCountOfLinksUsingXpath("Hulk"), 10,"Should have 10 results");
		
	}
	
	@Test
	public void testLinkClicking(){
		main.launch();
		main.verfiySearchExist();
		main.searchTitle("Hulk");
		int x = result.getTitleResultsCountOfLinks("Hulk");
		System.out.println("Links(xpath:td) in result page: "+ x);
		x = result.getTitleResultsCountOfLinksUsingXpath("Hulk");
		System.out.println("Links(xpath:a) in result page: "+ x);
	}
	
	@AfterClass
	public void destroy(){
		driver.quit();
		//driver.close();
	}

}