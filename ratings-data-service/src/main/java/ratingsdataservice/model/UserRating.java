package ratingsdataservice.model;

import java.util.Arrays;
import java.util.List;

public class UserRating {

  private String userId;
  private List<Rating> ratings;

  public UserRating() {
  }

  public UserRating(String userId, List<Rating> ratings) {
    this.userId = userId;
    this.ratings = ratings;
  }

  public List<Rating> getRatings() {
    return ratings;
  }

  public void setRatings(List<Rating> ratings) {
    this.ratings = ratings;
  }

  public void initData(String userId) {
    this.userId = userId;
    this.setRatings(Arrays.asList(new Rating("100", 4), new Rating("200", 3)));
  }
}
