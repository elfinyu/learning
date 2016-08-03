package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public static final DriverFactory INSTANCE = new DriverFactory();
	public DriverType type;
	//private DriverType type;
	
	private DriverFactory(){
		//read a property file to determine the driver type and set the type
		
	}
	
	public WebDriver createDriver(DriverType type){
		//base on type create the correct driver
		if(type.equals(DriverType.CHROME)){
			createChromeDriver();
		}else if(type.equals(DriverType.FIREFOX)){
			createFireFoxDriver();
		}else if(type.equals(DriverType.IEXPLORER)){
			createInternetExplorer();
		}		
		return null;
	}
	
	
	private WebDriver createChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		return new ChromeDriver();
	}
	
	private WebDriver createFireFoxDriver(){
		return new FirefoxDriver();
	}
	
	private WebDriver createInternetExplorer(){
		return new InternetExplorerDriver();
	}
	
	public enum DriverType{
		CHROME,
		FIREFOX,
		IEXPLORER
	}
	
	public DriverType getDriverType(){
		return this.type;
	}
}
