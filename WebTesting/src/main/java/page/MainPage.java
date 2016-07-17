package page;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends PageObject{

	public MainPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(id="navbar-query")
	WebElement searchBar;
	@FindBy(id="navbar-submit-button")
	WebElement submitButton;
	@FindBy(tagName="tr")
	List<WebElement> resultRows;
	@FindBy(tagName="a")
	List<WebElement> links;
	@FindBy(xpath="//*[@id='main']/div/div[2]/table/tbody/tr[1]/td[2]/a")
	WebElement link;
	
	public void launch(){
		getDriver().get("http://www.imdb.com/");
	}
	
	public void verfiySearchExist(){
		if(!searchBar.isDisplayed()) throw new ElementNotVisibleException("as");
	}
	
	public void searchTitle(String value){
		searchBar.sendKeys(value);
		//submitButton.click();
		searchBar.submit();	
	}
	
	public String getCurrentPageTitle(){
		String currTitle = getDriver().getTitle();
		return currTitle;
	}
	
	public void getSearchedResult(){
		System.out.println("Result rows: "+ resultRows.size());
		for(WebElement result:resultRows){
			System.out.println(result.getText());
		}
	}
	
	public void clickLink(String linkLabel){
		for(WebElement result:resultRows){
			if(result.getText().equals(linkLabel)){
				System.out.println("LINK MATCHED");
				System.out.println("href : "+result.getAttribute("href"));
				System.out.println("getText : "+result.getText());
				System.out.println("ToString : "+result.toString());
				System.out.println("Location : "+result.getLocation());
				System.out.println("TagName : "+result.getTagName());
				System.out.println("Result : "+result);
				//result.submit();
				//result.click();
			}
		}
		//link.click();
	}
	
	public void checkAllLinks(){
		System.out.println("Links amount:"+links.size());
		if(links.size()>0){
			for(WebElement link:links){
				String url=link.getAttribute("href");
				VerifyLinkActive(url);
			}
		}
	}
	
	private void VerifyLinkActive(String strURL){
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
