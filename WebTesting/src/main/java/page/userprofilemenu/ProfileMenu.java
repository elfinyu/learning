package page.userprofilemenu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.PageObject;

public class ProfileMenu extends PageObject{
	
	public ProfileMenu(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[@id='navUserMenu']")
	WebElement loginUserButton;
	
	@FindBy(xpath="//ul[@id='consumer_user_nav']//div[@class='sub_nav']//div[@class='subNavListContainer']")
	WebElement profileMouseOnPopup;
	
	By logout_locator=By.xpath(".//a[@id='nblogout']");
	

	public void logout(){
		logout3();
	
	}

	/**
	 * logout actions selenium hover.
	 */
	private void logout1() {
		WebDriverWait waitAA = new WebDriverWait(getDriver(), 10);
		waitAA.until(ExpectedConditions.visibilityOfElementLocated(By.id("navUserMenu")));
		Actions actions = new Actions(getDriver());
		actions.moveToElement(loginUserButton);
		
		actions.build().perform();
		waitAA.until(ExpectedConditions.visibilityOfElementLocated(logout_locator));
		getDriver().findElement(logout_locator).click();
		WebDriverWait waitA = new WebDriverWait(getDriver(), 10);
		waitA.until(ExpectedConditions.visibilityOfElementLocated(By.id("nblogin")));
	}
	
	/**
	 * log out by setting attribute of style
	 */
	public void logout2(){
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("document.querySelector('#navUserMenu>div.sub_nav').setAttribute('style','display: block;');");
		getDriver().findElement(logout_locator).click();
		WebDriverWait waitA = new WebDriverWait(getDriver(), 10);
		waitA.until(ExpectedConditions.visibilityOfElementLocated(By.id("nblogin")));
	}
	
	/**
	 * Log out using java script hover
	 */
	public void logout3(){
		String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} "
				+ "else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript(mouseOverScript, loginUserButton);
//		js.executeScript("document.querySelector('#navUserMenu>div.sub_nav').setAttribute('style','display: block;');");
		getDriver().findElement(logout_locator).click();
		WebDriverWait waitA = new WebDriverWait(getDriver(), 10);
		waitA.until(ExpectedConditions.visibilityOfElementLocated(By.id("nblogin")));
	}
}
