package com.swulab.eatswunee.order.adapter.out.persistence;

import com.swulab.eatswunee.order.adapter.out.persistence.jpa.model.OrderJpaEntity;
import com.swulab.eatswunee.order.domain.model.Order;
import com.swulab.eatswunee.user.adapter.out.persistence.UserMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderMapper {

  private final UserMapper userMapper;

  public Order mapToDomainEntity(OrderJpaEntity orderJpaEntity) {
    return Order.builder()
        .orderId(orderJpaEntity.getOrderId())
        .orderNum(orderJpaEntity.getOrderNum())
        .orderStatus(orderJpaEntity.getOrderStatus())
        .user(userMapper.mapToDomainEntity(orderJpaEntity.getUserJpaEntity()))
        .build();
  }

  public OrderJpaEntity mapToJpaEntity(Order order) {
    return OrderJpaEntity.builder()
        .orderId(order.getOrderId())
        .orderNum(order.getOrderNum())
        .orderStatus(order.getOrderStatus())
        .userJpaEntity(userMapper.mapToJpaEntity(order.getUser()))
        .build();
  }



}
