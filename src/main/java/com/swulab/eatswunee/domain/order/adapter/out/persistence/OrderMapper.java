package com.swulab.eatswunee.domain.order.adapter.out.persistence;

import com.swulab.eatswunee.domain.order.domain.model.Order;
import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.OrderJpaEntity;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.OrderMenuMapper;
import com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence.jpa.model.OrderMenuJpaEntity;
import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenu;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.UserMapper;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderMapper {

  private final UserMapper userMapper;
  private final OrderMenuMapper orderMenuMapper;

  public Order mapToDomainEntity(OrderJpaEntity orderJpaEntity) {
    return Order.builder()
        .orderId(orderJpaEntity.getOrderId())
        .orderNum(orderJpaEntity.getOrderNum())
        .orderStatus(orderJpaEntity.getOrderStatus())
        .user(userMapper.mapToDomainEntity(orderJpaEntity.getUserJpaEntity()))
        .orderMenus(mapToDomains(orderJpaEntity.getOrderMenuJpaEntity()))
        .build();
  }

  public OrderJpaEntity mapToJpaEntity(Order order) {
    return OrderJpaEntity.builder()
        .orderId(order.getOrderId())
        .orderNum(order.getOrderNum())
        .orderStatus(order.getOrderStatus())
        .userJpaEntity(userMapper.mapToJpaEntity(order.getUser()))
        .orderMenuJpaEntity(mapToEntities(order.getOrderMenus()))
        .build();
  }

  private List<OrderMenu> mapToDomains(List<OrderMenuJpaEntity> jpaEntities) {
    return jpaEntities.stream().map(orderMenuMapper::mapToDomainEntity).toList();
  }

  private List<OrderMenuJpaEntity> mapToEntities(List<OrderMenu> domains) {
    return domains.stream().map(orderMenuMapper::mapToJpaEntity).toList();
  }


}
