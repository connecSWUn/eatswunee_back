package com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd;

import com.swulab.eatswunee.domain.order.domain.model.Order;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserOrderCommand {

  Long orderId;
  LocalDateTime orderCreatedAt;

  List<UserOrderMenuCommand> orderMenus;

  public UserOrderCommand(Order order) {
    this.orderId = order.getOrderId();
    this.orderCreatedAt = order.getOrderCreatedAt();
  }

  public void setOrderMenus(List<UserOrderMenuCommand> commands) {
    this.orderMenus = commands;
  }
}
