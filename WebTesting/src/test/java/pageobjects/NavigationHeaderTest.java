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
	
	
	@BeforeClass
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		main = Factory.getPage(MainPage.class, driver);
	}
	
	@Test
	public void menuBarTest(){
		main.launch();
		NavigationHeader menuBar = main.menuBar;
		menuBar.verfiySearchExist();
		menuBar.getQuickSearchDropDownList().selectDropdownList("TV Episodes");
		menuBar.getSearchBar().sendKeys("Hulk");
		menuBar.getNavigationDropdownSearch().selectDropDownSuggestion("The Incredible Hulk (1978)");
		
		menuBar.getConsumerMainNav().clickOnTitleMenuNav("showtimes");
		Assert.assertEquals(menuBar.getCurrentPageTitle(), "Showtimes and Cinemas for - IMDb");
		
		menuBar.getConsumerMainNav().clickOnNameMenuNav("events");
		Assert.assertEquals(menuBar.getCurrentPageTitle(), "Awards Central | Academy Awards, Globes & more - IMDb");
		
		menuBar.getConsumerMainNav().clickOnNewsMenuNav("news");
		Assert.assertEquals(menuBar.getCurrentPageTitle(), "IMDb :: Top News");
		
		menuBar.getConsumerMainNav().clickOnWatchListNav("watchlist");
		Assert.assertEquals(menuBar.getCurrentPageTitle(), "Watchlist - IMDb");
		
		menuBar.clickFollowFacebook();
		menuBar.clickFollowInstagram();
		menuBar.clickFollowTwitter();
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
