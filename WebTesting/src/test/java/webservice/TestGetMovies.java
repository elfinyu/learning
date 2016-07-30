package webservice;

import static com.jayway.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class TestGetMovies {

	@Test
	public void getMovieByID() {
		String asString = given().auth().basic("user1", "secret1").when().get("movie/1").asString();
		System.out.println(asString);
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
