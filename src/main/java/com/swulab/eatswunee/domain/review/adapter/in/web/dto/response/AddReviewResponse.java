package com.swulab.eatswunee.domain.review.adapter.in.web.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddReviewResponse {

  private Long review_id;

  public AddReviewResponse(Long reviewId) {
    this.review_id = reviewId;
  }
}
