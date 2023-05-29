package com.swulab.eatswunee.domain.user.adapter.out.persistence;

import com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {

  @Override
  Optional<UserJpaEntity> findById(Long userId);

  UserJpaEntity findByLoginId(String loginId);

  boolean existsByLoginId(String loginId);
}
