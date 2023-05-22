package com.swulab.eatswunee.domain.menu.application.port.in.command;

import com.swulab.eatswunee.domain.menu.domain.model.Menu;
import com.swulab.eatswunee.domain.review.domain.model.Review;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetMenuReviewListCommand {

  private Integer reviewCnt;
  private Long menuId;
  private String menuName;
  private String menuImg;
  private Double menuAvgRating;

  private ReviewRatingCommand reviewRating;
  private List<ReviewCommand> reviews;



  public GetMenuReviewListCommand(Menu menu, List<Review> reviews) {
    this.reviewCnt = reviews.size();
    this.menuId = menu.getMenuId();
    this.menuName = menu.getName();
    this.menuImg = menu.getImageUrl();

    this.menuAvgRating = calAvgRating(reviews);
    this.reviewRating = new ReviewRatingCommand(reviews);
    this.reviews = reviews.stream().map(ReviewCommand::new).toList();
  }

  private Double calAvgRating(List<Review> reviews) {
    return reviews.stream().mapToInt(Review::getScore).average().orElseGet(()->0.0);
  }

}
