package data;

import java.util.concurrent.TimeUnit;

public class MoviePresentation extends Movie{

	

	private final Movie movie;

	public MoviePresentation(Movie movie){
		this.movie = movie;
	}
	
	public String getTitle(){
		return getName() + " ("+yearOnly.format(getReleasedate())+")";
	}
	
	public String getDurationHMins(){
		StringBuilder builder = new StringBuilder();
		long hour = TimeUnit.MINUTES.toHours(getDuration_mins());
		builder.append(hour);
		builder.append("h ");
		long min = getDuration_mins() - TimeUnit.HOURS.toMinutes(hour);
		builder.append(min);
		builder.append("min");
		return builder.toString();
		
		
	}
	
	public String getName() {
		return movie.getName();
	}

	public void setName(String name) {
		movie.setName(name);
	}

	public void setReleaseDate(String releaseDateString) {
		movie.setReleasedate(releaseDateString);
	}

	public int getId() {
		return movie.getId();
	}

	public void setId(int id) {
		movie.setId(id);
	}

	public void setDuration_mins(int duration_mins) {
		movie.setDuration_mins(duration_mins);
	}

	public String getReleaseCountry() {
		return movie.getReleaseCountry();
	}

	public void setReleaseCountry(String releaseCountry) {
		movie.setReleaseCountry(releaseCountry);
	}
	
	public void setType(String type){
		movie.setType(type);
	}
	
	public String getType(){
		return movie.getType();
	}
}
