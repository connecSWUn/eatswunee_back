package com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.swulab.eatswunee.domain.menu.adapter.out.persistence.jpa.model.QMenuJpaEntity.menuJpaEntity;
import static com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.QOrderJpaEntity.orderJpaEntity;
import static com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.QOrderMenuJpaEntity.orderMenuJpaEntity;
import static com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.model.QRestaurantJpaEntity.restaurantJpaEntity;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd.UserOrderMenuCommand;
import com.swulab.eatswunee.domain.order.domain.model.OrderStatus;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.FindRestaurantOrderMenuCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class OrderMenuQueryRepository {

  private final JPAQueryFactory jpaQueryFactory;



  public List<FindRestaurantOrderMenuCommand> findOrderMenu(Long orderId) {

    return jpaQueryFactory
        .selectFrom(orderMenuJpaEntity)
        .join(orderMenuJpaEntity.menuJpaEntity, menuJpaEntity)
        .join(menuJpaEntity.restaurantJpaEntity, restaurantJpaEntity)
        .where(
            eqOrderId(orderId),
            eqOrderStatus(OrderStatus.ONGOING)
        )
        .transform(
            groupBy(orderMenuJpaEntity.menuJpaEntity.restaurantJpaEntity).list(
                Projections.constructor(FindRestaurantOrderMenuCommand.class,
                    orderMenuJpaEntity.menuJpaEntity.restaurantJpaEntity.restaurantId,
                    orderMenuJpaEntity.menuJpaEntity.restaurantJpaEntity.name.as("restaurantName"),
                    list(Projections.fields(FindRestaurantOrderMenuCommand.FindMenuCommand.class,
                        orderMenuJpaEntity.menuCnt,
                        orderMenuJpaEntity.menuJpaEntity.name.as("menuName"),
                        orderMenuJpaEntity.menuJpaEntity.price.as("menuPrice"))
                    )
                )
            )
        );
  }

  public List<UserOrderMenuCommand> findUserOrderMenuList(Long userId) {
    return jpaQueryFactory
        .select(
            Projections.constructor(UserOrderMenuCommand.class,

                orderMenuJpaEntity.orderMenuId,
                orderMenuJpaEntity.orderJpaEntity.orderCreatedAt,
                orderMenuJpaEntity.menuJpaEntity.restaurantJpaEntity.name.as("restaurantName"),
                orderMenuJpaEntity.menuJpaEntity.name.as("menuName"),
                orderMenuJpaEntity.menuJpaEntity.price.as("menuPrice"),
                orderMenuJpaEntity.menuCnt

            )
        )
        .from(orderMenuJpaEntity)
        .join(orderMenuJpaEntity.orderJpaEntity, orderJpaEntity)
        .join(orderMenuJpaEntity.menuJpaEntity, menuJpaEntity)
        .join(menuJpaEntity.restaurantJpaEntity, restaurantJpaEntity)
        .where(
            eqUserId(userId),
            eqOrderStatus(OrderStatus.COMPLETE)
        ).fetch();
  }


  private BooleanExpression eqOrderId(Long orderId) {
    log.info("[findOrderMenu] orderId : {}", orderId);
    return orderId != null ? orderMenuJpaEntity.orderJpaEntity.orderId.eq(orderId) : null;
  }

  private BooleanExpression eqOrderStatus(OrderStatus orderStatus) {
    log.info("[findOrderMenu] orderStatus : {}", orderStatus);
    return orderStatus != null ? orderMenuJpaEntity.orderJpaEntity.orderStatus.eq(orderStatus): null;
  }

  private BooleanExpression eqUserId(Long userId) {
    log.info("[findOrderMenu] userId : {}", userId);
    return userId != null ? orderMenuJpaEntity.orderJpaEntity.userJpaEntity.userId.eq(userId) : null;
  }
}
