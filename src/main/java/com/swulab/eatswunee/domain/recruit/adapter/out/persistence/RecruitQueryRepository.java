package com.swulab.eatswunee.domain.recruit.adapter.out.persistence;

import static com.swulab.eatswunee.domain.recruit.adapter.out.persistence.jpa.model.QRecruitJpaEntity.recruitJpaEntity;
import static com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.QUserJpaEntity.userJpaEntity;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.recruit.adapter.out.persistence.jpa.model.RecruitJpaEntity;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Slf4j
public class RecruitQueryRepository {

  private final JPAQueryFactory queryFactory;

  public List<Recruit> findRecruitList(String category) {

    return queryFactory
        .select(Projections.constructor(Recruit.class,
            recruitJpaEntity.recruitId,
            recruitJpaEntity.title,
            recruitJpaEntity.createdAt,
            recruitJpaEntity.status,
            recruitJpaEntity.restaurant,
            recruitJpaEntity.startTime,
            recruitJpaEntity.endTime))
        .from(recruitJpaEntity)
        .where(eqRestaurant(category))
        .orderBy(recruitJpaEntity.createdAt.asc())
        .fetch();
  }


  public Optional<RecruitJpaEntity> findRecruitContent(Long recruitId){
    return Optional.ofNullable(queryFactory
        .selectFrom(recruitJpaEntity)
        .leftJoin(recruitJpaEntity.userJpaEntity, userJpaEntity)
        .where(eqRecruitId(recruitId))
        .fetchOne());
  }

  public List<Recruit> findRecruitListByUserId(Long userId, RecruitStatus recruitStatus) {

    return queryFactory
        .select(Projections.constructor(Recruit.class,
            recruitJpaEntity.recruitId,
            recruitJpaEntity.title,
            recruitJpaEntity.createdAt,
            recruitJpaEntity.status,
            recruitJpaEntity.restaurant,
            recruitJpaEntity.startTime,
            recruitJpaEntity.endTime))
        .from(recruitJpaEntity)
        .where(
            eqUserId(userId),
            eqRecruitStatus(recruitStatus)
        )
        .orderBy(recruitJpaEntity.createdAt.asc())
        .fetch();
  }


  private BooleanExpression eqRestaurant(String restaurant) {
    log.info("restaurant name: {}", restaurant);
    return restaurant != null ? recruitJpaEntity.restaurant.eq(restaurant) : null;
  }

  private BooleanExpression eqRecruitId(Long recruitId) {
    log.info("recruit id: {}", recruitId);
    return recruitId != null ? recruitJpaEntity.recruitId.eq(recruitId) : null;
  }

  private BooleanExpression eqUserId(Long userId) {
    log.info("user id: {}", userId);
    return userId != null ? recruitJpaEntity.userJpaEntity.userId.eq(userId) : null;

  }

  private BooleanExpression eqRecruitStatus(RecruitStatus recruitStatus) {
    log.info("recruitStatus : {}", recruitStatus);
    return recruitStatus != null ? recruitJpaEntity.status.eq(recruitStatus) : null;

  }
}
