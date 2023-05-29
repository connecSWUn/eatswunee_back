package com.swulab.eatswunee.domain.user.adapter.in.web.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSignUpRequest {

  private String loginId;
  private String nickname;
  private String password;

  public UserSignUpRequest(String loginId, String nickname, String password) {
    this.loginId = loginId;
    this.nickname = nickname;
    this.password = password;
  }
}
