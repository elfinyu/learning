package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.DriverFactory;
import core.RetryFailure;

public class AlertTest {
	
	WebDriver driver;
	WebElement button;
	
	@BeforeTest
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver = DriverFactory.INSTANCE.createDriver();
	}
	
	@Test(retryAnalyzer=RetryFailure.class)
	public void testAlert(){
		driver.get("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		//button=driver.findElement(By.xpath("//button[contains(text(),'Edit & Run »')]"));
		button=driver.findElement(By.xpath("//body[@contenteditable='false']//button[contains(text(),'Try it')]"));
		//button.click();
//		button=driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
		System.out.println(button.getText());
//		button.click();
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		alert.dismiss();
//		alert.sendKeys("Hello");
//		driver.switchTo().defaultContent();
	}
	@Test(retryAnalyzer=RetryFailure.class)
	public void testChrome() throws Throwable {
		//WebDriver driver= null;
		try{
			//driver = initChrome();
			driver.get("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
			WebElement frame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
			highlightElement(driver,frame);
			driver.switchTo().frame(frame);
			WebElement button=driver.findElement(By.xpath("//body[@contenteditable='false']//button[contains(text(),'Try it')]"));
			highlightElement(driver,button);
			button.click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}catch(Throwable e){
			e.printStackTrace();
		}finally {
			Thread.sleep(5000);
			driver.quit();
		}
	}
	public void highlightElement(WebDriver driver, WebElement element) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid yellow;");
		try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}	
	
	@AfterTest
	public void tearDown() throws InterruptedException{
		Thread.sleep(5000);
		if(driver!=null){
			driver.quit();
		}
	}

}
