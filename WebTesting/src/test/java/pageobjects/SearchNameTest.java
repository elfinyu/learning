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
import page.movies.MoviesDetailPage;
import page.search.ResultPage;

public class SearchNameTest {
	WebDriver driver;
	MainPage main;
	ResultPage resultPage;
	MoviesDetailPage moviesDetailPage;
	
	@BeforeClass
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		main = Factory.getPage(MainPage.class, driver);
		resultPage = Factory.getPage(ResultPage.class, driver);
		moviesDetailPage=Factory.getPage(MoviesDetailPage.class, driver);
	}
	
	@Test
	public void searchNameResult(){
		main.launch();
		main.verfiySearchExist();
		main.searchTitle("Hulk");
		System.out.println("result rows: "+resultPage.nameResults.getNameResultsCount());
		System.out.println("result links: "+resultPage.nameResults.getNameResultsLinksCount());
		resultPage.nameResults.clickNameLink("Hulk Hogan (Actor, Rocky III (1982))");
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
