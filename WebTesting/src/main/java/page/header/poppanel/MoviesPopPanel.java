package page.header.poppanel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.IMDBPage;

public class MoviesPopPanel extends IMDBPage {

	public MoviesPopPanel(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//li[@id='navTitleMenu']")
	WebElement moviesButton;

	By popup_panel_list=By.xpath(".//div[@id='navMenu1']//div[@class='subNavListContainer']//li");
	final static String strPanelLocator="#navTitleMenu>div.sub_nav";
	
	public void selectMoviesPanelLink(String linkLabel){
		List<WebElement> linksList=moviesButton.findElements(popup_panel_list);
		selectPopPanelLink(strPanelLocator,linksList,linkLabel);
	}
	
}
