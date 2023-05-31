package com.swulab.eatswunee.domain.user.application.port.in;

import com.swulab.eatswunee.domain.user.application.port.in.command.CheckNicknameCommand;

public interface CheckNicknameUseCase {

  CheckNicknameCommand checkNickname(String nickname);

}
