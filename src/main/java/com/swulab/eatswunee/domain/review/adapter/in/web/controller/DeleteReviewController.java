package com.swulab.eatswunee.domain.review.adapter.in.web.controller;

import com.swulab.eatswunee.domain.review.application.port.in.DeleteReviewUseCase;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteReviewController {

  private final DeleteReviewUseCase deleteReviewUseCase;
  private final FindUserPort findUserPort;

  @GetMapping("/mypage/review/delete/")
  public ResponseEntity DeleteReviewService(@AuthenticationPrincipal UserDetails userDetails, Long reviewId) {

    findUserPort.findUser(Long.parseLong(userDetails.getUsername()));
    deleteReviewUseCase.deleteReview(reviewId);
    return ResponseEntity.ok(SuccessResponse.create204SuccessResponse());
  }

}
