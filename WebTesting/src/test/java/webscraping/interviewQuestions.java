package webscraping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class interviewQuestions {
	
	WebDriver driver;
	PrintStream out;
	
	@BeforeTest
	public void init(){
		System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test
	public void getQuestionText(){
		
		//out=System.out;
		try {
			out=new PrintStream(new File("question2.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String strUrl="http://toolsqa.com/selenium-webdriver/selenium-interview-questions-part-1/";
		getQuestion(driver,strUrl,out);	
		
		strUrl="http://toolsqa.com/selenium-webdriver/selenium-interview-questions-part-2/";
		getQuestion(driver,strUrl,out);	
	}
	
	public void getQuestion(WebDriver driver,String url, PrintStream out){
		driver.get(url);
		//String xpathExpression="//div[@class='wf-cell wf-span-8 wpb_column column_container ']//p/strong[contains(text(),'Ques')]/..";
		String xpathExpression="//div[@class='wf-cell wf-span-8 wpb_column column_container ']//p/strong/..";
		List<WebElement> contentsList=driver.findElements(By.xpath(xpathExpression));
		for(WebElement currElement:contentsList){
			out.println(currElement.getText());
		}		
	}
	
	@AfterTest
	public void destroy(){
		if(driver!=null){
			driver.quit();
		}
	}
}
