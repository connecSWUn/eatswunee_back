package com.swulab.eatswunee.domain.recruit.adapter.out.persistence;

import com.swulab.eatswunee.domain.recruit.adapter.out.persistence.jpa.model.RecruitJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitJpaRepository extends JpaRepository<RecruitJpaEntity, Long> {

  @Override
  boolean existsById(Long recruitId);
}
