package webservice;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;

public class TestDeleteMovie {
	@BeforeClass
	public void init(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.authentication=RestAssured.basic("user1", "secret1");
	}
	
	@Test
	public void testDelete(){
		
		RestAssured
		.given()
		.when()
			.delete("/movie/delete/2")
		.then()
			.log().body()
			.statusCode(200);
		
	
		
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
