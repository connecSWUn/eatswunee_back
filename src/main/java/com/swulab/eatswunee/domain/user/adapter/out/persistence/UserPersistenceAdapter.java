package com.swulab.eatswunee.domain.user.adapter.out.persistence;

import com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.domain.user.domain.model.User;
import com.swulab.eatswunee.domain.user.exception.UserNotFoundException;
import com.swulab.eatswunee.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements FindUserPort {

  private final UserJpaRepository userJpaRepository;
  private final UserMapper userMapper;

  @Override
  public User findUser(Long userId) {
    UserJpaEntity userJpaEntity = userJpaRepository.findById(userId)
        .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND, "사용자 id:" + userId + "가 존재하지 않습니다."));

    return userMapper.mapToDomainEntity(userJpaEntity);
  }

  @Override
  public User findUserByLoginId(String loginId) {

    UserJpaEntity userJpaEntity = userJpaRepository.findByLoginId(loginId);
    return userMapper.mapToDomainEntity(userJpaEntity);
  }

}
