package page.searchresult;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.IMDBPage;
import page.PageObject;

public class TitleResultsPanel extends IMDBPage {

	public TitleResultsPanel(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Parent object of title results
	 */
	@FindBy(xpath="//a[@name='tt']/ancestor::div[@class='findSection']")
	WebElement titleResultsDiv;
	
	/**
	 * Define locators for child objects for results links
	 */
	By results_text_locator = By.xpath(".//td[@class='result_text']");
	By results_text_locator_links = By.xpath(".//td[@class='result_text']/a");
		
	/**
	 * Can find results of links using findElement
	 * 
	 * @param search
	 * @return
	 */
	public int getTitleResultsCount(String search){
		return this.getElementCount(titleResultsDiv, results_text_locator,search);
	}
	
	public int getTitleResultsCountOfLinks(){
		return this.getElementCount(titleResultsDiv, results_text_locator);
	}	
	public int getTitleResultsCountOfLinks(String search){
		return this.getElementCount(titleResultsDiv, results_text_locator, search);
	}
	
	public int getTitleResultsCountOfLinksUsingXpath(){
		return this.getElementCount(titleResultsDiv, results_text_locator_links);
	}
	
	public int getTitleResultsCountOfLinksUsingXpath(String search){
		return this.getElementCount(titleResultsDiv, results_text_locator_links, search);
	}
	
	public void clickTitleLink(String linkLabel){
		this.clickOnLinkOfEqualString(titleResultsDiv, results_text_locator, linkLabel);
	}
	
}
