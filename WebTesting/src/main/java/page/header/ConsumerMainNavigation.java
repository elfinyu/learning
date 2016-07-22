package page.header;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.PageObject;

public class ConsumerMainNavigation extends PageObject {
	
	public ConsumerMainNavigation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//ul[@id='consumer_main_nav']")
	WebElement consumerMainNav;
	
	By navigation_title_link_locator = By.xpath(".//li[@id='navTitleMenu']//p[@class='navCategory']//a");
	By navigation_name_link_locator = By.xpath(".//li[@id='navNameMenu']//p[@class='navCategory']//a");
	By navigation_news_link_locator = By.xpath(".//li[@id='navNewsMenu']//p[@class='navCategory']//a");
	By navigation_watchlist_link_locator = By.xpath(".//li[@id='navWatchlistMenu']//p[@class]//a");
	
	public void clickOnTitleMenuNav(String label){
		this.clickOnLinkOfEqualString(consumerMainNav,navigation_title_link_locator,label);
	}
	public void clickOnNameMenuNav(String label){
		System.out.println("click ON name Menu Navigation!!");
		this.clickOnLinkOfEqualString(consumerMainNav,navigation_name_link_locator,label);
	}	
	public void clickOnNewsMenuNav(String label){
		this.clickOnLinkOfEqualString(consumerMainNav,navigation_news_link_locator,label);
	}	
	public void clickOnWatchListNav(String label){
		this.clickOnLinkOfEqualString(consumerMainNav,navigation_watchlist_link_locator,label);
	}	
}
