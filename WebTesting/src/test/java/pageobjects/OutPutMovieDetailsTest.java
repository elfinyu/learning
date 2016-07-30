package pageobjects;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.Factory;
import core.RetryFailure;
import page.MainPage;
import page.movies.MovieDetailPage;
import page.movies.MovieDetailSummaryBox;
import page.searchresult.ResultPage;

public class OutPutMovieDetailsTest {
	
	WebDriver driver;
	MainPage main;
	ResultPage resultPage;
	MovieDetailPage movieDetailPage;
	static PrintWriter out;
	String strFile;
	
	MovieDetailSummaryBox movieDetailSummary;
	@BeforeTest
	public void init() throws IOException{
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		main = Factory.getPage(MainPage.class, driver);
		resultPage = Factory.getPage(ResultPage.class, driver);
		movieDetailPage = Factory.getPage(MovieDetailPage.class, driver);	
		strFile="moviesDetails.csv";
		out = new PrintWriter(new FileWriter(strFile,true));
	}

	@Test(retryAnalyzer=RetryFailure.class)
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
		//out.write(strContent);
		//out.println(strContent);
	}

	@Test(retryAnalyzer=RetryFailure.class)
	public void getListOfResultsTest(){
		main.launch();
		main.menuBar.verfiySearchExist();
		main.menuBar.searchTitle("Hulk");
		List<WebElement> listOfResult = resultPage.getTitleResultsControl().getListOfResults();
		System.out.println("size: " + listOfResult.size());
		int i=0;
		int max=listOfResult.size();
		while(i<max){
			listOfResult = resultPage.getTitleResultsControl().getListOfResults();
			listOfResult.get(i).click();
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
			//writeToFile(strContent);
			//out.write(strContent);
			out.println(strContent);
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			i++;
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
		out.flush();
		out.close();
	}
}
