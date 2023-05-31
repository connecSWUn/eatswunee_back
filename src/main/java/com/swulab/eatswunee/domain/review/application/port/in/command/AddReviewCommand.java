package com.swulab.eatswunee.domain.review.application.port.in.command;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddReviewCommand {

  private Long reviewId;

  public AddReviewCommand(Long reviewId) {
    this.reviewId = reviewId;
  }
}
