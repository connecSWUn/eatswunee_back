package com.swulab.eatswunee.domain.user.application.port.in.command;

import com.swulab.eatswunee.domain.user.domain.model.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetUserInfoCommand {

  private Long userId;
  private String userProfileUrl;
  private String userName;

  public GetUserInfoCommand(User user) {
    this.userId = user.getUserId();
    this.userProfileUrl = user.getProfileUrl();
    this.userName = user.getName();
  }

  public void mapImageToUrl(String url) {
    this.userProfileUrl = url;
  }
}
