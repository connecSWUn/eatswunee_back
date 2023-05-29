package com.swulab.eatswunee.domain.user.application.port.in.command;

import com.swulab.eatswunee.domain.user.adapter.in.web.dto.request.UserSignUpRequest;
import com.swulab.eatswunee.domain.user.domain.model.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSignUpCommand {

  private String loginId;
  private String nickname;
  private String password;
  private Role role;
  private String image;

  public UserSignUpCommand(UserSignUpRequest userSignUpRequest) {
    this.loginId = userSignUpRequest.getLoginId();
    this.nickname = userSignUpRequest.getNickname();
    this.password = userSignUpRequest.getPassword();
    this.role = Role.ROLE_USER;
    this.image = "user_default_profile.png";
  }
}
