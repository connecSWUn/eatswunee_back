package com.swulab.eatswunee.domain.order.domain.model;

import com.swulab.eatswunee.domain.user.domain.model.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Order {

  private Long orderId;
  private int orderNum;
  private OrderStatus orderStatus;

  private User user;

  @Builder
  public Order(Long orderId, int orderNum,
      OrderStatus orderStatus, User user) {
    this.orderId = orderId;
    this.orderNum = orderNum;
    this.orderStatus = orderStatus;
    this.user = user;
  }
}
