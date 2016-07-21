package page;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkCheckerUtils{

	public static void checkAllLinks(PageObject obj) {
		WebDriver driver = obj.getDriver();
		List<WebElement> findElements = driver.findElements(By.tagName("a"));
		for(WebElement link:findElements){
			String url=link.getAttribute("href");
			verifyLinkActive(url);
		}
	}

	public static int getAllLinksCount(PageObject obj){
		WebDriver driver=obj.getDriver();
		List<WebElement> findElements=driver.findElements(By.tagName("a"));
		return findElements.size();	
	}
	
	public static void clickLink(String linkLabel,PageObject obj) {

		//String xpathExpression="//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]/td[2]/a";
		//WebElement findElement = obj.getDriver().findElement(By.xpath(xpathExpression));
		WebElement findElement;
		findElement=getLinkByTagA(linkLabel,obj);
		if(findElement==null){
			System.out.println("Targeted link not found, please try other findElement approach!");
		}
		if(findElement!=null){
			findElement.click();
		}
	}
		
	public static WebElement getLinkByTagA(String linkLabel,PageObject obj){
		List<WebElement> findElements = getLinksByTag("a", obj);
		WebElement foundElement=null;
		for(WebElement currElement:findElements){
			if(currElement.getText().equalsIgnoreCase(linkLabel)){
				foundElement=currElement;
			}
		}
		if(foundElement!=null){
			return foundElement;
		}
		return null;
	}

	public static List<WebElement> getLinksByTag(String strTag,PageObject obj){
		return obj.getDriver().findElements(By.tagName(strTag));
	}
	
	private static void verifyLinkActive(String strURL){
		try {
			URL url=new URL(strURL);
			HttpURLConnection httpurlconnection=(HttpURLConnection) url.openConnection();
			httpurlconnection.setConnectTimeout(3000);
			httpurlconnection.connect();
			
			if(httpurlconnection.getResponseCode()==200){
				System.out.println(strURL + "-" + httpurlconnection.getResponseMessage());
			}else if(httpurlconnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
				System.out.println(strURL + "-" + httpurlconnection.getResponseMessage());
			}else{
				System.out.println(strURL + "-" + httpurlconnection.getResponseMessage());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


