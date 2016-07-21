package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropDownSuggestionSearch extends PageObject{
	
	public DropDownSuggestionSearch(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@id='navbar-suggestionsearch']")
	WebElement parentDropDown;
	
	//By drop_down_option_list=By.xpath(".//div[@class='suggestionlabel']");
	By drop_down_option_list=By.xpath(".//a");
	public void selectDropDownSuggestion(String strLabel){
		List<WebElement> dropdownList=parentDropDown.findElements(drop_down_option_list);
		this.clickOnLinkOfContainsString(dropdownList, strLabel);
	}
}
