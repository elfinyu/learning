package core;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.PageObject;

public class Factory {
	
	public static final Factory instance = new Factory(); 

	public static <T extends PageObject> T getPage(Class<T> aClass, WebDriver driver){
		 
		if(PageObject.class.isAssignableFrom(aClass)){
			T newInstance;
			try {
				newInstance = aClass.getConstructor(WebDriver.class).newInstance(driver);
				PageFactory.initElements(driver, newInstance);
				return newInstance;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return  null;
	}
}
