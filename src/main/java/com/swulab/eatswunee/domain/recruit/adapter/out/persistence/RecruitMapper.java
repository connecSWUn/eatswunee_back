package com.swulab.eatswunee.domain.recruit.adapter.out.persistence;

import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.recruit.adapter.out.persistence.jpa.model.RecruitJpaEntity;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RecruitMapper {

  private final UserMapper userMapper;

  public Recruit mapToDomainEntity(RecruitJpaEntity recruitJpaEntity) {
    return Recruit.builder()
        .recruitId(recruitJpaEntity.getId())
        .title(recruitJpaEntity.getTitle())
        .content(recruitJpaEntity.getContent())
        .createdAt(recruitJpaEntity.getCreatedAt())
        .editedAt(recruitJpaEntity.getEditedAt())
        .status(recruitJpaEntity.getStatus())
        .restaurant(recruitJpaEntity.getRestaurant())
        .startTime(recruitJpaEntity.getStartTime())
        .endTime(recruitJpaEntity.getEndTime())
        .user(userMapper.mapToDomainEntity(recruitJpaEntity.getUserJpaEntity()))
        .build();
  }

  public RecruitJpaEntity mapToJpaEntity(Recruit recruit) {
    return RecruitJpaEntity.builder()
        .id(recruit.getRecruitId())
        .title(recruit.getTitle())
        .content(recruit.getContent())
        .createdAt(recruit.getCreatedAt())
        .editedAt(recruit.getEditedAt())
        .status(recruit.getStatus())
        .restaurant(recruit.getRestaurant())
        .startTime(recruit.getStartTime())
        .endTime(recruit.getEndTime())
        .userJpaEntity(userMapper.mapToJpaEntity(recruit.getUser()))
        .build();
  }

}
