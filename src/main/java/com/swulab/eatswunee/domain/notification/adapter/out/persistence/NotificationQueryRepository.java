package com.swulab.eatswunee.domain.notification.adapter.out.persistence;

import static com.swulab.eatswunee.domain.menu.adapter.out.persistence.jpa.model.QMenuJpaEntity.menuJpaEntity;
import static com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model.QNotificationJpaEntity.notificationJpaEntity;
import static com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model.QOrderNotificationJpaEntity.orderNotificationJpaEntity;
import static com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.QOrderJpaEntity.orderJpaEntity;
import static com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.QOrderMenuJpaEntity.orderMenuJpaEntity;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model.NotificationJpaEntity;
import com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model.OrderNotificationJpaEntity;
import com.swulab.eatswunee.domain.notification.application.port.in.command.GetRevenueCommand;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindIdAndIsReadCommand;
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
            orderJpaEntity.id.as("orderId"),
            orderJpaEntity.orderNum,
            orderJpaEntity.createdAt.as("orderCreatedAt"),
            orderMenuJpaEntity.menuJpaEntity.name.min().as("menuName"),
            orderMenuJpaEntity.menuCnt.sum().as("orderEtcMenuCnt")
            ))
        .from(orderMenuJpaEntity)
        .join(orderMenuJpaEntity.orderJpaEntity, orderJpaEntity)
        .join(orderMenuJpaEntity.menuJpaEntity, menuJpaEntity)
        .where(
            menuJpaEntity.restaurantJpaEntity.restaurantId.eq(restaurantId)
        )
        .groupBy(orderMenuJpaEntity.orderJpaEntity.id)
        .fetch();

  }

  public Boolean existNotificationByOrderId(Long orderId) {

    return jpaQueryFactory
        .select(orderNotificationJpaEntity.orderJpaEntity.id.as("orderId"))
        .from(notificationJpaEntity)
        .where(
            orderNotificationJpaEntity.orderJpaEntity.id.eq(orderId)
        )
        .fetch().isEmpty();

  }

  public List<FindRevenueCommand> findRevenue(Long restaurantId) {
    return jpaQueryFactory
        .select(Projections.constructor(FindRevenueCommand.class,
            orderMenuJpaEntity.orderJpaEntity.createdAt.as("orderCreatedAt"),
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

  public List<FindIdAndIsReadCommand> findOrderNotificationByOrderIdAndRestaurantId(Long orderId, Long restaurantId) {
    return jpaQueryFactory
        .select(Projections.constructor(FindIdAndIsReadCommand.class,
            orderNotificationJpaEntity.id.as("notificationId"),
            orderNotificationJpaEntity.notificationIsRead.as("isRead")
            ))
        .from(orderNotificationJpaEntity)
        .where(
            orderNotificationJpaEntity.orderJpaEntity.id.eq(orderId),
            orderNotificationJpaEntity.restaurantJpaEntity.restaurantId.eq(restaurantId)
        )
        .fetch();
  }



}
