package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
	
	String expected,actual;
	
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
		expected="IMDb Top 250 TV - IMDb";
		actual=main.getCurrentPageTitle();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void navigationPopPanelTest(){
		main.launch();
		
		consumerMainNav.getMoviesPopPanelControl().selectMoviesPanelLink("In Theaters");
		actual=main.getCurrentPageTitle();
		expected="New Movies In Theaters - IMDb";
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		
		consumerMainNav.getEventsPopPanelControl().selectEventsPanelLink("Celebrity News");
		actual=main.getCurrentPageTitle();
		expected="IMDb :: Celebrity News";
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		
		consumerMainNav.getNewsPopPanelControl().selectNewsPanelLink("Indie News");
		actual=main.getCurrentPageTitle();
		expected="IMDb :: Indie News";
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void navigationPopPanelWatchlistTest(){
		main.launch();
		consumerMainNav.getWatchlistPopPanelControl().selectWatchlistPanelLink("nv_wl_img_1");
		actual=main.getCurrentPageTitle();
		expected="Watchlist - IMDb";
		Assert.assertEquals(actual, expected);
		
		consumerMainNav.getWatchlistPopPanelControl().selectWatchlistPanelLink("nv_wl_img_2");
		actual=main.getCurrentPageTitle();
		expected="IMDb: Most Popular TV Series/Feature Films";
		Assert.assertEquals(actual, expected);
		
		consumerMainNav.getWatchlistPopPanelControl().selectWatchlistPanelLink("nv_wl_img_3");
		actual=main.getCurrentPageTitle();
		expected="IMDb Top 250 - IMDb";
		Assert.assertEquals(actual, expected);	
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
