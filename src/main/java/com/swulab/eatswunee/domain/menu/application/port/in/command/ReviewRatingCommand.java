package com.swulab.eatswunee.domain.menu.application.port.in.command;

import com.swulab.eatswunee.domain.review.domain.model.Review;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewRatingCommand {

  private int score5Cnt;
  private int score4Cnt;
  private int score3Cnt;
  private int score2Cnt;
  private int score1Cnt;

  public ReviewRatingCommand(List<Review> reviews) {
    this.score5Cnt = countScore(reviews, 5);
    this.score4Cnt = countScore(reviews, 4);
    this.score3Cnt = countScore(reviews, 3);
    this.score2Cnt = countScore(reviews, 2);
    this.score1Cnt = countScore(reviews, 1);
  }

  private int countScore(List<Review> reviews, int score) {
    return Long.valueOf(reviews.stream()
        .filter(review -> review.getScore() == score)
        .count()).intValue();
  }

}
