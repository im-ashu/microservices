package ratingsdataservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ratingsdataservice.model.Rating;
import ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingController {

  @RequestMapping(value = "/movies/{moviesId}")
  public Rating getRating(@PathVariable("moviesId") String movieId) {
    return new Rating(movieId, 4);
  }

  @RequestMapping(value = "/user/{userId}")
  public UserRating getUserRatings(@PathVariable("userId") String userId) {
    UserRating userRating = new UserRating();
    userRating.initData(userId);
    return userRating;
  }
}
