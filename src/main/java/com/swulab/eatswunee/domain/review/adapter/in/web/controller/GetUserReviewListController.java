package com.swulab.eatswunee.domain.review.adapter.in.web.controller;

import com.swulab.eatswunee.domain.review.adapter.in.web.dto.response.GetUserReviewListResponse;
import com.swulab.eatswunee.domain.review.application.port.in.GetUserReviewListUseCase;
import com.swulab.eatswunee.domain.review.application.port.in.command.GetUserReviewCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetUserReviewListController {

  private final GetUserReviewListUseCase getUserReviewListUseCase;

  @GetMapping("/mypage/reviews/{userId}")
  public ResponseEntity getUserReviewList(@PathVariable Long userId) {

    List<GetUserReviewCommand> command = getUserReviewListUseCase.getUserReviewList(userId);
    GetUserReviewListResponse response = new GetUserReviewListResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }




}