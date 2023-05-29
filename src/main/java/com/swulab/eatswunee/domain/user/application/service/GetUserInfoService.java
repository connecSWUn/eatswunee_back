package com.swulab.eatswunee.domain.user.application.service;

import com.swulab.eatswunee.domain.user.application.port.in.GetUserInfoUseCase;
import com.swulab.eatswunee.domain.user.application.port.in.command.GetUserInfoCommand;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.domain.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserInfoService implements GetUserInfoUseCase {

  private final FindUserPort findUserPort;

  @Override
  public GetUserInfoCommand getUserInfo(Long userId) {

    User user = findUserPort.findUser(userId);

    return new GetUserInfoCommand(user);
  }

}
