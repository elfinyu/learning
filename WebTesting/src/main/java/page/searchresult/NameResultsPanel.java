package page.searchresult;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.PageObject;

public class NameResultsPanel extends PageObject {

	public NameResultsPanel(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/** 
	 * Define locators for parent
	*/
	@FindBy(xpath="//a[@name='nm']/ancestor::div[@class='findSection']")
	WebElement nameResultsDiv;
	
	/**
	 * Define locators for child objects for results links
	 */
	By results_text_locator = By.xpath(".//td[@class='result_text']");
	By results_text_locator_links = By.xpath(".//td[@class='result_text']/a");
	
	public int getNameResultsCount(){
		return this.getElementCount(nameResultsDiv, results_text_locator);
	}
	
	public int getNameResultsLinksCount(){
		return this.getElementCount(nameResultsDiv, results_text_locator_links);	
	}
	
	public void clickNameLink(String strLinkLabel){
		this.clickOnLinkOfEqualString(nameResultsDiv, results_text_locator, strLinkLabel);
	}
}
