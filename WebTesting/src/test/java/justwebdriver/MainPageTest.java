package justwebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPageTest {
	
	WebDriver driver;
	
	
	@BeforeClass
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void test(){
//		navbar-query
		driver.get("http://www.imdb.com/");
		WebElement element = driver.findElement(By.id("navbar-query"));
		if(!element.isDisplayed()) throw new ElementNotVisibleException("as");
		element.sendKeys("HULK");
		element.submit();
		
	}
	
	@AfterClass
	public void destroy(){
		driver.quit();
	}

}