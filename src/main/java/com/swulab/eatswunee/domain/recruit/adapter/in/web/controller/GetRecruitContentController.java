package com.swulab.eatswunee.domain.recruit.adapter.in.web.controller;


import com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.response.RecruitContentResponse;
import com.swulab.eatswunee.domain.recruit.application.port.in.GetRecruitContentUseCase;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import com.swulab.eatswunee.global.common.application.port.in.GetImageUrlUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetRecruitContentController {

  private final GetRecruitContentUseCase getRecruitContentUseCase;
  private final GetImageUrlUseCase getImageUrlUseCase;

  @GetMapping("/recruit/{postId}")
  public ResponseEntity getRecruitContent(@AuthenticationPrincipal UserDetails userDetails, @PathVariable String postId) {

    Recruit recruit = getRecruitContentUseCase.getRecruitContent(Long.parseLong(postId));
    recruit.getUser().mapImageToUrl(getImageUrlUseCase.getImageUrl("user_profile/" + recruit.getUser().getProfileUrl()));
    RecruitContentResponse response = new RecruitContentResponse(recruit, Long.parseLong(userDetails.getUsername()));

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }

}
