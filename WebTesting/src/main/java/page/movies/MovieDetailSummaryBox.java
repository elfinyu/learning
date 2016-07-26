package page.movies;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.IMDBPage;
import page.PageObject;

public class MovieDetailSummaryBox extends IMDBPage{

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
	WebElement movieWritersDiv;
	
	By writers_details_locator=By.xpath(".//span/a");
	
	@FindBy(xpath="//div[@class='metacriticScore score_mixed titleReviewBarSubItem']/span")
	WebElement metaScore;
	
	@FindBy(xpath="//span[@class='ghostText']/ancestor::span[@class='subText']")
	WebElement reviewsParentSpan;
	By user_reviews_locator=By.xpath("./a[contains(text(),'user')]");
	By critic_reviews_locator=By.xpath("./a[contains(text(),'critic')]");
	//By user_reviews_locator=By.xpath("./a");
	@FindBy(xpath="//span[@class='popularityDown']/ancestor::span[@class='subText']")
	WebElement popularityTrend;
	
	public int getUsersReviewsCount(){
		System.out.println(reviewsParentSpan.getText());
		WebElement userReviews=reviewsParentSpan.findElement(user_reviews_locator);
		System.out.println(userReviews.getText());
		String strUserReviews=userReviews.getText();
		return getReviewsCount(strUserReviews,"user");
		//return 0;
	}
	
	public int getCriticReviewsCount(){
		WebElement criticReviews=reviewsParentSpan.findElement(critic_reviews_locator);
		String strCriticReviews=criticReviews.getText();
		return getReviewsCount(strCriticReviews,"critic");
	}
	
	private int getReviewsCount(String strReviews, String strReplace){
		strReviews=strReviews.replace(strReplace, "").trim();
		strReviews=strReviews.replace(",", "").trim();		
		return Integer.parseInt(strReviews);
	}
	
	public String getPopularityTrend(){
		return popularityTrend.getText();
	}	
}
