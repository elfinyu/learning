package page.header.poppanel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.IMDBPage;

public class EventsPopPanel extends IMDBPage {

	public EventsPopPanel(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//li[@id='navNameMenu']")
	WebElement eventsButton;

	By popup_panel_list=By.xpath(".//div[@id='navMenu2']//div[@class='subNavListContainer']//li");
	final static String strPanelLocator="#navNameMenu>div.sub_nav";
	
	public void selectEventsPanelLink(String linkLabel){	
		List<WebElement> linksList=eventsButton.findElements(popup_panel_list);
		selectPopPanelLink(strPanelLocator,linksList,linkLabel);
	}	
}
