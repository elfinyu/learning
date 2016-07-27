package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.Factory;
import page.MainPage;
import page.movies.MovieDetailPage;
import page.searchresult.ResultPage;

public class SearchNameTest {
	WebDriver driver;
	MainPage main;
	ResultPage resultPage;
	MovieDetailPage movieDetailPage;
	
	@BeforeClass
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		main = Factory.getPage(MainPage.class, driver);
		resultPage = Factory.getPage(ResultPage.class, driver);
		movieDetailPage=Factory.getPage(MovieDetailPage.class, driver);
	}
	
	@Test
	public void searchNameResult(){
		main.launch();
		main.menuBar.verfiySearchExist();
		main.menuBar.searchTitle("Hulk");
		System.out.println("result rows: "+resultPage.getNameResultsControl().getNameResultsCount());
		System.out.println("result links: "+resultPage.getNameResultsControl().getNameResultsLinksCount());
		resultPage.getNameResultsControl().clickNameLink("Hulk Hogan (Actor, Rocky III (1982))");
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
