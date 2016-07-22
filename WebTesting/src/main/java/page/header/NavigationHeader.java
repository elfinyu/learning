package page.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.PageObject;

public class NavigationHeader extends PageObject {
	
	public NavigationHeader(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		navigationDropDownSearch= new DropDownSuggestionSearch(driver);
	}

	DropDownSuggestionSearch navigationDropDownSearch;

	@FindBy(id="navbar-submit-button")
	WebElement submitButton;
	@FindBy(id="quicksearch")
	WebElement quickSearchSelection;
	@FindBy(id="navbar-query")
	WebElement searchBar;
	
	public WebElement getSearchBar() {
		return searchBar;
	}	
	
}
