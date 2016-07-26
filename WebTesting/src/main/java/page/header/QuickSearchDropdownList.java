package page.header;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import page.IMDBPage;
import page.PageObject;

public class QuickSearchDropdownList extends PageObject {
	public QuickSearchDropdownList(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//select[@id='quicksearch']")
	WebElement quickSearchDropdownList;
	Select typeSelector;
	List<WebElement> typeOption;
	
	public void selectDropdownList(String label){
		typeSelector=new Select(quickSearchDropdownList);
		typeSelector.selectByVisibleText(label);
	}
}
