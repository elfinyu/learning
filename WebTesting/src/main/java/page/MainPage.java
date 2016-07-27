package page;

import org.openqa.selenium.WebDriver;


public class MainPage extends IMDBPage {
	
	public MainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void launch(){
		getDriver().get("http://www.imdb.com/");
	}
	
	
	
	public String getCurrentPageTitle(){
		String currTitle = getDriver().getTitle();
		return currTitle;
	}
		
}
