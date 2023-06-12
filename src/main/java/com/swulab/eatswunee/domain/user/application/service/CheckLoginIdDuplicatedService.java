package com.swulab.eatswunee.domain.user.application.service;

import com.swulab.eatswunee.domain.user.application.port.in.CheckLoginIdDuplicatedUseCase;
import com.swulab.eatswunee.domain.user.application.port.in.command.CheckDuplicatedCommand;
import com.swulab.eatswunee.domain.user.application.port.out.ExistLoginIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckLoginIdDuplicatedService implements CheckLoginIdDuplicatedUseCase {

  private final ExistLoginIdPort existLoginIdPort;


  @Override
  public CheckDuplicatedCommand checkLoginId(String loginId) {

    return existLoginIdPort.existLoginId(loginId);
  }
}
