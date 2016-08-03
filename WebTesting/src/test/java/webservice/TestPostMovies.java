package webservice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;

import data.Movie;

public class TestPostMovies {
	
	
	@BeforeClass
	public void init(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;		
	}
	
	@Test
	public void postMovieTest(){
		/*BDD Approach*
		 * 
		 */
		String jsonMsg="{\"name\": \"TestMovie\","
				+ "\"id\": 3,\"releaseCountry\": \"CN\","
				+ "\"duration_mins\": 138,"
				+ "\"releaseDate\": \"31/07/2016\"}";
		RestAssured
		.given()
			.authentication().basic("user1", "secret1")
			.contentType("application/json")
			.body(jsonMsg)
		.when()
			.post("/movie/create")
		.then()
			.log().body()
			.statusCode(200);
	}
	
	
	@Test
	public void postMovieTestNew(){
		/*BDD Approach*
		 * 
		 */
		Movie abc = new Movie();
		abc.setName("add2");
		abc.setId(4);
		abc.setReleaseCountry("singapore");
		abc.setReleasedate("28/08/2016");
		abc.setDuration_mins(123);
		
		RestAssured
		.given()
			.authentication().basic("user1", "secret1")
			.contentType("application/json")
			.body(abc)
		.when()
			//.post("/movie/create")
		.then()
			.log().body()
			.statusCode(200);
	}
	
	@AfterClass
	public void tearDown(){
		
	}
}
