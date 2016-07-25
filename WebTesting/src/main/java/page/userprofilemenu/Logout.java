package page.userprofilemenu;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.IMDBPage;

public class Logout extends IMDBPage {
	public Logout(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void logout(){
		logout3();
	}
	
	@FindBy(xpath="//*[@id='navUserMenu']")
	WebElement loginUserButton;
	
	@FindBy(xpath="//ul[@id='consumer_user_nav']//div[@class='sub_nav']//div[@class='subNavListContainer']")
	WebElement profileMouseOnPopup;
	
	By logout_locator=By.xpath(".//a[@id='nblogout']");
	
	/**
	 * logout actions selenium hover. - UNSTABLE :(
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
	 * log out by setting attribute of style by javascript - STABLE :)
	 */
	private void logout2(){
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("document.querySelector('#navUserMenu>div.sub_nav').setAttribute('style','display: block;');");
		getDriver().findElement(logout_locator).click();
		WebDriverWait waitA = new WebDriverWait(getDriver(), 10);
		waitA.until(ExpectedConditions.visibilityOfElementLocated(By.id("nblogin")));
	}
	/*Extract as mouseoverDisplay method*/
	private void logout3(){
		String strHoverLocator="#navUserMenu>div.sub_nav";
		mouseoverDisplay(strHoverLocator);
		getDriver().findElement(logout_locator).click();
		WebDriverWait waitA = new WebDriverWait(getDriver(), 10);
		waitA.until(ExpectedConditions.visibilityOfElementLocated(By.id("nblogin")));		
	}
	
	/**
	 * Log out using javascript hover - UNSTABLE :(
	 */
	private void logout4(){
//		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		js.executeScript("arguments[0].fireEvent('onmouseover');", loginUserButton);
		mouseHoverJScript(loginUserButton);
		
		WebDriverWait waitAA = new WebDriverWait(getDriver(), 10);
		waitAA.until(ExpectedConditions.visibilityOfElementLocated(By.id("navUserMenu")));
		waitAA.until(ExpectedConditions.visibilityOfElementLocated(logout_locator));
		
		getDriver().findElement(logout_locator).click();
		WebDriverWait waitA = new WebDriverWait(getDriver(), 10);
		waitA.until(ExpectedConditions.visibilityOfElementLocated(By.id("nblogin")));
	}
	
	private void mouseHoverJScript(WebElement HoverElement) {
		try {
			if (isElementPresent(HoverElement)) {
				
				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');"
						+ "evObj.initEvent('mouseover', true, false); "
						+ "arguments[0].dispatchEvent(evObj);} "
						+ "else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				((JavascriptExecutor) getDriver()).executeScript(mouseOverScript, HoverElement);

			} else {
				System.out.println("Element was not visible to hover " + "\n");

			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + HoverElement
					+ "is not attached to the page document"
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + HoverElement + " was not found in DOM"
					+ e.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while hovering"
					+ e.getStackTrace());
		}
	}

	private static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()
					|| element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}

}
