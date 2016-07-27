package page.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import page.IMDBPage;
import page.PageObject;
import page.header.poppanel.EventsPopPanel;
import page.header.poppanel.MoviesPopPanel;
import page.header.poppanel.NewsCommPopPanel;
import page.header.poppanel.WatchlistPopPanel;

public class ConsumerMainNavigation extends PageObject {

	//Movies,TV & Showtimes panels
	MoviesPopPanel moviesPopPanelControl;
	EventsPopPanel eventsPopPanelControl;
	NewsCommPopPanel newsPopPanelControl;
	WatchlistPopPanel watchlistPopPanelControl;
	
	public ConsumerMainNavigation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		moviesPopPanelControl=new MoviesPopPanel(driver);
		eventsPopPanelControl=new EventsPopPanel(driver);
		newsPopPanelControl=new NewsCommPopPanel(driver);
		watchlistPopPanelControl=new WatchlistPopPanel(driver);
		PageFactory.initElements(driver, moviesPopPanelControl);
		PageFactory.initElements(driver, eventsPopPanelControl);
		PageFactory.initElements(driver, newsPopPanelControl);
		PageFactory.initElements(driver, watchlistPopPanelControl);
	}
	
	public MoviesPopPanel getMoviesPopPanelControl() {
		return moviesPopPanelControl;
	}
	public void setMoviesPopPanelControl(MoviesPopPanel moviesPopPanelControl) {
		this.moviesPopPanelControl = moviesPopPanelControl;
	}

	public EventsPopPanel getEventsPopPanelControl() {
		return eventsPopPanelControl;
	}

	public void setEventsPopPanelControl(EventsPopPanel eventsPopPanelControl) {
		this.eventsPopPanelControl = eventsPopPanelControl;
	}

	public NewsCommPopPanel getNewsPopPanelControl() {
		return newsPopPanelControl;
	}

	public void setNewsPopPanelControl(NewsCommPopPanel newsPopPanelControl) {
		this.newsPopPanelControl = newsPopPanelControl;
	}

	public WatchlistPopPanel getWatchlistPopPanelControl() {
		return watchlistPopPanelControl;
	}

	public void setWatchlistPopPanelControl(WatchlistPopPanel watchlistPopPanelControl) {
		this.watchlistPopPanelControl = watchlistPopPanelControl;
	}

	@FindBy(xpath="//ul[@id='consumer_main_nav']")
	WebElement consumerMainNav;
	
	By navigation_title_link_locator = By.xpath(".//li[@id='navTitleMenu']//p[@class='navCategory']//a");
	By navigation_name_link_locator = By.xpath(".//li[@id='navNameMenu']//p[@class='navCategory']//a");
	By navigation_news_link_locator = By.xpath(".//li[@id='navNewsMenu']//p[@class='navCategory']//a");
	By navigation_watchlist_link_locator = By.xpath(".//li[@id='navWatchlistMenu']//p[@class]//a");
	
	public void clickOnTitleMenuNav(String label){
		IMDBPage.clickOnLinkOfEqualString(consumerMainNav,navigation_title_link_locator,label);
	}
	public void clickOnNameMenuNav(String label){
		System.out.println("click ON name Menu Navigation!!");
		IMDBPage.clickOnLinkOfEqualString(consumerMainNav,navigation_name_link_locator,label);
	}	
	public void clickOnNewsMenuNav(String label){
		IMDBPage.clickOnLinkOfEqualString(consumerMainNav,navigation_news_link_locator,label);
	}	
	public void clickOnWatchListNav(String label){
		IMDBPage.clickOnLinkOfEqualString(consumerMainNav,navigation_watchlist_link_locator,label);
	}	
	
}
