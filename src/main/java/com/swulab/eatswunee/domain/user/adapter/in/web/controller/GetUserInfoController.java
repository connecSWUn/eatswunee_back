package com.swulab.eatswunee.domain.user.adapter.in.web.controller;

import com.swulab.eatswunee.domain.user.adapter.in.web.dto.response.GetUserInfoResponse;
import com.swulab.eatswunee.domain.user.application.port.in.command.GetUserInfoCommand;
import com.swulab.eatswunee.domain.user.application.port.in.GetUserInfoUseCase;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import com.swulab.eatswunee.global.common.application.port.in.GetImageUrlUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetUserInfoController {

  private final GetUserInfoUseCase getUserInfoUseCase;
  private final GetImageUrlUseCase getImageUrlUseCase;

  @GetMapping("/mypage")
  public ResponseEntity getUserInfo(@AuthenticationPrincipal UserDetails userDetails) {

    GetUserInfoCommand command = getUserInfoUseCase.getUserInfo(Long.parseLong(userDetails.getUsername()));
    command.mapImageToUrl(getImageUrlUseCase.getImageUrl("user_profile/" + command.getUserProfileUrl()));
    GetUserInfoResponse response = new GetUserInfoResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }

}
