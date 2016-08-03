package rest.application;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.DataManagement;
import data.Movie;
import rest.application.exception.MovieAlreadyExist;

@RestController
@RequestMapping("/xml/movie/")
public class MovieControllerXML {

	@ResponseBody
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces= MediaType.APPLICATION_XML_VALUE)
	public Movie echo(@PathVariable(value = "id") final int id) {
//		int myId = Integer.parseInt(id);
		Movie movieByID = DataManagement.getInstance().getMovieByID(id);
		return movieByID;
	}
	
	
	@ResponseBody
	@RequestMapping(value="reset",method = RequestMethod.POST, produces= MediaType.APPLICATION_XML_VALUE)
	public void reset() {
//		int myId = Integer.parseInt(id);
		 DataManagement.getInstance().resetMovies();
		
	}
	
	@ResponseBody
	@RequestMapping(value = "all", method = RequestMethod.GET,  produces= MediaType.APPLICATION_XML_VALUE)
	public List<Movie> getMovies() {
		return DataManagement.getInstance().getMovies();
	}
	
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces= MediaType.APPLICATION_XML_VALUE)
	public Movie updateMovie(@RequestBody Movie movie){
		Movie movieByID = DataManagement.getInstance().getMovieByID(movie.getId());
		if(movieByID != null){
			throw new MovieAlreadyExist();
			
		}else{
			DataManagement.getInstance().addMovie(movie);
			return movie;
		}
		
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/updateMovieName/{id}" , method= RequestMethod.PUT, produces= MediaType.APPLICATION_XML_VALUE)
	public Movie updateMovieName(@RequestParam String name, @PathVariable int id){
		Movie movieByID = DataManagement.getInstance().getMovieByID(id);
		movieByID.setName(name);
		return movieByID;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/delete/{id}" , method= RequestMethod.DELETE, produces= MediaType.APPLICATION_XML_VALUE)
	public List<Movie> deleteMovie(@PathVariable int id){
		Movie movieByID = DataManagement.getInstance().getMovieByID(id);
		DataManagement.getInstance().deleteMovie(movieByID);
		return DataManagement.getInstance().getMovies();
	}

}
