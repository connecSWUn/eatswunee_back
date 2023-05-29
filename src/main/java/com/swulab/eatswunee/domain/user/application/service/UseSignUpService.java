package com.swulab.eatswunee.domain.user.application.service;

import com.swulab.eatswunee.domain.user.application.port.in.UserSignUpUseCase;
import com.swulab.eatswunee.domain.user.application.port.in.command.UserSignUpCommand;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.domain.user.application.port.out.SaveUserPort;
import com.swulab.eatswunee.domain.user.domain.model.User;
import com.swulab.eatswunee.domain.user.exception.UserAlreadyExistsException;
import com.swulab.eatswunee.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UseSignUpService implements UserSignUpUseCase {

  private final PasswordEncoder passwordEncoder;
  private final FindUserPort findUserPort;
  private final SaveUserPort saveUserPort;

  @Override
  public Long signUp(UserSignUpCommand command) {

    //TODO Optional로 변환
//    User findUser = findUserPort.findUserByLoginId(command.getLoginId());
    if (findUserPort.isExistsByLoginId(command.getLoginId())) {
      // 예외처리
      throw new UserAlreadyExistsException(ErrorCode.USER_ALREADY_EXISTS, "이미 존재하는 회원입니다.");
    }

    User user = User.builder()
        .name(command.getNickname())
        .profileUrl(command.getImage())
        .password(command.getPassword())
        .loginId(command.getLoginId())
        .role(command.getRole()).build();

    return Long.parseLong(saveUserPort.saveUser(user).toString());
  }
}
