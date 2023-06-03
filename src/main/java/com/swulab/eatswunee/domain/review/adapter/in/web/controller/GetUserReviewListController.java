package com.swulab.eatswunee.domain.review.adapter.in.web.controller;

import com.swulab.eatswunee.domain.review.adapter.in.web.dto.response.GetUserReviewListResponse;
import com.swulab.eatswunee.domain.review.application.port.in.GetUserReviewListUseCase;
import com.swulab.eatswunee.domain.review.application.port.in.command.GetUserReviewCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import com.swulab.eatswunee.global.common.application.port.in.GetImageUrlUseCase;
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
  private final GetImageUrlUseCase getImageUrlUseCase;

  @GetMapping("/mypage/reviews/{userId}")
  public ResponseEntity getUserReviewList(@PathVariable Long userId) {

    List<GetUserReviewCommand> commands = getUserReviewListUseCase.getUserReviewList(userId);
    commands.stream().forEach(command -> command.mapToUrl(getImageUrlUseCase.getImageUrl(command.getReviewImageUrl())));
    GetUserReviewListResponse response = new GetUserReviewListResponse(commands);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }




}
