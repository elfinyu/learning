package page.header.poppanel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.IMDBPage;

public class WatchlistPopPanel extends IMDBPage {

	public WatchlistPopPanel(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//li[@id='navWatchlistMenu']")
	WebElement eventsButton;

	By popup_panel_list=By.xpath(".//div[@id='navMenu4']//li");
	final static String strPanelLocator="#navWatchlistMenu>div.sub_nav";
	
	public void selectWatchlistPanelLink(String linkLabel){
		mouseoverDisplay(strPanelLocator);
		WebDriverWait waitA = new WebDriverWait(getDriver(), 10);
		waitA.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("img")));
		
		List<WebElement> imgLinksList=eventsButton.findElements(popup_panel_list);
		System.out.println(imgLinksList.size());
		for(WebElement imgLink:imgLinksList){
			WebElement imgElement=imgLink.findElement(By.tagName("img"));
			System.out.println(imgElement.getAttribute("title"));
			if(imgElement.getAttribute("title").equals(imgLinksList)){
				System.out.println("Click Image");
				imgElement.click();
			}
		}
	}
}
