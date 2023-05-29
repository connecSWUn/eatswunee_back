package com.swulab.eatswunee.domain.user.adapter.in.web.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSignUpResponse {

  private Long userId;

  public UserSignUpResponse(Long userId) {
    this.userId = userId;
  }
}
