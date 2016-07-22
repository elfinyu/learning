package page;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IMDBWebPage extends LinkCheckerUtils {
	
	protected int getElementCount(WebElement parent,By locator){
		List<WebElement> elementResultsList=parent.findElements(locator);
		return elementResultsList.size();
	}
	
	protected int getElementCount(WebElement parent,By locator, String search){
		List<WebElement> findElements = parent.findElements(locator);
		List<WebElement> results = new ArrayList<>();
		for(WebElement element : findElements){
			System.out.println("Current <td> text:"+element.getText());
			WebElement linkTextElement = element.findElement(By.tagName("a"));
			System.out.println("Current <a> text:"+linkTextElement.getText());
			if(StringUtils.containsIgnoreCase(linkTextElement.getText(),search)){
				System.out.println("Contained text:"+linkTextElement.getText());
				results.add(linkTextElement);
			}
		}
		System.out.println();
		return results.size();		
	}
	
	protected void clickOnLinkOfEqualString(WebElement parent,By locator, String linkLabel){
		List<WebElement> linkResultsList=parent.findElements(locator);
		clickOnLinkOfEqualString(linkResultsList, linkLabel);
	}
	
	protected void clickOnLinkOfEqualString(List<WebElement> linkResultsList, String linkLabel){
		WebElement foundElement=null;
		for(WebElement currLinkElement:linkResultsList){
			System.out.println(currLinkElement.getText());
			if(currLinkElement.getText().equalsIgnoreCase(linkLabel)){
				foundElement=currLinkElement;
			}
		}
		if(foundElement!=null){
			System.out.println("Link Found!!");
			foundElement.findElement(By.tagName("a")).click();
		}else{
			System.out.println("Link Not Found!!");
		}		
	}

	public void clickOnLinkOfContainsString(List<WebElement> linkResultsList, String linkLabel){
		WebElement foundElement=null;
		for(WebElement currLinkElement:linkResultsList){
			System.out.println(currLinkElement.getText());
			if(StringUtils.containsIgnoreCase(currLinkElement.getText(), linkLabel)){
				foundElement=currLinkElement;
			}
		}
		if(foundElement!=null){
			System.out.println("Link Found!!");
			foundElement.click();
		}else{
			System.out.println("Link Not Found!!");
		}		
	}

}
