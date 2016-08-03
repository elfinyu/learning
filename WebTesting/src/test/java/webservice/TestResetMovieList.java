package webservice;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;

public class TestResetMovieList {
	@BeforeClass
	public void init(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.authentication=RestAssured.basic("user1", "secret1");
	}
	
	@Test
	public void testReset(){
		
			String jsonMsg="{\"name\": \"TestMovie\","
					+ "\"id\": 3,\"releaseCountry\": \"CN\","
					+ "\"duration_mins\": 138,"
					+ "\"releaseDate\": \"31/07/2016\"}";
			RestAssured
			.given()
				
				.contentType("application/json")
				.body(jsonMsg)
			.when()
				.post("/movie/create")
			.then()
				.log().body()
				.statusCode(200);
			
			RestAssured
			.given()
				
			.when()
				.get("movie/all")
			.then()
				.log().body()
				.statusCode(200)
				.body("list.size()", Matchers.equalTo(3));

			RestAssured
			.given()
				
				.contentType("application/json")	
			.when()
				.post("movie/reset")
				.then()
				.log().body()
				.statusCode(200);
				
			RestAssured
			.given()
				
			.when()
				.get("movie/all")
			.then()
				.log().body()
				.statusCode(200)
				.body("list.size()", Matchers.equalTo(2));
	}
	
}
