package com.swulab.eatswunee.domain.order.adapter.out.persistence;

import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.OrderJpaEntity;
import com.swulab.eatswunee.domain.order.domain.model.Order;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.UserMapper;
import com.swulab.eatswunee.global.common.domain.BaseEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderMapper {

  private final UserMapper userMapper;

  public Order mapToDomainEntity(OrderJpaEntity orderJpaEntity) {
    return Order.builder()
        .orderId(orderJpaEntity.getId())
        .orderNum(orderJpaEntity.getOrderNum())
        .orderCreatedAt(orderJpaEntity.getCreatedAt())
        .orderStatus(orderJpaEntity.getOrderStatus())
        .user(userMapper.mapToDomainEntity(orderJpaEntity.getUserJpaEntity()))
        .build();
  }

  public OrderJpaEntity mapToJpaEntity(Order order) {

    return OrderJpaEntity.builder()
        .id(order.getOrderId())
        .orderNum(order.getOrderNum())
        .createdAt(order.getOrderCreatedAt())
        .orderStatus(order.getOrderStatus())
        .userJpaEntity(userMapper.mapToJpaEntity(order.getUser()))
        .build();
  }

}
