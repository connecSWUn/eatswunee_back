package com.swulab.eatswunee.domain.user.application.port.in;

import com.swulab.eatswunee.domain.user.application.port.in.command.CheckDuplicatedCommand;

public interface CheckNicknameUseCase {

  CheckDuplicatedCommand checkNickname(String nickname);

}
