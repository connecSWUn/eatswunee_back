package com.swulab.eatswunee.domain.recruit.adapter.out.persistence;

import static com.swulab.eatswunee.domain.recruit.adapter.out.persistence.jpa.model.QRecruitJpaEntity.recruitJpaEntity;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class RecruitQueryRepository {

  private final JPAQueryFactory queryFactory;

  public List<Recruit> findRecruitList() {

    return queryFactory
        .select(Projections.constructor(Recruit.class,
            recruitJpaEntity.recruitId,
            recruitJpaEntity.createdAt,
            recruitJpaEntity.title,
            recruitJpaEntity.status,
            recruitJpaEntity.restaurant,
            recruitJpaEntity.startTime,
            recruitJpaEntity.endTime))
        .from(recruitJpaEntity)
        .fetch();
  }

}
