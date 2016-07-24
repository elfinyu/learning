package webscraping;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumInterview {

	private static PrintStream out = null;

	public static void main(String args[]) throws IOException {
		WebDriver driver = null;
		out  = new PrintStream(new File("questions.txt"));
//		out = System.out;
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\developmentStack\\chromedriver\\chromedriver.exe");

			driver = new ChromeDriver();
			String url = "http://toolsqa.com/selenium-webdriver/selenium-interview-questions-part-1/";
			getQuestions(driver,url,out);
			
			url = "http://toolsqa.com/selenium-webdriver/selenium-interview-questions-part-2/";
			getQuestions(driver, url,out);
			
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.close();
			}
			if(out != null){
				out.flush();
				out.close();
			}
		}

	}

	private static void getQuestions(WebDriver driver, String url, PrintStream out) {
		
		driver.get(url);

		List<WebElement> questionList = driver.findElements(By.xpath(
				"//*[@class='wf-cell wf-span-8 wpb_column column_container ']//p/strong[contains(text(),'Ques')]/.."));
		System.out.println("size : " + questionList.size());
		for (WebElement element : questionList) {
			out.println(element.getText());
		}
	}
}
