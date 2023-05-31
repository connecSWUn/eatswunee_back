package com.swulab.eatswunee.domain.review.application.service;

import com.swulab.eatswunee.domain.review.application.port.in.DeleteReviewUseCase;
import com.swulab.eatswunee.domain.review.application.port.out.RemoveReviewPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteReviewService implements DeleteReviewUseCase {

  private final RemoveReviewPort removeReviewPort;

  @Override
  public void deleteReview(Long reviewId) {
    removeReviewPort.removeReview(reviewId);
  }

}
