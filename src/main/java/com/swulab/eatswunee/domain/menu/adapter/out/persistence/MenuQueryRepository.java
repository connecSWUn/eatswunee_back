package com.swulab.eatswunee.domain.menu.adapter.out.persistence;

import static com.swulab.eatswunee.domain.menu.adapter.out.persistence.jpa.model.QMenuJpaEntity.menuJpaEntity;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.menu.application.port.out.command.FindMenuListCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Slf4j
public class MenuQueryRepository {

  private final JPAQueryFactory jpaQueryFactory;


  public List<FindMenuListCommand> findMenuList(Long restaurantId) {
    return jpaQueryFactory
        .select(Projections.constructor(FindMenuListCommand.class,
            menuJpaEntity.menuId,
            menuJpaEntity.restaurantJpaEntity.name.as("restaurantName"),
            menuJpaEntity.imageUrl.as("menuImg"),
            menuJpaEntity.name.as("menuName"),
            menuJpaEntity.price.as("menuPrice")
            ))
        .from(menuJpaEntity)
        .where(eqRestaurantId(restaurantId))
        .fetch();
  }

  private BooleanExpression eqRestaurantId(Long restaurantId) {
    log.info("[MenuQueryRepository] restaurantId : {}", restaurantId);
    if (restaurantId == 0) {
     return null;
    }else
      return restaurantId != null ? menuJpaEntity.restaurantJpaEntity.restaurantId.eq(restaurantId) : null;
  }



}
