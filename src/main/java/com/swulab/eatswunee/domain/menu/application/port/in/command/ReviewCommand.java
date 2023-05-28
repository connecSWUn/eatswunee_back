package com.swulab.eatswunee.domain.menu.application.port.in.command;

import com.swulab.eatswunee.domain.review.domain.model.Review;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewCommand {

  private Long reviewId;
  private int score;
  private String content;
  private LocalDateTime createdAt;
  private LocalDateTime editedAt;
  private String reviewImg;

  private User user;

  public ReviewCommand(Review review) {
    this.reviewId = review.getReviewId();
    this.score = review.getScore();
    this.content = review.getContent();
    this.createdAt = review.getCreatedAt();
    this.editedAt = review.getEditedAt();
    this.reviewImg = review.getReviewImg();
    this.user = review.getUser();
  }

  public void mapImageToUrl(String url) {
    this.reviewImg = url;
  }
}

