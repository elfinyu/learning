package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import core.DriverFactory;
import core.DriverFactory.DriverType;

public class DriverFactoryTest {

	private WebDriver createDriver;

	@Test
	public void test(){
		DriverType driverType = DriverFactory.INSTANCE.getDriverType();
		Assert.assertEquals(driverType, DriverType.CHROME);
	}
	
	
	@Test
	public void test2(){
		 createDriver = DriverFactory.INSTANCE.createDriver();
		 Assert.assertTrue(createDriver instanceof ChromeDriver);
		
	}
	
	@Test
	public void testChrome(){
		  createDriver = DriverFactory.INSTANCE.createDriver(DriverType.CHROME);
		 Assert.assertTrue(createDriver instanceof ChromeDriver);
		
	}
	
	
	@Test
	public void testIexplore(){
		  createDriver = DriverFactory.INSTANCE.createDriver(DriverType.IEXPLORER);
		 Assert.assertTrue(createDriver instanceof InternetExplorerDriver);
		
	}
	
	@Test
	public void testFirefox(){
		  createDriver = DriverFactory.INSTANCE.createDriver(DriverType.FIREFOX);
		 Assert.assertTrue(createDriver instanceof FirefoxDriver);
		
	}
	
	@AfterMethod
	public void closeBrowser(){
		if(createDriver != null){
			createDriver.quit();
		}
	}
}
