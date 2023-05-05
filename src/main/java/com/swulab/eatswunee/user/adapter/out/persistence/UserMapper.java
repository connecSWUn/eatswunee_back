package com.swulab.eatswunee.user.adapter.out.persistence;

import com.swulab.eatswunee.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import com.swulab.eatswunee.user.domain.model.User;

public class UserMapper {

  public User mapToDomainEntity(UserJpaEntity userJpaEntity) {
    return User.builder()
        .userId(userJpaEntity.getUserId())
        .name(userJpaEntity.getName())
        .profileUrl(userJpaEntity.getProfileUrl())
        .build();
  }

  public UserJpaEntity mapToJpaEntity(User user) {
    return UserJpaEntity.builder()
        .userId(user.getUserId())
        .name(user.getName())
        .profileUrl(user.getProfileUrl())
        .build();
  }

}
