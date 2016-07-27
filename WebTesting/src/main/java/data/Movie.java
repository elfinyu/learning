package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Movie {

	private static final SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	private static final SimpleDateFormat yearOnly = new SimpleDateFormat("yyyy");
	
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
	
	public String getTitle(){
		return this.name + " ("+yearOnly.format(releasedate)+")";
	}
	
	public String getDurationHMins(){
		StringBuilder builder = new StringBuilder();
		long hour = TimeUnit.MINUTES.toHours(duration_mins);
		builder.append(hour);
		builder.append("h ");
		long min = duration_mins - TimeUnit.HOURS.toMinutes(hour);
		builder.append(min);
		builder.append("min");
		return builder.toString();
		
		
	}
	
	
	
}
