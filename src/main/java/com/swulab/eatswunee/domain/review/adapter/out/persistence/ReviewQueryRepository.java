package com.swulab.eatswunee.domain.review.adapter.out.persistence;

import static com.swulab.eatswunee.domain.menu.adapter.out.persistence.jpa.model.QMenuJpaEntity.menuJpaEntity;
import static com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.QOrderMenuJpaEntity.orderMenuJpaEntity;
import static com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.model.QRestaurantJpaEntity.restaurantJpaEntity;
import static com.swulab.eatswunee.domain.review.adapter.out.persistence.jpa.model.QReviewJpaEntity.reviewJpaEntity;
import static com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.QUserJpaEntity.userJpaEntity;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.review.application.port.out.command.FindUserReviewCommand;
import com.swulab.eatswunee.domain.review.application.port.out.command.ReviewAndUserCommand;
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

  public List<ReviewAndUserCommand> findMenuReviewListByMenuId(Long menuId) {

    return queryFactory
        .select(Projections.constructor(ReviewAndUserCommand.class,
            reviewJpaEntity.reviewId,
            reviewJpaEntity.score,
            reviewJpaEntity.content,
            reviewJpaEntity.createdAt,
            reviewJpaEntity.editedAt,
            reviewJpaEntity.reviewImg,
            reviewJpaEntity.userJpaEntity.userId,
            reviewJpaEntity.userJpaEntity.name,
            reviewJpaEntity.userJpaEntity.profileUrl
            ))
        .from(reviewJpaEntity)
        .join(reviewJpaEntity.userJpaEntity, userJpaEntity)
        .where(eqMenuId(menuId))
        .fetch();
  }

  public List<Long> findReviewByOrderMenuId(Long orderMenuId) {

    return queryFactory
        .select(
            reviewJpaEntity.orderMenuEntity.orderMenuId
        )
        .from(reviewJpaEntity)
        .join(reviewJpaEntity.orderMenuEntity, orderMenuJpaEntity)
        .where(
            eqOrderMenuId(orderMenuId)
        )
        .fetch();
  }

  public List<FindUserReviewCommand> findUserReviewListByUserId(Long userId) {

    return queryFactory
        .select(
            Projections.constructor(FindUserReviewCommand.class,
            reviewJpaEntity.reviewId,
            reviewJpaEntity.menuJpaEntity.restaurantJpaEntity.name.as("restaurantName"),
            reviewJpaEntity.menuJpaEntity.name.as("menuName"),
            reviewJpaEntity.reviewImg,
            reviewJpaEntity.score.as("reviewRating"),
            reviewJpaEntity.content.as("reviewContent"),
            reviewJpaEntity.createdAt.as("reviewCreatedAt"))
        )
        .from(reviewJpaEntity)
        .join(reviewJpaEntity.userJpaEntity, userJpaEntity)
        .join(reviewJpaEntity.menuJpaEntity, menuJpaEntity)
        .join(menuJpaEntity.restaurantJpaEntity, restaurantJpaEntity)
        .where(
            reviewJpaEntity.userJpaEntity.userId.eq(userId)
        )
        .fetch();
  }

  private BooleanExpression eqMenuId(Long menuId) {
    log.info("[findMenuRatingByMenuId] menuId : {}", menuId);
    return menuId != null ? reviewJpaEntity.menuJpaEntity.menuId.eq(menuId) : null;
  }

  private BooleanExpression eqOrderMenuId(Long orderMenuId) {
    log.info("[findReviewByOrderMenuId] orderMenuId : {}", orderMenuId);
    return orderMenuId != null ? reviewJpaEntity.orderMenuEntity.orderMenuId.eq(orderMenuId) : null;
  }


}
