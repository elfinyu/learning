package page.movies;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.IMDBPage;

public class MovieDetaiQuickLinksBar extends IMDBPage{
	
	public MovieDetaiQuickLinksBar(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@id='quicklinksMainSection']/a[@class='quicklink']")
	List<WebElement> linksBarList;	

	public void clickLink(String linkLabel){
		WebElement foundLink=null;
		for(WebElement currLink:linksBarList){
			System.out.println(currLink.getText());
			if(currLink.getText().equalsIgnoreCase(linkLabel)){
				foundLink=currLink;
			}
		}
		if(foundLink!=null){
			foundLink.click();
		}
	}
	
	public void clickQuickLink(String linkLabel){
		this.clickOnLinkOfEqualString(linksBarList, linkLabel);
	}
}
