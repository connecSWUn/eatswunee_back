package com.swulab.eatswunee.domain.user.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

  private Long userId;
  private String name;
  private String profileUrl;

  @Builder
  public User(Long userId, String name, String profileUrl) {
    this.userId = userId;
    this.name = name;
    this.profileUrl = profileUrl;
  }
}
