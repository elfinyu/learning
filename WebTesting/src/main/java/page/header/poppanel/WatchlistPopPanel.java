package page.header.poppanel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.IMDBPage;
import page.PageObject;

public class WatchlistPopPanel extends PageObject {

	public WatchlistPopPanel(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//li[@id='navWatchlistMenu']")
	WebElement eventsButton;

	By popup_panel_list=By.xpath(".//div[@id='navMenu4']//li");
	final static String strPanelLocator="#navWatchlistMenu>div.sub_nav";
	
	public void selectWatchlistPanelLink(String linkLabel){
		WebDriverWait waitA = new WebDriverWait(getDriver(), 10);
		
		IMDBPage.mouseoverDisplay(strPanelLocator, getDriver());
		waitA.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='navMenu4']//li")));
		waitA.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("a")));
		
		List<WebElement> imgLinksList=eventsButton.findElements(popup_panel_list);
		//System.out.println(imgLinksList.size());
		for(WebElement imgLink:imgLinksList){
			WebElement imgElement=imgLink.findElement(By.tagName("a"));
			//System.out.println(imgElement.getAttribute("href"));
			if(imgElement.getAttribute("href").contains(linkLabel)){
				imgElement.click();
				break;
			}
		}
		
	}
}
