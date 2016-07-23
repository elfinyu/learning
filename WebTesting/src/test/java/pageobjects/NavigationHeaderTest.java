package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import core.Factory;
import page.MainPage;
import page.header.NavigationHeader;

public class NavigationHeaderTest {
	WebDriver driver;
	MainPage main;
	//DropDownSuggestionSearch dropdownSuggestion;
	NavigationHeader navigationHeader;
	
	@BeforeClass
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		main = Factory.getPage(MainPage.class, driver);
		navigationHeader = Factory.getPage(NavigationHeader.class,driver);
	}
	
	@Test
	public void navigationHeaderTest(){
		main.launch();
		main.verfiySearchExist();
		navigationHeader.getQuickSearchDropDownList().selectDropdownList("TV Episodes");
		navigationHeader.getSearchBar().sendKeys("Hulk");
		navigationHeader.getNavigationDropdownSearch().selectDropDownSuggestion("The Incredible Hulk (1978)");
		
		navigationHeader.getConsumerMainNav().clickOnTitleMenuNav("showtimes");
		Assert.assertEquals(navigationHeader.getCurrentPageTitle(), "Showtimes and Cinemas for - IMDb");
		
		navigationHeader.getConsumerMainNav().clickOnNameMenuNav("events");
		Assert.assertEquals(navigationHeader.getCurrentPageTitle(), "Awards Central | Academy Awards, Globes & more - IMDb");
		
		navigationHeader.getConsumerMainNav().clickOnNewsMenuNav("news");
		Assert.assertEquals(navigationHeader.getCurrentPageTitle(), "IMDb :: Top News");
		
		navigationHeader.getConsumerMainNav().clickOnWatchListNav("watchlist");
		Assert.assertEquals(navigationHeader.getCurrentPageTitle(), "Watchlist - IMDb");
		
		navigationHeader.clickFollowFacebook();
		navigationHeader.clickFollowInstagram();
		navigationHeader.clickFollowTwitter();
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
