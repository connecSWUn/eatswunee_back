package com.swulab.eatswunee.domain.review.application.port.out;

import com.swulab.eatswunee.domain.review.domain.model.Review;

public interface SaveReviewPort {

  Long saveReview(Review review);


}
