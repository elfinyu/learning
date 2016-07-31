package rest.application;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.DataManagement;
import data.Movie;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@ResponseBody
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Movie echo(@PathVariable(value = "id") final int id) {
//		int myId = Integer.parseInt(id);
		Movie movieByID = DataManagement.getInstance().getMovieByID(id);
		return movieByID;
	}
	
	@ResponseBody
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public List<Movie> getMovies() {
		return DataManagement.getInstance().getMovies();
	}
	
	@ResponseBody
	@RequestMapping(value = "/create/{id]", method = RequestMethod.PUT)
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable(value = "id") final String movieName){
		return null;
	}

}
