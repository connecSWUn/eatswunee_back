package com.swulab.eatswunee.recruit.adapter.out.persistence;

import com.swulab.eatswunee.recruit.adapter.out.persistence.jpa.model.RecruitJpaEntity;
import com.swulab.eatswunee.recruit.domain.model.Recruit;
import com.swulab.eatswunee.user.adapter.out.persistence.UserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecruitMapper {

  private final UserMapper userMapper;

  public Recruit mapToDomainEntity(RecruitJpaEntity recruitJpaEntity) {
    return Recruit.builder()
        .recruitId(recruitJpaEntity.getRecruitId())
        .title(recruitJpaEntity.getTitle())
        .content(recruitJpaEntity.getContent())
        .createdAt(recruitJpaEntity.getCreatedAt())
        .editedAt(recruitJpaEntity.getEditedAt())
        .status(recruitJpaEntity.getStatus())
        .restaurant(recruitJpaEntity.getRestaurant())
        .days(recruitJpaEntity.getDays())
        .user(userMapper.mapToDomainEntity(recruitJpaEntity.getUserJpaEntity()))
        .build();
  }

  public RecruitJpaEntity mapToJpaEntity(Recruit recruit) {
    return RecruitJpaEntity.builder()
        .recruitId(recruit.getRecruitId())
        .title(recruit.getTitle())
        .content(recruit.getContent())
        .createdAt(recruit.getCreatedAt())
        .editedAt(recruit.getEditedAt())
        .status(recruit.getStatus())
        .restaurant(recruit.getRestaurant())
        .days(recruit.getDays())
        .userJpaEntity(userMapper.mapToJpaEntity(recruit.getUser()))
        .build();
  }

}
