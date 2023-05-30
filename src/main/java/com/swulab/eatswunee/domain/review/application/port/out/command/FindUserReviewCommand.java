package com.swulab.eatswunee.domain.review.application.port.out.command;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FindUserReviewCommand {

  private Long reviewId;
  private String restaurantName;
  private String menuName;
  private String reviewImg;
  private int reviewRating;
  private String reviewContent;
  private LocalDateTime reviewCreatedAt;

  public FindUserReviewCommand(Long reviewId, String restaurantName, String menuName,
      String reviewImg, int reviewRating, String reviewContent,
      LocalDateTime reviewCreatedAt) {
    this.reviewId = reviewId;
    this.restaurantName = restaurantName;
    this.menuName = menuName;
    this.reviewImg = reviewImg;
    this.reviewRating = reviewRating;
    this.reviewContent = reviewContent;
    this.reviewCreatedAt = reviewCreatedAt;
  }
}
