package page.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.PageObject;

public class ResultPage extends PageObject {

	TitleResultsPanel titleResults;

	public ResultPage(WebDriver driver) {
		super(driver);
		this.titleResults = new TitleResultsPanel(driver);
		PageFactory.initElements(driver, titleResults);
	}

	public int getTitleResultsCount(String search) {
		return titleResults.getTitleResultsCount(search);
	}

	public int getTitleResultsCountOfLinks(String search) {
		return titleResults.getTitleResultsCountOfLinks(search);
	}

	public int getTitleResultsCountOfLinksUsingXpath(String search) {
		return titleResults.getTitleResultsCountOfLinksUsingXpath(search);
	}

}
