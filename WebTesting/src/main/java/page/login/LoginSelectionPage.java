package page.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.IMDBPage;

public class LoginSelectionPage extends IMDBPage{

	
	public LoginSelectionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
	}

	@FindBy(className="list-group")
	WebElement loginChoices;
	
	public WebElement getIMDbLoginButton(){
		return loginChoices.findElement(By.linkText("IMDb"));
	}
	
	public void clickIMDbLogin(){
		getIMDbLoginButton().click();
	}
	
	
}
