package webservice;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;

public class TestPutMovie {
	
	@BeforeTest
	public void init(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		//RestAssured.authentication=RestAssured.form("user1", "secret1");
		RestAssured.authentication=RestAssured.basic("user1", "secret1");
	}
	
	@Test
	public void putTestUpdateMovieName(){
		System.out.println("hello");
		RestAssured
		.given()
		.when()
			.param("name","test")
			.put("movie/updateMovieName/2")
		.then().log().body();
	}
	
	@Test
	public void putTestUpdateReleaseDate(){
		/*
		 * RestAssured-BDD framework for easy testing of Rest WebService
		 * Behavior-Driven Development
		 * */
		RestAssured
		.given()
		.when()
			.param("releasedate", "11/11/2111")
			.put("movie/updateMovieReleaseDate/2")
		.then()
			.log().body();
	}
	
	@Test
	public void putTestUpdateDurationMins(){
		RestAssured
		.given()
		.when()
			.param("duration_mins", 100)
			.put("movie/updateMovieDurationMins/1")
		.then()
			.log().body();
	}
	
	@Test
	public void putTestUpdateReleaseCountry(){
		RestAssured
		.given()
		.when()
			.param("releaseCountry", "SG")
			.put("movie/updateMovieReleaseCountry/1")
		.then()
			.log().body();
	}
	
	@AfterTest
	public void resetTest(){

			RestAssured
			.given()
				//.authentication().basic("user1", "sercet1")
				.contentType("Application/JSON")
			.when()
				.post("movie/reset")
			.then()
				.log().body()
				.statusCode(200);
			
			RestAssured
			.given()
				//.authentication().basic("user1", "sercet1")
				//.contentType("application/json")
			.when()
				.get("movie/all")
			.then()
				.log().body()
				.statusCode(200)
				.body("list.size()", Matchers.equalTo(2));
	}
		
}
