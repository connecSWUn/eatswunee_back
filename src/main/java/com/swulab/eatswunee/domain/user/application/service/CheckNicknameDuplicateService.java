package com.swulab.eatswunee.domain.user.application.service;

import com.swulab.eatswunee.domain.user.application.port.in.CheckNicknameUseCase;
import com.swulab.eatswunee.domain.user.application.port.in.command.CheckDuplicatedCommand;
import com.swulab.eatswunee.domain.user.application.port.out.FindCheckNicknamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckNicknameDuplicateService implements CheckNicknameUseCase {


  private final FindCheckNicknamePort findCheckNicknamePort;

  @Override
  public CheckDuplicatedCommand checkNickname(String nickname) {

    Boolean isDuplicated = findCheckNicknamePort.findCheckNicknamePort(nickname);
    return new CheckDuplicatedCommand(isDuplicated);
  }

}
