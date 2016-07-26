package page.movies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import page.IMDBPage;
import page.PageObject;
import page.searchresult.TitleResultsPanel;

public class MovieDetailPage extends IMDBPage {

	public MovieDetailTitleBar titleBarControl;
	public MovieDetaiQuickLinksBar quickLinksBarControl;
	public MovieDetailSummaryBox movieDetailSummaryControl;

	public MovieDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.titleBarControl = new MovieDetailTitleBar(driver);
		PageFactory.initElements(driver, titleBarControl);
		this.quickLinksBarControl=new MovieDetaiQuickLinksBar(driver);
		PageFactory.initElements(driver,quickLinksBarControl);
		this.movieDetailSummaryControl=new MovieDetailSummaryBox(driver);
		PageFactory.initElements(driver, movieDetailSummaryControl);
	}
	
	public MovieDetailTitleBar getTitleBarControl() {
		return titleBarControl;
	}

	public void setTitleBarControl(MovieDetailTitleBar titleBarControl) {
		this.titleBarControl = titleBarControl;
	}

	public MovieDetaiQuickLinksBar getQuickLinksBarControl() {
		return quickLinksBarControl;
	}

	public void setQuickLinksBarControl(MovieDetaiQuickLinksBar quickLinksBarControl) {
		this.quickLinksBarControl = quickLinksBarControl;
	}

	public MovieDetailSummaryBox getMovieDetailSummaryControl() {
		return movieDetailSummaryControl;
	}

	public void setMovieDetailSummaryControl(MovieDetailSummaryBox movieDetailSummaryControl) {
		this.movieDetailSummaryControl = movieDetailSummaryControl;
	}	
}
