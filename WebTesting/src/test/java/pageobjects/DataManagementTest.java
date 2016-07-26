package pageobjects;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.testng.annotations.Test;

import data.DataManagement;
import data.Movie;

public class DataManagementTest {
	List<Movie> testMovieList;
	
	@Test
	public void test() throws IOException, URISyntaxException{
		DataManagement instance = DataManagement.getInstance();
		
	}
}
