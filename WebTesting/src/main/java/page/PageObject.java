package page;

import org.openqa.selenium.WebDriver;

public abstract class PageObject extends LinkCheckerUtils {
	WebDriver driver;
	
	public PageObject(WebDriver driver){
		this.driver = driver;
	};
	
	WebDriver getDriver(){
		return this.driver;
	}
}
