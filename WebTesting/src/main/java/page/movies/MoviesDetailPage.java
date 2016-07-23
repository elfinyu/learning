package page.movies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import page.IMDBPage;
import page.PageObject;
import page.searchresult.TitleResultsPanel;

public class MoviesDetailPage extends IMDBPage {

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
