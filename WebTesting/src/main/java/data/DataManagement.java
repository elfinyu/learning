package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class DataManagement {

	private static DataManagement instance = null;
	private List<Movie> movies;

	private DataManagement() {
		try {
			movies = parseCSVToBeanList();
			for (Movie movie : movies) {
				System.out.println(movie.getName());
				SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				System.out.println(fmt.format(movie.getReleaseDateObject()));
				System.out.println(movie.getReleaseCountry());
				System.out.println(movie.getDuration_mins());
				System.out.println(movie.getId());
				System.out.println(movie.getTitle());
				System.out.println(movie.getDurationHMins());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<Movie> parseCSVToBeanList() throws IOException, URISyntaxException {

		HeaderColumnNameTranslateMappingStrategy<Movie> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<Movie>();
		beanStrategy.setType(Movie.class);

		Map<String, String> columnMapping = new HashMap<String, String>();
		//map the key of csv files with the key of movie list keys
		columnMapping.put("id", "id");
		columnMapping.put("title", "name");
		columnMapping.put("date", "releasedate");	
		columnMapping.put("release_country", "releaseCountry");
		columnMapping.put("duration_mins", "duration_mins");
		

		beanStrategy.setColumnMapping(columnMapping);

		CsvToBean<Movie> csvToBean = new CsvToBean<Movie>();
		URL systemResource = ClassLoader.getSystemResource("movies.csv");
		File file = new File(systemResource.toURI());
		CSVReader reader = new CSVReader(new FileReader(file));
		List<Movie> emps = csvToBean.parse(beanStrategy, reader);
		return emps;
	}
	
	public Movie getMovieByID(int id){
		for(Movie aMovie : this.movies){
			if(aMovie.getId() == id) return aMovie;
		}
		return null;
	}
	
	//singleton pattern
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

}
