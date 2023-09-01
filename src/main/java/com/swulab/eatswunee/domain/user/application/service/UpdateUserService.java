package com.swulab.eatswunee.domain.user.application.service;

import com.swulab.eatswunee.domain.user.application.port.in.UpdateUserUseCase;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.domain.user.application.port.out.SaveUserPort;
import com.swulab.eatswunee.domain.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserService implements UpdateUserUseCase {

  private final FindUserPort findUserPort;
  private final SaveUserPort saveUserPort;

  @Override
  public void updateUserProfileUrl(Long userId, String fileName) {
    User user = findUserPort.findUser(userId);
    user.changeProfileImage(fileName);
    saveUserPort.saveUser(user);
  }
}
