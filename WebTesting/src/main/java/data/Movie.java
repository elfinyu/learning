package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {

	private static final SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	private String name;
	private Date releasedate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getReleaseDateObject() {
		return releasedate;
	}
	
	public String getReleaseDate() {
		return fmt.format(releasedate);
	}

	public void setReleaseDate(String releaseDateString) {
		try {
			this.releasedate = fmt.parse(releaseDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
