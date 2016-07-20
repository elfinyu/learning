package page.movies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.PageObject;

public class MoviesDetailPage extends PageObject {

	@FindBy(xpath = "//h1[@itemprop='name']")
	WebElement movieTitle;
	@FindBy(xpath = "//time[@itemprop='duration']")
	WebElement movieDuration;
	@FindBy(xpath = "//meta[@itemprop='contentRating']")
	WebElement movieRating;
	@FindBy(xpath = "//span[@itemprop='genre']")
	WebElement movieType; // have 2 matches?
	@FindBy(xpath = "//a[@title='See more release dates']")
	WebElement movieDate;

	public MoviesDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getTitleName() {
		return movieTitle.getText();
	}

}
