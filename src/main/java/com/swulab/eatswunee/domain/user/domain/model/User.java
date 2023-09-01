package com.swulab.eatswunee.domain.user.domain.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

  private Long userId;
  private String name;

  private String profileUrl;

  private String password;
  private String loginId;

  @Enumerated(EnumType.STRING)
  private Role role;

  private String fcmToken;

  @Builder
  public User(Long userId, String name, String profileUrl, String password, String loginId,
      Role role, String fcmToken) {
    this.userId = userId;
    this.name = name;
    this.profileUrl = profileUrl;
    this.password = password;
    this.loginId = loginId;
    this.role = role;
    this.fcmToken = fcmToken;
  }


  public void changeProfileImage(String profileUrl) {
    this.profileUrl = profileUrl;
  }
  public void mapImageToUrl(String url) {
    this.profileUrl = url;
  }
}
