package page.login;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.PageObject;

public class LoginPage extends PageObject{

	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement submitButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterUsername(String username){
		this.username.sendKeys(username);
	}
	
	public void enterPassword(String pw){
		this.password.sendKeys(pw);
	}
	
	public void clickLogin(){
		submitButton.click();
	}
	
	public void verifySuccessfullyLogin(){
		WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 5);
		ExpectedCondition<WebElement> condition = ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Log Out']"));
		webDriverWait.until(condition);
	}

}
