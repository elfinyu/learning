package core;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	public static final DriverFactory INSTANCE = new DriverFactory();
	
	private DriverType type;
	
	private DriverFactory(){
		//read a property file to determine the driver type and set the type
	}
	
	public WebDriver createDriver(){
		//base on type create the correct driver
		return null;
	}
	
	
	private WebDriver createChromeDriver(){
		return null;
	}
	
	private WebDriver createFireFoxDriver(){
		return null;
	}
	
	private WebDriver createInternetExplorer(){
		return null;
	}
	
	private enum DriverType{
		CHROME,
		FIREFOX,
		IEXPLORER
	}
}
