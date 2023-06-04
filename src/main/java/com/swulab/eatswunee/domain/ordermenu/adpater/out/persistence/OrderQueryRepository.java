package com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence;

import static com.swulab.eatswunee.domain.menu.adapter.out.persistence.jpa.model.QMenuJpaEntity.menuJpaEntity;
import static com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.QOrderJpaEntity.orderJpaEntity;
import static com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.QOrderMenuJpaEntity.orderMenuJpaEntity;
import static com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.model.QRestaurantJpaEntity.restaurantJpaEntity;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.OrderJpaEntity;
import com.swulab.eatswunee.domain.order.application.port.out.command.FindNowOrderCommand;
import com.swulab.eatswunee.domain.order.domain.model.OrderStatus;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderQueryRepository {

  private final JPAQueryFactory jpaQueryFactory;

  public List<OrderJpaEntity> findAllOrderByUserId(Long userId) {
    return jpaQueryFactory
        .selectFrom(orderJpaEntity)
        .where(orderJpaEntity.userJpaEntity.userId.eq(userId))
        .fetch();
  }


  public List<FindNowOrderCommand> findNowOrderCommand(Long userId) {
    return jpaQueryFactory
        .select(Projections.constructor(FindNowOrderCommand.class,
            orderJpaEntity.orderId,
            orderJpaEntity.orderNum,
            orderMenuJpaEntity.menuJpaEntity.restaurantJpaEntity.restaurantId
            ))
        .from(orderMenuJpaEntity)
        .join(orderMenuJpaEntity.orderJpaEntity, orderJpaEntity)
        .join(orderMenuJpaEntity.menuJpaEntity, menuJpaEntity)
        .join(menuJpaEntity.restaurantJpaEntity, restaurantJpaEntity)
        .where(
            orderJpaEntity.userJpaEntity.userId.eq(userId),
            orderJpaEntity.orderStatus.eq(OrderStatus.ONGOING)
        )
        .fetch();
  }


}
