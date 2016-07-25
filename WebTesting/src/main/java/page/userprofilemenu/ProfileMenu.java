package page.userprofilemenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.IMDBPage;

public class ProfileMenu extends IMDBPage{
	
	Logout logoutControl;
	
	public ProfileMenu(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		logoutControl = new Logout(driver);
		PageFactory.initElements(driver, logoutControl);
	}

	public Logout getLogoutControl() {
		return logoutControl;
	}

	public void setLogoutControl(Logout logoutControl) {
		this.logoutControl = logoutControl;
	}

	
//	@FindBy(xpath="//*[@id='navUserMenu']")
//	WebElement loginUserButton;
//	
//	@FindBy(xpath="//ul[@id='consumer_user_nav']//div[@class='sub_nav']//div[@class='subNavListContainer']")
//	WebElement profileMouseOnPopup;
//	
//	By logout_locator=By.xpath(".//a[@id='nblogout']");
	

//	public void logout(){
//		logout2();
//	
//	}

//	/**
//	 * logout actions selenium hover. - UNSTABLE :(
//	 */
//	private void logout1() {
//		WebDriverWait waitAA = new WebDriverWait(getDriver(), 10);
//		waitAA.until(ExpectedConditions.visibilityOfElementLocated(By.id("navUserMenu")));
//		Actions actions = new Actions(getDriver());
//		actions.moveToElement(loginUserButton);
//		
//		actions.build().perform();
//		waitAA.until(ExpectedConditions.visibilityOfElementLocated(logout_locator));
//		getDriver().findElement(logout_locator).click();
//		WebDriverWait waitA = new WebDriverWait(getDriver(), 10);
//		waitA.until(ExpectedConditions.visibilityOfElementLocated(By.id("nblogin")));
//	}
//	
//	/**
//	 * log out by setting attribute of style by javascript - STABLE :)
//	 */
//	public void logout2(){
//		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		js.executeScript("document.querySelector('#navUserMenu>div.sub_nav').setAttribute('style','display: block;');");
//		getDriver().findElement(logout_locator).click();
//		WebDriverWait waitA = new WebDriverWait(getDriver(), 10);
//		waitA.until(ExpectedConditions.visibilityOfElementLocated(By.id("nblogin")));
//	}
//	
//	/**
//	 * Log out using javascript hover - UNSTABLE :(
//	 */
//	public void logout3(){
////		JavascriptExecutor js = (JavascriptExecutor) getDriver();
////		js.executeScript("arguments[0].fireEvent('onmouseover');", loginUserButton);
//		mouseHoverJScript(loginUserButton);
//		
//		WebDriverWait waitAA = new WebDriverWait(getDriver(), 10);
//		waitAA.until(ExpectedConditions.visibilityOfElementLocated(By.id("navUserMenu")));
//		waitAA.until(ExpectedConditions.visibilityOfElementLocated(logout_locator));
//		
//		getDriver().findElement(logout_locator).click();
//		WebDriverWait waitA = new WebDriverWait(getDriver(), 10);
//		waitA.until(ExpectedConditions.visibilityOfElementLocated(By.id("nblogin")));
//	}
//	
//	public void mouseHoverJScript(WebElement HoverElement) {
//		try {
//			if (isElementPresent(HoverElement)) {
//				
//				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');"
//						+ "evObj.initEvent('mouseover', true, false); "
//						+ "arguments[0].dispatchEvent(evObj);} "
//						+ "else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
//				((JavascriptExecutor) getDriver()).executeScript(mouseOverScript, HoverElement);
//
//			} else {
//				System.out.println("Element was not visible to hover " + "\n");
//
//			}
//		} catch (StaleElementReferenceException e) {
//			System.out.println("Element with " + HoverElement
//					+ "is not attached to the page document"
//					+ e.getStackTrace());
//		} catch (NoSuchElementException e) {
//			System.out.println("Element " + HoverElement + " was not found in DOM"
//					+ e.getStackTrace());
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Error occurred while hovering"
//					+ e.getStackTrace());
//		}
//	}
//
//	public static boolean isElementPresent(WebElement element) {
//		boolean flag = false;
//		try {
//			if (element.isDisplayed()
//					|| element.isEnabled())
//				flag = true;
//		} catch (NoSuchElementException e) {
//			flag = false;
//		} catch (StaleElementReferenceException e) {
//			flag = false;
//		}
//		return flag;
//	}	
	
}
