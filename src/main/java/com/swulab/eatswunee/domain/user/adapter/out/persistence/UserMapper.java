package com.swulab.eatswunee.domain.user.adapter.out.persistence;

import com.swulab.eatswunee.domain.user.domain.model.User;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User mapToDomainEntity(UserJpaEntity userJpaEntity) {
    return User.builder()
        .userId(userJpaEntity.getId())
        .name(userJpaEntity.getName())
        .role(userJpaEntity.getRole())
        .loginId(userJpaEntity.getLoginId())
        .password(userJpaEntity.getPassword())
        .profileUrl(userJpaEntity.getProfileUrl())
        .fcmToken(userJpaEntity.getFcmToken())
        .build();
  }

  public UserJpaEntity mapToJpaEntity(User user) {
    return UserJpaEntity.builder()
        .id(user.getUserId())
        .name(user.getName())
        .role(user.getRole())
        .loginId(user.getLoginId())
        .password(user.getPassword())
        .profileUrl(user.getProfileUrl())
        .fcmToken(user.getFcmToken())
        .build();
  }

}
