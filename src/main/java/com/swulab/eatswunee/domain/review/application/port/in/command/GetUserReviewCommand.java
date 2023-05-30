package com.swulab.eatswunee.domain.review.application.port.in.command;

import com.swulab.eatswunee.domain.review.application.port.out.command.FindUserReviewCommand;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetUserReviewCommand {

  private String restaurantName;
  private String menuName;
  private String reviewImageUrl;
  private int menuReviewRating;
  private String reviewContent;
  private LocalDateTime reviewCreatedAt;

  public GetUserReviewCommand(FindUserReviewCommand command) {
    this.restaurantName = command.getRestaurantName();
    this.menuName = command.getMenuName();
    this.reviewImageUrl = command.getReviewImg();
    this.menuReviewRating = command.getReviewRating();
    this.reviewContent = command.getReviewContent();
    this.reviewCreatedAt = command.getReviewCreatedAt();
  }
}
