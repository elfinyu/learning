package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends PageObject {

	public ResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(tagName="tr")
	List<WebElement> resultRows;
	
	public void getSearchedResult(){
		System.out.println("Result rows: "+ resultRows.size());
		for(WebElement result:resultRows){
			System.out.println(result.getText());
		}
	}
}
