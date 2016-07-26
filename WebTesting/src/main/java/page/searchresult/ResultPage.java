package page.searchresult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.IMDBPage;

public class ResultPage extends IMDBPage {

	public TitleResultsPanel titleResultsControl;
	public NameResultsPanel nameResultsControl;

	public ResultPage(WebDriver driver) {
		super(driver);
		this.titleResultsControl = new TitleResultsPanel(driver);
		PageFactory.initElements(driver, titleResultsControl);
		this.nameResultsControl = new NameResultsPanel(driver);
		PageFactory.initElements(driver, nameResultsControl);
	}

	public int getTitleResultsCount(String search) {
		return titleResultsControl.getTitleResultsCount(search);
	}

	public int getTitleResultsCountOfLinks(String search) {
		return titleResultsControl.getTitleResultsCountOfLinks(search);
	}

	public int getTitleResultsCountOfLinksUsingXpath(String search) {
		return titleResultsControl.getTitleResultsCountOfLinksUsingXpath(search);
	}
	
	public TitleResultsPanel getTitleResultsControl() {
		return titleResultsControl;
	}

	public void setTitleResultsControl(TitleResultsPanel titleResultsControl) {
		this.titleResultsControl = titleResultsControl;
	}

	public NameResultsPanel getNameResultsControl() {
		return nameResultsControl;
	}

	public void setNameResultsControl(NameResultsPanel nameResultsControl) {
		this.nameResultsControl = nameResultsControl;
	}	
}
