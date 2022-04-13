package movieinfoservice.controller;

import movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

  @RequestMapping(value = "/{movieId}")
  public Movie getMovie(@PathVariable("movieId") String movieId) {
    return new Movie("100", "MovieName", "Description");
  }

}
