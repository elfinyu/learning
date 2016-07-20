package page.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.PageObject;

public class TitleResultsPanel extends PageObject {

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
	
	public int getTitleResultsCount(String search){
		List<WebElement> findElements = titleResultsDiv.findElements(results_text_locator);
		List<WebElement> results = new ArrayList<>();
		for(WebElement element : findElements){
			
			if(StringUtils.containsIgnoreCase(element.getText(),search)){
				System.out.println(element.getText());
				results.add(element);
			}
		}
		System.out.println();
		return results.size();
	}
	
	/**
	 * Can find results of links using findElement
	 * 
	 * @param search
	 * @return
	 */
	public int getTitleResultsCountOfLinks(String search){
		List<WebElement> findElements = titleResultsDiv.findElements(results_text_locator);
		List<WebElement> results = new ArrayList<>();
		for(WebElement element : findElements){
			WebElement linkTextElement = element.findElement(By.tagName("a"));
			if(StringUtils.containsIgnoreCase(linkTextElement.getText(),search)){
				System.out.println(linkTextElement.getText());
				results.add(linkTextElement);
			}
		}
		System.out.println();
		return results.size();
	}
	
	public int getTitleResultsCountOfLinksUsingXpath(String search){
		List<WebElement> findElements = titleResultsDiv.findElements(results_text_locator_links);
		List<WebElement> results = new ArrayList<>();
		for(WebElement element : findElements){
			
			if(StringUtils.containsIgnoreCase(element.getText(),search)){
				System.out.println(element.getText());
				results.add(element);
			}
		}
		System.out.println();
		return results.size();
	}
	
	
	public void clickOnResult(String search){
		List<WebElement> findElements = titleResultsDiv.findElements(results_text_locator);
		WebElement foundElement=null;
		for(WebElement element : findElements){
			if(element.getText().equalsIgnoreCase(search)){
				System.out.println(element.getText());
				foundElement = element;
			}
		}
		if(foundElement != null){
			foundElement.findElement(By.tagName("a")).click();
		}
	}

}
