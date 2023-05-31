package com.swulab.eatswunee.domain.review.application.port.in;

import com.swulab.eatswunee.domain.user.adapter.in.web.dto.request.AddReviewRequest;

public interface AddReviewUseCase {

  Long addReview(Long userId, AddReviewRequest request);

}
