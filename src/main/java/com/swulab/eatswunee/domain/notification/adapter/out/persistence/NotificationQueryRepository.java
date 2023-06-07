package com.swulab.eatswunee.domain.notification.adapter.out.persistence;

import static com.swulab.eatswunee.domain.menu.adapter.out.persistence.jpa.model.QMenuJpaEntity.menuJpaEntity;
import static com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model.QNotificationJpaEntity.notificationJpaEntity;
import static com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.QOrderJpaEntity.orderJpaEntity;
import static com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.QOrderMenuJpaEntity.orderMenuJpaEntity;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.notification.application.port.in.command.GetRevenueCommand;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRestaurantNotificationCommand;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRevenueCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NotificationQueryRepository {

  private final JPAQueryFactory jpaQueryFactory;

  public List<FindRestaurantNotificationCommand> findRestaurantNotification(Long restaurantId) {

    return jpaQueryFactory
        .select(Projections.constructor(FindRestaurantNotificationCommand.class,
            orderJpaEntity.orderId,
            orderJpaEntity.orderNum,
            orderJpaEntity.orderCreatedAt,
            orderMenuJpaEntity.menuJpaEntity.name.min().as("menuName"),
            orderMenuJpaEntity.menuCnt.sum().as("orderEtcMenuCnt")
            ))
        .from(orderMenuJpaEntity)
        .join(orderMenuJpaEntity.orderJpaEntity, orderJpaEntity)
        .join(orderMenuJpaEntity.menuJpaEntity, menuJpaEntity)
        .where(
            menuJpaEntity.restaurantJpaEntity.restaurantId.eq(restaurantId)
        )
        .groupBy(orderMenuJpaEntity.orderJpaEntity.orderId)
        .fetch();

  }

  public Boolean existNotificationByOrderId(Long orderId) {

    return jpaQueryFactory
        .from(notificationJpaEntity)
        .where(
            notificationJpaEntity.orderJpaEntity.orderId.eq(orderId)
        )
        .select(notificationJpaEntity.orderJpaEntity.orderId)
        .fetchFirst() != null;

  }

  public List<FindRevenueCommand> findRevenue(Long restaurantId) {
    return jpaQueryFactory
        .select(Projections.constructor(FindRevenueCommand.class,
            orderMenuJpaEntity.orderJpaEntity.orderCreatedAt,
            orderMenuJpaEntity.menuCnt,
            orderMenuJpaEntity.menuJpaEntity.price.as("menuPrice")
            )
        )
        .from(orderMenuJpaEntity)
        .join(orderMenuJpaEntity.orderJpaEntity, orderJpaEntity)
        .join(orderMenuJpaEntity.menuJpaEntity, menuJpaEntity)
        .where(
            orderMenuJpaEntity.menuJpaEntity.restaurantJpaEntity.restaurantId.eq(restaurantId)
        )
        .fetch();
  }

}
