package com.swulab.eatswunee.domain.user.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.user.application.port.in.command.GetUserInfoCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetUserInfoResponse {

  private Long user_id;
  private String user_profile_url;
  private String user_name;
  private String loginId;

  public GetUserInfoResponse(GetUserInfoCommand command) {
    this.user_id = command.getUserId();
    this.user_profile_url = command.getUserProfileUrl();
    this.user_name = command.getUserName();
    this.loginId = command.getLoginId();
  }
}
