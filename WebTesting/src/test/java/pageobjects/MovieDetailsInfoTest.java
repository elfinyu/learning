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
import core.RetryFailure;
import data.DataManagement;
import data.Movie;
import data.MoviePresentation;
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
	}

	@Test(retryAnalyzer=RetryFailure.class)
	public void movieDetailInfoTest(){
		Movie movie = DataManagement.getInstance().getMovieByID(1);
		MoviePresentation presentation = new MoviePresentation(movie);
		main.launch();
		main.menuBar.verfiySearchExist();
		main.menuBar.searchTitle("Hulk");
		resultPage.getTitleResultsControl().clickTitleLink("Hulk (2003)");	
		int x = movieDetailPage.getMovieDetailSummaryControl().getUsersReviewsCount();
		int y = movieDetailPage.getMovieDetailSummaryControl().getCriticReviewsCount();
		Assert.assertEquals(movieDetailPage.getTitleBarControl().getMovieTitle(),presentation.getTitle());
		Assert.assertEquals(movieDetailPage.getTitleBarControl().getMovieDuration(), presentation.getDurationHMins());	
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
