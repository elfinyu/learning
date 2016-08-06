package webservice;

import static com.jayway.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.AuthenticationSpecification;
import com.jayway.restassured.specification.RequestSpecification;

import data.Movie;

public class TestGetMovies {

	@BeforeClass
	public void init(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
	}
	
	@Test
	public void getMovieByID() {
		String asString = given().auth().basic("user1", "secret1").when().get("movie/1").asString();
		System.out.println(asString);
	}
	
	@Test
	public void getMovieByIDXML() {
		given()
			.auth().basic("user1", "secret1").
		when()
			.contentType(ContentType.XML)
			.get("xml/movie/1").
		then()
			.log().body();
	}
	
	@Test
	public void getMovieByIDRestAssured(){
		/* 			Test step   |    Expected Result
		 * 1.      Login using	|	 User should login successful
		 * 2.      navigation to trade page | Trade page should appear 
		 */
		
		
		/* BDD behavior driven development
		 * 
		 * Given < precondition> >
		 * When < action>
		 * Then < expected result>
		*/
		
		ExtractableResponse<Response> extract = RestAssured.
		given()
			.authentication().basic("yudan", "cute")
		.when()
			.get("movie/1")
		.then()
			.log().body()	
			.statusCode(200)
			.body("name", Matchers.equalTo("Hulk"))
			.body("id",Matchers.equalTo(1))
			.body("releaseCountry", Matchers.equalTo("USA"))
			.body("duration_mins",Matchers.equalTo(138))
			.body("releasedate",Matchers.equalTo("20/06/2003"))
			.contentType(ContentType.JSON)
			.statusLine(Matchers.equalToIgnoringCase("HTTP/1.1 200 OK"))
		.extract()
			;
		
		Movie movie = extract.as(Movie.class);
		System.out.println(movie.getName());
		
	}
	
	@Test
	public void testGetAllMovies(){
		/* BDD behavior driven development
		 * 
		 * Given < precondition> >
		 * When < action>
		 * And <action 2>
		 * Then < expected result>
		 * And <expect result 2>
		 * 
		 * Given < precondition> >
		 * When < action>
		 * When <action 2>
		 * Then < expected result>
		 * Then <expect result 2>
		 *  
		*/
		ExtractableResponse<Response> extract = RestAssured.
		given()
			.authentication().basic("user1", "secret1")
		.when()
			.get("movie/all")
		.then()
			.log().body()
			.statusCode(200)
			.body("[0].name",Matchers.equalTo("Hulk"))
			.body("[0].duration_mins", Matchers.equalTo(138))
			.body("[0].id", Matchers.equalTo(1))
			.body("[0].releaseCountry",Matchers.equalTo("USA"))
			.body("[0].releasedate", Matchers.equalTo("20/06/2003"))
			.contentType(ContentType.JSON)
			.body("[1].name", Matchers.equalTo("Hulk2"))
			.body("[1].duration_mins", Matchers.equalTo(200))
			.body("list.size()", Matchers.equalTo(2))
			.body("list.size()", Matchers.greaterThanOrEqualTo(0))
			.body("list.size()", Matchers.lessThan(10))
			.extract()
			;
		
		List<Movie> as = Arrays.asList( extract.as(Movie[].class));
		for(Movie m:as){
			System.out.println(m.getName());
		}
		
//		RequestSpecification given2 = given();
//		AuthenticationSpecification authentication = given2.authentication();
//		RequestSpecification basic = authentication.basic("user", "password");
//		basic.when().
	
		
	}
	
	@AfterMethod
	public void reset(){
		RestAssured
		.given()
			.authentication().basic("user1", "secret1")
			.contentType("application/json")	
		.when()
			.post("movie/reset")
			.then()
			.log().body()
			.statusCode(200);
		RestAssured
			.given()
				.authentication().basic("user1", "secret1")
			.when()
				.get("movie/all")
			.then()
				.log().body()
				.statusCode(200)
				.body("list.size()", Matchers.equalTo(2));
	}

	@Test
	public void httpclientTest() {
		HttpURLConnection httpurlconnection = null;
		try {
			String strURL = "http://localhost:8080/movie/1";
			URL url = new URL(strURL);

			httpurlconnection = (HttpURLConnection) url.openConnection();
			String userPassword = "yudan" + ":" + "cute";
			String encoding = new sun.misc.BASE64Encoder().encode(userPassword.getBytes());
			httpurlconnection.setRequestProperty("Authorization", "Basic " + encoding);
			httpurlconnection.setConnectTimeout(3000);
			httpurlconnection.connect();

			if (httpurlconnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				System.out.println(strURL + " - " + httpurlconnection.getResponseMessage());
			} else if (httpurlconnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(
						strURL + " - " + httpurlconnection.getResponseMessage() + HttpURLConnection.HTTP_NOT_FOUND);
			} else {
				System.out.println(strURL + " - " + httpurlconnection.getResponseMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (httpurlconnection != null) {
				try {
					if(httpurlconnection.getResponseCode() == HttpURLConnection.HTTP_OK){
						printInputStream(httpurlconnection, httpurlconnection.getInputStream());
					}else{
						printInputStream(httpurlconnection, httpurlconnection.getErrorStream());
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				httpurlconnection.disconnect();
			}
		}
	}

	private void printInputStream(HttpURLConnection httpurlconnection, InputStream inputStream) {
		BufferedReader br= null;
		try {
			br = new BufferedReader(new InputStreamReader(inputStream));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
