package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Movie {

	protected static final SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	protected static final SimpleDateFormat yearOnly = new SimpleDateFormat("yyyy");
	
	private String name;
	private Date releasedate;
	private int id;
	private String releaseCountry;
	private int duration_mins;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public int getDuration_mins() {
		return duration_mins;
	}

	public void setDuration_mins(int duration_mins) {
		this.duration_mins = duration_mins;
	}

	public String getReleaseCountry() {
		return releaseCountry;
	}

	public void setReleaseCountry(String releaseCountry) {
		this.releaseCountry = releaseCountry;
	}
	
	
	
	
	
}
