package com.swulab.eatswunee.domain.review.adapter.in.web.controller;

import com.swulab.eatswunee.domain.review.adapter.in.web.dto.response.AddReviewResponse;
import com.swulab.eatswunee.domain.review.application.port.in.AddReviewUseCase;
import com.swulab.eatswunee.domain.user.adapter.in.web.dto.request.AddReviewRequest;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddReviewController {


  private final AddReviewUseCase addReviewUseCase;

  @PostMapping("/mypagae/review/save")
  public ResponseEntity addReviewUseCase(@AuthenticationPrincipal UserDetails userDetails, @RequestBody AddReviewRequest request) {

    Long reviewId = addReviewUseCase.addReview(Long.parseLong(userDetails.getUsername()), request);
    AddReviewResponse response = new AddReviewResponse(reviewId);

    return ResponseEntity.ok(SuccessResponse.create201SuccessResponse(response));
  }

}
