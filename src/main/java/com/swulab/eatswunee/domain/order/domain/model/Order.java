package com.swulab.eatswunee.domain.order.domain.model;

import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenu;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;

@Getter
public class Order {

  private Long orderId;
  private int orderNum;

  private LocalDateTime orderCreatedAt;

  private OrderStatus orderStatus;

  private User user;

  private List<OrderMenu> orderMenus;

  @Builder
  public Order(Long orderId, int orderNum, LocalDateTime orderCreatedAt,
      OrderStatus orderStatus, User user,
      List<OrderMenu> orderMenus) {
    this.orderId = orderId;
    this.orderNum = orderNum;
    this.orderCreatedAt = orderCreatedAt;
    this.orderStatus = orderStatus;
    this.user = user;
    this.orderMenus = orderMenus;
  }

  public void updateOrderMenus(List<OrderMenu> orderMenus) {
    this.orderMenus = orderMenus;
  }
}
