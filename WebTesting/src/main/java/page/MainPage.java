package page;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends PageObject {
	
	public MainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="navbar-query")
	WebElement searchBar;
	public WebElement getSearchBar() {
		return searchBar;
	}

	public void setSearchBar(WebElement searchBar) {
		this.searchBar = searchBar;
	}

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
