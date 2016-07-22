package page.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import page.PageObject;

public class NavigationHeader extends PageObject {

	DropdownSuggestionSearch navigationDropdownSearch;
	QuickSearchDropdownList quickSearchDropdownList;
	ConsumerMainNavigation consumerMainNav;
	
	public NavigationHeader(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		navigationDropdownSearch = new DropdownSuggestionSearch(driver);
		quickSearchDropdownList = new QuickSearchDropdownList(driver);
		consumerMainNav = new ConsumerMainNavigation(driver);
		PageFactory.initElements(driver,navigationDropdownSearch);
		PageFactory.initElements(driver,quickSearchDropdownList);
		PageFactory.initElements(driver,consumerMainNav);
	}

	@FindBy(id="navbar-submit-button")
	WebElement submitButton;
//	@FindBy(id="quicksearch")
//	WebElement quickSearchSelection;
	@FindBy(id="navbar-query")
	WebElement searchBar;
	
	public WebElement getSearchBar() {
		return searchBar;
	}

	public DropdownSuggestionSearch getNavigationDropdownSearch() {
		return navigationDropdownSearch;
	}

	public void setNavigationDropdownSearch(DropdownSuggestionSearch navigationDropdownSearch) {
		this.navigationDropdownSearch = navigationDropdownSearch;
	}

	public QuickSearchDropdownList getQuickSearchDropDownList() {
		return quickSearchDropdownList;
	}

	public void setQuickSearchDropdownList(QuickSearchDropdownList quickSearchDropdownList) {
		this.quickSearchDropdownList = quickSearchDropdownList;
	}

//	public WebElement getQuickSearchSelection() {
//		return quickSearchSelection;
//	}
//
//	public void setQuickSearchSelection(WebElement quickSearchSelection) {
//		this.quickSearchSelection = quickSearchSelection;
//	}	

	public ConsumerMainNavigation getConsumerMainNav() {
		return consumerMainNav;
	}

	public void setConsumerMainNav(ConsumerMainNavigation consumerMainNav) {
		this.consumerMainNav = consumerMainNav;
	}
	
	public String getCurrentPageTitle(){
		String currTitle = getDriver().getTitle();
		return currTitle;
	}
}
