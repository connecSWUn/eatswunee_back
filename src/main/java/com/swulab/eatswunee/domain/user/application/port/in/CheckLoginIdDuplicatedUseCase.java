package com.swulab.eatswunee.domain.user.application.port.in;

import com.swulab.eatswunee.domain.user.application.port.in.command.CheckDuplicatedCommand;

public interface CheckLoginIdDuplicatedUseCase {

  CheckDuplicatedCommand checkLoginId(String loginId);

}
