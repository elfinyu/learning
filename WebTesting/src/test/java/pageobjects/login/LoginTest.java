package pageobjects.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.Factory;
import login.LoginPage;
import login.LoginSelectionPage;
import page.MainPage;
import page.header.NavigationHeader;
import page.movies.MovieDetaiQuickLinksBar;
import page.movies.MoviesDetailPage;
import page.searchresult.ResultPage;
import page.searchresult.TitleResultsPanel;

public class LoginTest {
	
	WebDriver driver;
	MainPage main;
	NavigationHeader header;
	LoginSelectionPage loginSelection;
	LoginPage loginPage;
	String username;
	String password;
	
	@BeforeClass
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		main = Factory.getPage(MainPage.class, driver);
		header = Factory.getPage(NavigationHeader.class, driver);
		loginSelection = Factory.getPage(LoginSelectionPage.class, driver);
		loginPage = Factory.getPage(LoginPage.class, driver);
		username = System.getProperty("username");
		System.out.println(username);
		password = System.getProperty("password");
		System.out.println(password);
	}
	
	@Test
	public void testLogin(){
	
		main.launch();
		header.clickLoginButton();
		loginSelection.clickIMDbLogin();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		loginPage.verifySuccessfullyLogin();
		
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
