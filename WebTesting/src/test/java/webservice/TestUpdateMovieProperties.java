package webservice;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;

public class TestUpdateMovieProperties {
	@BeforeClass
	public void init(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.authentication=RestAssured.basic("user1", "secret1");
	}
	
	@AfterTest
	public void reset(){
		RestAssured
		.given()
			
			.contentType("application/json")	
		.when()
			.post("movie/reset")
			.then()
			.log().body()
			.statusCode(200);
	}
	
	@Test
	public void updateMovieName(){
		RestAssured
			.given()
				
			.when()
				.param("name", "new name")
				.put("movie/updateMovieName/1")
			.then()
				.log().body()
				.statusCode(200)
				;
	}
	
}
