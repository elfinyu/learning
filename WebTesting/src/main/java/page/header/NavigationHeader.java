package page.header;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import page.IMDBPage;
import page.PageObject;

public class NavigationHeader extends PageObject {

	public DropdownSuggestionSearch navigationDropdownSearch;
	public QuickSearchDropdownList quickSearchDropdownList;
	public ConsumerMainNavigation consumerMainNav;
	
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
	@FindBy(id="navbar-query")
	WebElement searchBar;
	
	@FindBy(xpath="//li[@class='social js_nav_item']")
	WebElement socialLinksParent;
	By facebook_link = By.xpath(".//span[@class='desktop-sprite follow-facebook']");
	By twitter_link = By.xpath(".//span[@class='desktop-sprite follow-twitter']");
	By instagram_link = By.xpath(".//span[@class='desktop-sprite follow-instagram']");
	
	@FindBy(id="nblogin")
	WebElement loginName;
	
	
	public void clickLoginButton(){
		loginName.click();
	}
	
	public WebElement getSearchBar() {
		return searchBar;
	}

	public DropdownSuggestionSearch getNavigationDropdownSearch() {
		return navigationDropdownSearch;
	}

	

	public QuickSearchDropdownList getQuickSearchDropDownList() {
		return quickSearchDropdownList;
	}

	

	public ConsumerMainNavigation getConsumerMainNav() {
		return consumerMainNav;
	}

	
	
	public String getCurrentPageTitle(){
		String currTitle = getDriver().getTitle();
		return currTitle;
	}
	
	public void clickFollowFacebook(){
		clickSocialButton(facebook_link);
	}
	
	public void clickFollowTwitter(){
		clickSocialButton(twitter_link);
	}
	
	public void clickFollowInstagram(){
		clickSocialButton(instagram_link);
	}
	
	public void clickSocialButton(By locator){
		WebElement socailElement=socialLinksParent.findElement(locator);
		socailElement.click();
	}
	
	public void verfiySearchExist(){
		if(!searchBar.isDisplayed()) throw new ElementNotVisibleException("as");
	}
	
	public void searchTitle(String value){
		searchBar.sendKeys(value);
		//submitButton.click();
		searchBar.submit();	
	}
}
