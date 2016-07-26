package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AlertTest {
	
	WebDriver driver;
	
	@Test
	public void testAlert(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.sendKeys("Hello");
		driver.switchTo().defaultContent();
	}

}
