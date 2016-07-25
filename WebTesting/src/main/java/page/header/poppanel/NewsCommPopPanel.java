package page.header.poppanel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.IMDBPage;

public class NewsCommPopPanel extends IMDBPage {

	public NewsCommPopPanel(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//li[@id='navNewsMenu']")
	WebElement eventsButton;

	By popup_panel_list=By.xpath(".//div[@id='navMenu3']//div[@class='subNavListContainer']//li");
	final static String strPanelLocator="#navNewsMenu>div.sub_nav";
	
	public void selectNewsPanelLink(String linkLabel){	
		List<WebElement> linksList=eventsButton.findElements(popup_panel_list);
		selectPopPanelLink(strPanelLocator,linksList,linkLabel);
	}
}
