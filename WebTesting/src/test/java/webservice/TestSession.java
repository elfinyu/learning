package webservice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;

public class TestSession {

	
	@BeforeClass
	public void init(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		
	}
	
	@Test
	public void test(){
		Response response = RestAssured.
		given()
		.authentication().basic("yudan", "cute")
	.when()
		.get("movie/1");
		
		Cookies detailedCookies = response.getDetailedCookies();
		Cookie cookie = detailedCookies.get("JSESSIONID");
	
		
		
		RestAssured.given().cookie(cookie)
	.when()
		.get("movie/1")
	.then()
		.log().body()	
		.statusCode(200);
	}
}
