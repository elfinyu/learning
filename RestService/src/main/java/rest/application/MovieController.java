package rest.application;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/movie")
public class MovieController {
	
	Logger logger = LoggerFactory.getLogger("rest.application.MovieController");
	 
	@ResponseBody
	@RequestMapping(value = "{id}", method = RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
	public Movie getMovie(@PathVariable(value = "id") final int id) {
//		int myId = Integer.parseInt(id);
		logger.info("[getMovie] GET : get movie called");
		Movie movieByID = DataManagement.getInstance().getMovieByID(id);
		if(movieByID == null){
			logger.info("[getMovie] GET : there is no such movie with id "+ id);
		}
		return movieByID;
	}
	
	
	@ResponseBody
	@RequestMapping(value="reset",method = RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
	public void reset() {
		logger.info("[reset] POST : RESET MOVIE DATA");
		 DataManagement.getInstance().resetMovies();
		
	}
	
	@ResponseBody
	@RequestMapping(value = "all", method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> getMovies() {
		logger.info("[getMovies] GET : Get All movies called");
		return DataManagement.getInstance().getMovies();
	}
	
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	public Movie updateMovie(@RequestBody Movie movie){
		logger.info("[updateMovie] POST : Update Movie called using json called");
		Movie movieByID = DataManagement.getInstance().getMovieByID(movie.getId());
		if(movieByID != null){
			logger.info("[updateMovie] POST : Movie does not exist");
			throw new MovieAlreadyExist();
			
		}else{
			DataManagement.getInstance().addMovie(movie);
			logger.info("[updateMovie] POST : "+movie.getName() + " added");
			return movie;
		}
		
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/updateMovieName/{id}" , method= RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	public Movie updateMovieName(@RequestParam String name, @PathVariable int id){
		logger.info("[updateMovieName] PUT : Update Movie called parameters : [name:"+name+"],[id:"+id+"]");
		Movie movieByID = DataManagement.getInstance().getMovieByID(id);
		movieByID.setName(name);
		return movieByID;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/delete/{id}" , method= RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> deleteMovie(@PathVariable int id){
		logger.info("[deleteMovie] Delete : Delete Movie called parameters :[id:"+id+"]");
		Movie movieByID = DataManagement.getInstance().getMovieByID(id);
		logger.info("[deleteMovie] Delete : movie retrieve from memory "+ movieByID.getName());
		DataManagement.getInstance().deleteMovie(movieByID);
		return DataManagement.getInstance().getMovies();
	}

}
