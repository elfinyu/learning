package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.management.MXBean;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="movie")
public class Movie {

	protected static final SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	protected static final SimpleDateFormat yearOnly = new SimpleDateFormat("yyyy");
	
	private String name;
	private String releasedate;
	private int id;
	private String releaseCountry;
	private int duration_mins;
	
	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	
	
	public String getReleasedate() {
		return releasedate;
	}

	@XmlElement
	public void setReleasedate(String releaseDateString) {
		this.releasedate = releaseDateString;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	
	

	public int getDuration_mins() {
		return duration_mins;
	}

	@XmlElement
	public void setDuration_mins(int duration_mins) {
		this.duration_mins = duration_mins;
	}

	public String getReleaseCountry() {
		return releaseCountry;
	}

	@XmlElement
	public void setReleaseCountry(String releaseCountry) {
		this.releaseCountry = releaseCountry;
	}
	
	
	
	
	
}
