package page.header;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import page.PageObject;

public class DropdownSuggestionSearch extends PageObject{
	
	DropdownSuggestionSearch dropdownSuggestion;
	public DropdownSuggestionSearch(WebDriver driver) {
		super(driver);
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
