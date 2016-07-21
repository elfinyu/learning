package page.movies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import page.PageObject;
import page.search.TitleResultsPanel;

public class MoviesDetailPage extends PageObject {

	public MovieDetailTitleBar titleBar;
	public MovieDetaiQuickLinksBar quickLinksBar;
	
	public MoviesDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.titleBar = new MovieDetailTitleBar(driver);
		PageFactory.initElements(driver, titleBar);
		this.quickLinksBar=new MovieDetaiQuickLinksBar(driver);
		PageFactory.initElements(driver,quickLinksBar);
	}
	
}