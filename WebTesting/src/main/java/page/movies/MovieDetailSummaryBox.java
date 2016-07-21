package page.movies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.PageObject;

public class MovieDetailSummaryBox extends PageObject{

	public MovieDetailSummaryBox(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@class='plot_summary_wrapper']")
	WebElement movieSummaryDiv;
	@FindBy(xpath="//div[@class='summary_text']")
	WebElement movieDescription;
	@FindBy(xpath="//span[@itemprop='director']")
	WebElement movieDirector;
	
	/*parent of writers*/
	@FindBy(xpath="//span[@itemprop='creator']/ancestor::div[@class='credit_summary_item']")
	WebElement writersDiv;
	
	By writers_details_locator=By.xpath(".//span/a");
	
	@FindBy(xpath="//div[@class='metacriticScore score_mixed titleReviewBarSubItem']/span")
	WebElement metaScore;
	@FindBy(xpath="//span[@class='ghostText']/ancestor::span[@class='subText']")
	WebElement reviewsParentSpan;
	
	By reviewers_locator=By.xpath(".//a");
	
}
