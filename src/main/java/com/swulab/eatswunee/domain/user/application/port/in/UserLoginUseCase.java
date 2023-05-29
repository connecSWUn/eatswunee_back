package com.swulab.eatswunee.domain.user.application.port.in;

import com.swulab.eatswunee.global.common.jwt.dto.TokenInfo;

public interface UserLoginUseCase {

  TokenInfo userLogin(String memberId, String password);

}
