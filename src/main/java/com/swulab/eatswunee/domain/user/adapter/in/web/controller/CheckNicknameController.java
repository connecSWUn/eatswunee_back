package com.swulab.eatswunee.domain.user.adapter.in.web.controller;

import com.swulab.eatswunee.domain.user.adapter.in.web.dto.response.CheckDeuplicatedResponse;
import com.swulab.eatswunee.domain.user.application.port.in.CheckNicknameUseCase;
import com.swulab.eatswunee.domain.user.application.port.in.command.CheckDuplicatedCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CheckNicknameController {

  private final CheckNicknameUseCase checkNicknameUseCase;

  @GetMapping("/mypage/duplicated/{nickname}")
  public ResponseEntity checkNickname(@PathVariable String nickname) {

    CheckDuplicatedCommand command = checkNicknameUseCase.checkNickname(nickname);
    CheckDeuplicatedResponse response = new CheckDeuplicatedResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }

}
