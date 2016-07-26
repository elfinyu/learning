package pageobjects;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.Factory;
import page.MainPage;
import page.movies.MovieDetailSummaryBox;
import page.searchresult.ResultPage;
import page.searchresult.TitleResultsPanel;
import page.movies.MovieDetailPage;

public class MovieDetailsInfoTest {
	
	WebDriver driver;
	MainPage main;
	ResultPage resultPage;
	MovieDetailPage movieDetailPage;
	static PrintStream out;
	
	MovieDetailSummaryBox movieDetailSummary;
	@BeforeTest
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		main = Factory.getPage(MainPage.class, driver);
		resultPage = Factory.getPage(ResultPage.class, driver);
		movieDetailPage = Factory.getPage(MovieDetailPage.class, driver);
//		
//		main = Factory.getPage(MainPage.class, driver);
//		resultPage = Factory.getPage(ResultPage.class, driver);
//		movieDetailPage = Factory.getPage(MovieDetailPage.class, driver);		
	}

	@Test
	public void movieDetailInfoTest(){
		main.launch();
		main.verfiySearchExist();
		main.searchTitle("Hulk");
		resultPage.getTitleResultsControl().clickTitleLink("Hulk (2003)");	
		int x = movieDetailPage.getMovieDetailSummaryControl().getUsersReviewsCount();
		int y = movieDetailPage.getMovieDetailSummaryControl().getCriticReviewsCount();
		Assert.assertEquals(movieDetailPage.getTitleBarControl().getMovieTitle(),"Hulk (2003)");
		Assert.assertEquals(movieDetailPage.getTitleBarControl().getMovieDuration(), "2h 18min");	
		Assert.assertEquals(x, 1444);
		Assert.assertEquals(y, 267);
	}
	
	@AfterTest
	public void tearDown(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver!=null){
			driver.quit();
		}
	}
}
