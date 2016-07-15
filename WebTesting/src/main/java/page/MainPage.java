package page;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends PageObject{

	public MainPage(WebDriver driver) {
		super(driver);
		
	}



	@FindBy(id="navbar-query")
	WebElement searchBar;
	
	
	
	public void launch(){
		getDriver().get("http://www.imdb.com/");
	}
	
	public void verfiySearchExist(){
		if(!searchBar.isDisplayed()) throw new ElementNotVisibleException("as");
	}
	
	public void serachTitle(String value){
		searchBar.sendKeys(value);
		searchBar.submit();
		
	}

}
