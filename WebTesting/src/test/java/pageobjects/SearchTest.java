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
import page.movies.MovieDetailTitleBar;
import page.movies.MoviesDetailPage;
import page.searchresult.ResultPage;
import page.searchresult.TitleResultsPanel;

public class SearchTest {
	
	WebDriver driver;
	MainPage main;
	ResultPage resultPage;
	//TitleResultsPanel titleResults;
	MoviesDetailPage moviesDetailPage;
	//MovieDetailTitleBar titleBar;
	
	@BeforeClass
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		main = Factory.getPage(MainPage.class, driver);
		resultPage = Factory.getPage(ResultPage.class, driver);
		//titleResults = Factory.getPage(TitleResultsPanel.class, driver);
		moviesDetailPage=Factory.getPage(MoviesDetailPage.class, driver);
		//titleBar=Factory.getPage(MovieDetailTitleBar.class, driver);
	}
	

	
	@Test
	public void searchTitleResult(){
		main.launch();
		main.verfiySearchExist();
		main.searchTitle("Hulk");
		resultPage.titleResults.clickTitleLink("Hulk (2003)");
		Assert.assertEquals(moviesDetailPage.titleBar.getMovieTitle(),"Hulk (2003)");
		Assert.assertEquals(moviesDetailPage.titleBar.getMovieDuration(), "2h 18min");
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