package com.swulab.eatswunee.domain.user.application.port.in;

import com.swulab.eatswunee.domain.user.application.port.in.command.GetUserInfoCommand;

public interface GetUserInfoUseCase {

  GetUserInfoCommand getUserInfo(Long userId);

}
