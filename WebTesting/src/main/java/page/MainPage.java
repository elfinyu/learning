package page;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends PageObject {
	
	public DropDownSuggestionSearch dropdownSuggestion;
	public MainPage(WebDriver driver) {
		super(driver);
		dropdownSuggestion = new DropDownSuggestionSearch(driver);
		PageFactory.initElements(driver,dropdownSuggestion);		
	}

	@FindBy(id="navbar-query")
	public WebElement searchBar;
	@FindBy(id="navbar-submit-button")
	WebElement submitButton;

	
	@FindBy(xpath="(//*[@class='result_text']/a)[1]")
    WebElement link;
	
	public void launch(){
		getDriver().get("http://www.imdb.com/");
	}
	
	public void verfiySearchExist(){
		if(!searchBar.isDisplayed()) throw new ElementNotVisibleException("as");
	}
	
	public void searchTitle(String value){
		searchBar.sendKeys(value);
		//submitButton.click();
		searchBar.submit();	
	}
	
	public String getCurrentPageTitle(){
		String currTitle = getDriver().getTitle();
		return currTitle;
	}
		
}
