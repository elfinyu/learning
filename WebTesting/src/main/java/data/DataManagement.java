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
	private List<Movie> parseCSVToBeanList;

	private DataManagement() {
		try {
			parseCSVToBeanList = parseCSVToBeanList();
			for (Movie movie : parseCSVToBeanList) {
				System.out.println(movie.getName());
				SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				System.out.println(fmt.format(movie.getReleaseDateObject()));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Movie> parseCSVToBeanList() throws IOException, URISyntaxException {

		HeaderColumnNameTranslateMappingStrategy<Movie> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<Movie>();
		beanStrategy.setType(Movie.class);

		Map<String, String> columnMapping = new HashMap<String, String>();
		//map the key of csv files with the key of movie list keys
		columnMapping.put("title", "name");
		columnMapping.put("date", "releasedate");	

		beanStrategy.setColumnMapping(columnMapping);

		CsvToBean<Movie> csvToBean = new CsvToBean<Movie>();
		URL systemResource = ClassLoader.getSystemResource("movies.csv");
		File file = new File(systemResource.toURI());
		CSVReader reader = new CSVReader(new FileReader(file));
		List<Movie> emps = csvToBean.parse(beanStrategy, reader);
		return emps;
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
