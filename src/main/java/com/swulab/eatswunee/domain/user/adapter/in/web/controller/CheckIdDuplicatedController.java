package com.swulab.eatswunee.domain.user.adapter.in.web.controller;

import com.swulab.eatswunee.domain.user.adapter.in.web.dto.response.CheckDeuplicatedResponse;
import com.swulab.eatswunee.domain.user.application.port.in.CheckLoginIdDuplicatedUseCase;
import com.swulab.eatswunee.domain.user.application.port.in.command.CheckDuplicatedCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CheckIdDuplicatedController {

  private final CheckLoginIdDuplicatedUseCase checkLoginIdDuplicatedUseCase;

  @GetMapping("/mypage/duplicated/loginId/{loginId}")
  public ResponseEntity checkLoginId(@PathVariable String loginId) {

    CheckDuplicatedCommand command = checkLoginIdDuplicatedUseCase.checkLoginId(loginId);
    CheckDeuplicatedResponse response = new CheckDeuplicatedResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }
}
