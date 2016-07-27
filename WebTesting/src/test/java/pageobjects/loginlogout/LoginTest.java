package pageobjects.loginlogout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.Factory;
import page.MainPage;
import page.header.NavigationHeader;
import page.login.LoginPage;
import page.login.LoginSelectionPage;
import page.userprofilemenu.ProfileMenu;

public class LoginTest {
	
	WebDriver driver;
	MainPage main;
	
	LoginSelectionPage loginSelection;
	LoginPage loginPage;
	String username;
	String password;
	ProfileMenu profilemenu;
	
	@BeforeClass
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		main = Factory.getPage(MainPage.class, driver);
		
		loginSelection = Factory.getPage(LoginSelectionPage.class, driver);
		loginPage = Factory.getPage(LoginPage.class, driver);
		username = System.getProperty("username");
		System.out.println(username);
		password = System.getProperty("password");
		System.out.println(password);
		profilemenu= Factory.getPage(ProfileMenu.class, driver);
	}
	
	@Test(description="")
	public void testLogin(){
	
		main.launch();
		main.menuBar.clickLoginButton();
		loginSelection.clickIMDbLogin();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		loginPage.verifySuccessfullyLogin();
		profilemenu.getLogoutControl().logout();
		
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
