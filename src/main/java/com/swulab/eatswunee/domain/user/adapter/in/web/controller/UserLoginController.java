package com.swulab.eatswunee.domain.user.adapter.in.web.controller;

import com.swulab.eatswunee.domain.user.adapter.in.web.dto.request.UserLoginRequest;
import com.swulab.eatswunee.domain.user.application.port.in.UserLoginUseCase;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import com.swulab.eatswunee.global.common.jwt.dto.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserLoginController {

  private final UserLoginUseCase userLoginUsecase;

  @PostMapping("/login/user")
  public ResponseEntity userLogin(@RequestBody UserLoginRequest userLoginRequest) {

    TokenInfo tokenInfo = userLoginUsecase.userLogin(userLoginRequest.getLoginId(),
        userLoginRequest.getPassword());

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(tokenInfo));
  }

}
