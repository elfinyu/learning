package core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public static final DriverFactory INSTANCE = new DriverFactory();
	private DriverType type;
	//private DriverType type;
	
	private DriverFactory(){
		//read a property file to determine the driver type and set the type
		InputStream resourceAsStream = DriverFactory.class.getClassLoader().getResourceAsStream("test.properties");
		Properties prop = new Properties();
		try {
			prop.load(resourceAsStream);
			String property = prop.getProperty("webdriver.type");
			setType(DriverType.getType(property));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebDriver createDriver(){
		return createDriver(type);
	}
	
	public WebDriver createDriver(DriverType type){
		//base on type create the correct driver
		if(type.equals(DriverType.CHROME)){
			return createChromeDriver();
		}else if(type.equals(DriverType.FIREFOX)){
			return createFireFoxDriver();
		}else if(type.equals(DriverType.IEXPLORER)){
			return createInternetExplorer();
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
		IEXPLORER;
		
		
		public static DriverType getType(String value){
			if(value.equalsIgnoreCase("chrome")) return DriverType.CHROME;
			if(value.equalsIgnoreCase("iexplore")) return DriverType.IEXPLORER;
			if(value.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
			return null;
		}
	}
	
	public DriverType getDriverType(){
		return this.getType();
	}

	public DriverType getType() {
		return type;
	}

	private void setType(DriverType type) {
		this.type = type;
	}
	
	
}
