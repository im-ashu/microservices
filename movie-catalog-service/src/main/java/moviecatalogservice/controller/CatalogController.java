package moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;
import moviecatalogservice.model.CatalogItem;
import moviecatalogservice.model.Movie;
import moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

  @Autowired
  private RestTemplate restTemplate;

  @RequestMapping(value = "/{userId}")
  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
    UserRating userRatings = restTemplate.getForObject(
        "http://RATINGS-DATA-SERVICE/ratings/user/" + userId, UserRating.class);
    return userRatings.getRatings().stream().map(rating -> {
      Movie movie = restTemplate.getForObject(
          "http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(),
          Movie.class);
      return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
    }).collect(Collectors.toList());
  }
}
