package com.swulab.eatswunee.domain.user.adapter.in.web.controller;

import com.swulab.eatswunee.domain.user.adapter.in.web.dto.response.CheckNicknameResponse;
import com.swulab.eatswunee.domain.user.application.port.in.CheckNicknameUseCase;
import com.swulab.eatswunee.domain.user.application.port.in.command.CheckNicknameCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CheckNicknameController {

  private final CheckNicknameUseCase checkNicknameUseCase;

  @GetMapping("/mypage/duplicated/{nickname}")
  public ResponseEntity checkNickname(String nickname) {

    CheckNicknameCommand command = checkNicknameUseCase.checkNickname(nickname);
    CheckNicknameResponse response = new CheckNicknameResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }

}
