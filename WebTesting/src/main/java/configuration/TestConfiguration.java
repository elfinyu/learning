package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.inject.Binder;
import com.google.inject.Module;

import core.Factory;
import page.MainPage;

public class TestConfiguration implements Module{

	

	@Override
	public void configure(Binder bind) {
		WebDriver driver = createChromeDriver();
		bind.bind(WebDriver.class).toInstance(driver);
		bind.bind(MainPage.class).toInstance(Factory.getPage(MainPage.class, driver));
		
	}
	
	private WebDriver createChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		return new ChromeDriver();
	}
	

}
