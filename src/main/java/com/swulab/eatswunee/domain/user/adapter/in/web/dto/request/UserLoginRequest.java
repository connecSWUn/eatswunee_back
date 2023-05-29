package com.swulab.eatswunee.domain.user.adapter.in.web.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoginRequest {

  private String loginId;
  private String password;


}
