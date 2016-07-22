package page;

import org.openqa.selenium.WebDriver;

/**
 * To represent that an object is a Html Page 
 * @author yudan
 *
 */
public abstract class PageObject extends IMDBWebPage {
	WebDriver driver;
	
	public PageObject(WebDriver driver){
		this.driver = driver;
	};
	
	WebDriver getDriver(){
		return this.driver;
	}

}
