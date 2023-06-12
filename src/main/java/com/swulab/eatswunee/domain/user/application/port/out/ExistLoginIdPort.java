package com.swulab.eatswunee.domain.user.application.port.out;

import com.swulab.eatswunee.domain.user.application.port.in.command.CheckDuplicatedCommand;

public interface ExistLoginIdPort {

  CheckDuplicatedCommand existLoginId(String loginId);

}
