package com.swulab.eatswunee.domain.user.adapter.out.persistence;

import com.swulab.eatswunee.domain.user.domain.model.User;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.UserJpaEntity;

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
