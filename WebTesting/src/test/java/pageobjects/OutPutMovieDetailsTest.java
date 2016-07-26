package pageobjects;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.Factory;
import page.MainPage;
import page.movies.MovieDetailPage;
import page.movies.MovieDetailSummaryBox;
import page.searchresult.ResultPage;

public class OutPutMovieDetailsTest {
	
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

	@Test
	public void movieDetailInfoTest(){
		main.launch();
		main.menuBar.verfiySearchExist();
		main.menuBar.searchTitle("Hulk");
		resultPage.getTitleResultsControl().clickTitleLink("Hulk (2003)");	
		
		String strTitle=movieDetailPage.getTitleBarControl().getMovieTitle();
		String strContentRate=movieDetailPage.getTitleBarControl().getMovieContentRating();
		String strDuration=movieDetailPage.getTitleBarControl().getMovieDuration();
		String strMovieCategory=movieDetailPage.getTitleBarControl().getMovieType();
		String strReleaseYear=movieDetailPage.getTitleBarControl().getMovieReleaseDate();
		int intUserReviewsCnt = movieDetailPage.getMovieDetailSummaryControl().getUsersReviewsCount();
		int intCriticReviewsCnt = movieDetailPage.getMovieDetailSummaryControl().getCriticReviewsCount();
		String strPopularityTrend=movieDetailPage.getMovieDetailSummaryControl().getPopularityTrend();
		
		String strContent = strTitle+","+strContentRate+","+strDuration+","+strMovieCategory+","
		+strReleaseYear+","+intUserReviewsCnt+","+intCriticReviewsCnt+","+strPopularityTrend;
		writeToFile(strContent);
	}
	
	public void writeToFile(String xx){
		try {
			out = new PrintStream("moviesDetails.csv");
			out.println(xx);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
