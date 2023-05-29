package com.swulab.eatswunee.domain.user.adapter.in.web.controller;

import com.swulab.eatswunee.domain.user.adapter.in.web.dto.request.UserSignUpRequest;
import com.swulab.eatswunee.domain.user.adapter.in.web.dto.response.UserSignUpResponse;
import com.swulab.eatswunee.domain.user.application.port.in.UserSignUpUseCase;
import com.swulab.eatswunee.domain.user.application.port.in.command.UserSignUpCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserSignUpController {


  private final UserSignUpUseCase userSignUpUseCase;


  @PostMapping("/signup/user")
  public ResponseEntity userSignUp(@RequestBody UserSignUpRequest request) {

    UserSignUpCommand command = new UserSignUpCommand(request);
    Long userId = userSignUpUseCase.signUp(command);

    UserSignUpResponse response = new UserSignUpResponse(userId);

    return ResponseEntity.ok(SuccessResponse.create201SuccessResponse(response));
  }

}
