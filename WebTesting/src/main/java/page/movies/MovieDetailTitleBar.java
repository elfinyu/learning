package page.movies;

import org.openqa.selenium.NoSuchElementException;
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
	//@FindBy(xpath = "//span[@itemprop='genre']")
	@FindBy(xpath = "//a[contains(@href,'gnr')]/..")
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
		try{
			return movieTitle.getText();
		}catch(NoSuchElementException e){
			return "-NA-";
		}
	}
	
	public String getMovieDuration(){
		try{
			return movieDuration.getText();
		}catch(NoSuchElementException e){
			return "-NA-";
		}
	}
	
	public String getMovieContentRating(){
		try{
			System.out.println(movieContentRating.getAttribute("content"));
			return movieContentRating.getAttribute("content");
		}catch(NoSuchElementException e){
			return "-NA-";
		}
	}

	public String getMovieType(){
		try{
			return movieType.getText();
		}catch(NoSuchElementException e){
			return "-NA-";
		}
	}
	
	public String getMovieReleaseDate(){
		try{
			return movieDate.getText();
		}catch(NoSuchElementException e){
			return "-NA-";
		}
	}
	
	public String getMovieViewerRating(){
		try{
			return movieViewerRating.getText();
		}catch(NoSuchElementException e){
			return "-NA-";
		}
	}
	
	public int getMovieViewerRatingCount(){
		try{
			return Integer.parseInt(movieViewerRatingCount.getText().replace(",", ""));
		}catch(NoSuchElementException e){
			return -1;
		}
	}	

}
