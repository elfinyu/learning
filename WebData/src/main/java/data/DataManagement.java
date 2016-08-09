package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class DataManagement {

	private static DataManagement instance = null;
	private List<Movie> movies;

	private DataManagement() {
		
			resetMoviesList();
			for (Movie movie : movies) {
				System.out.println(movie.getName());
//				SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				
				System.out.println(movie.getReleaseCountry());
				System.out.println(movie.getDuration_mins());
				System.out.println(movie.getId());
				System.out.println(movie.getType());
			}
			
			
		
	}

	private void resetMoviesList() {
		try {
			movies = parseCSVToBeanList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeFileMovies() {
		HeaderColumnNameTranslateMappingStrategy<Movie> beanStrategy = getStrategy();

	}

	private List<Movie> parseCSVToBeanList() throws IOException, URISyntaxException {

		HeaderColumnNameTranslateMappingStrategy<Movie> beanStrategy = getStrategy();

		CsvToBean<Movie> csvToBean = new CsvToBean<Movie>();

		File file = new File("movies.csv");
		CSVReader reader = new CSVReader(new FileReader(file));
		List<Movie> emps = csvToBean.parse(beanStrategy, reader);
		return emps;
	}

	private HeaderColumnNameTranslateMappingStrategy<Movie> getStrategy() {
		HeaderColumnNameTranslateMappingStrategy<Movie> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<Movie>();
		beanStrategy.setType(Movie.class);

		Map<String, String> columnMapping = new HashMap<String, String>();
		// map the key of csv files with the key of movie list keys
		columnMapping.put("id", "id");
		columnMapping.put("title", "name");
		columnMapping.put("date", "releasedate");
		columnMapping.put("type", "type");
		columnMapping.put("release_country", "releaseCountry");
		columnMapping.put("duration_mins", "duration_mins");

		beanStrategy.setColumnMapping(columnMapping);
		return beanStrategy;
	}

	public Movie getMovieByID(int id) {
		for (Movie aMovie : this.movies) {
			if (aMovie.getId() == id)
				return aMovie;
		}
		return null;
	}

	// singleton pattern
	public static DataManagement getInstance() {
		if (instance == null) {
			synchronized (DataManagement.class) {
				if (instance == null) {
					instance = new DataManagement();
				}
			}
		}
		return instance;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void addMovie(Movie movie) {
		Movie movieByID = getMovieByID(movie.getId());
		if (movieByID == null) {
			this.movies.add(movie);
		}

	}

	public void resetMovies() {
		resetMoviesList();
	}

	public void deleteMovie(Movie movieByID) {
		this.movies.remove(movieByID);
	}

}
