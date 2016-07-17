package page;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PageObject {
	WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = driver;
	};

	WebDriver getDriver() {
		return this.driver;
	}

	public void checkAllLinks() {
		WebDriver driver = getDriver();
		List<WebElement> findElements = driver.findElements(By.tagName("a"));
		for (WebElement link : findElements) {
			String url = link.getAttribute("href");
			verifyLinkActive(url);

		}
	}

	private void verifyLinkActive(String strURL) {
		try {
			URL url = new URL(strURL);
			HttpURLConnection httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setConnectTimeout(3000);
			httpurlconnection.connect();

			if (httpurlconnection.getResponseCode() == 200) {
				System.out.println(strURL + "-" + httpurlconnection.getResponseMessage());
			} else if (httpurlconnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(strURL + "-" + httpurlconnection.getResponseMessage());
			} else {
				System.out.println(strURL + "-" + httpurlconnection.getResponseMessage());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
