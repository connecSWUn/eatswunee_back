package com.swulab.eatswunee.domain.order.domain.model;

import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenu;
import com.swulab.eatswunee.domain.user.domain.model.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Order {

  private Long orderId;
  private int orderNum;

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;

  private User user;

  private List<OrderMenu> orderMenus;

  @Builder
  public Order(Long orderId, int orderNum,
      OrderStatus orderStatus, User user,
      List<OrderMenu> orderMenus) {
    this.orderId = orderId;
    this.orderNum = orderNum;
    this.orderStatus = orderStatus;
    this.user = user;
    this.orderMenus = orderMenus;
  }
}
