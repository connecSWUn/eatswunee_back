package com.swulab.eatswunee.domain.review.adapter.out.persistence;

import static com.swulab.eatswunee.domain.review.adapter.out.persistence.jpa.model.QReviewJpaEntity.reviewJpaEntity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ReviewQueryRepository {

  private final JPAQueryFactory queryFactory;

  public List<Integer> findMenuRatingByMenuId(Long menuId) {
    return queryFactory
        .select(
            reviewJpaEntity.score
        )
        .from(reviewJpaEntity)
        .where(eqMenuId(menuId))
        .fetch();
  }

  private BooleanExpression eqMenuId(Long menuId) {
    log.info("[findMenuRatingByMenuId] menuId : {}", menuId);
    return menuId != null ? reviewJpaEntity.menuJpaEntity.menuId.eq(menuId) : null;
  }


}
