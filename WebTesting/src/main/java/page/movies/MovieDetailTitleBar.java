package page.movies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.IMDBPage;
import page.PageObject;

public class MovieDetailTitleBar extends IMDBPage {
	
	@FindBy(xpath = "//h1[@itemprop='name']")
	WebElement movieTitle;
	@FindBy(xpath = "//time[@itemprop='duration']")
	WebElement movieDuration;
	@FindBy(xpath = "//meta[@itemprop='contentRating']")
	WebElement movieContentRating;
	@FindBy(xpath = "//span[@itemprop='genre']")
	WebElement movieType; // have 2 matches?
	@FindBy(xpath = "//a[@title='See more release dates']")
	WebElement movieDate;
	@FindBy(xpath="//span[@itemprop='ratingValue']")
	WebElement movieViewerRating;
	@FindBy(xpath="//span[@itemprop='ratingCount']")
	WebElement movieViewerRatingCount;
	
	public MovieDetailTitleBar(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getMovieTitle() {
		return movieTitle.getText();
	}
	
	public String getMovieDuration(){
		return movieDuration.getText();
	}
	
	public String getMovieContentRating(){
		return movieContentRating.getText();
	}

	public String getMovieType(){
		return movieType.getText();
	}
	
	public String getMovieReleaseDate(){
		return movieDate.getText();
	}
	
	public String getMovieViewerRating(){
		return movieViewerRating.getText();
	}
	
	public int getMovieViewerRatingCount(){
		return Integer.parseInt(movieViewerRatingCount.getText().replace(",", ""));
	}	
}
