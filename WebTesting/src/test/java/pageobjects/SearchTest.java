package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.Factory;
import core.RetryFailure;
import page.MainPage;
import page.movies.MovieDetailPage;
import page.searchresult.ResultPage;

public class SearchTest {
	
	WebDriver driver;
	MainPage main;
	ResultPage resultPage;
	//TitleResultsPanel titleResults;
	MovieDetailPage movieDetailPage;
	//MovieDetailTitleBar titleBar;
	
	@BeforeClass
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		main = Factory.getPage(MainPage.class, driver);
		resultPage = Factory.getPage(ResultPage.class, driver);
		//titleResults = Factory.getPage(TitleResultsPanel.class, driver);
		movieDetailPage=Factory.getPage(MovieDetailPage.class, driver);
		//titleBar=Factory.getPage(MovieDetailTitleBar.class, driver);
	}
	

	
	@Test(retryAnalyzer=RetryFailure.class)
	public void searchTitleResult(){
		main.launch();
		main.menuBar.verfiySearchExist();
		main.menuBar.searchTitle("Hulk");
		resultPage.getTitleResultsControl().clickTitleLink("Hulk (2003)");
		Assert.assertEquals(movieDetailPage.getTitleBarControl().getMovieTitle(),"Hulk (2003)");
		Assert.assertEquals(movieDetailPage.getTitleBarControl().getMovieDuration(), "2h 18min");
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