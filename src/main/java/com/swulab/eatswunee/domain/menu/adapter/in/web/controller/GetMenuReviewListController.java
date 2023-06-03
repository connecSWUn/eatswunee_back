package com.swulab.eatswunee.domain.menu.adapter.in.web.controller;

import com.swulab.eatswunee.domain.menu.adapter.in.web.controller.dto.response.GetMenuReviewListResponse;
import com.swulab.eatswunee.domain.menu.application.port.in.GetMenuReviewListUseCase;
import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuReviewListCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import com.swulab.eatswunee.global.common.application.port.in.GetImageUrlUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetMenuReviewListController {

  private final GetMenuReviewListUseCase getMenuReviewListUseCase;
  private final GetImageUrlUseCase getImageUrlUseCase;

  @GetMapping("/menu/reviews/{menuId}")
  public ResponseEntity getMenuReviewList(@PathVariable Long menuId) {

    GetMenuReviewListCommand command = getMenuReviewListUseCase.getMenuReviewList(menuId);

    command.getReviews()
        .forEach(review -> review.mapImageToUrl(getImageUrlUseCase.getImageUrl("review_image/"+ review.getReviewImg())));

    command.mapImageToUrl(getImageUrlUseCase.getImageUrl("menu_image/" + command.getMenuImg()));

    command.getReviews()
        .forEach(review -> review.getUser().mapImageToUrl(getImageUrlUseCase.getImageUrl("user_profile/"+review.getUser().getProfileUrl())));

    GetMenuReviewListResponse response = new GetMenuReviewListResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }

}
