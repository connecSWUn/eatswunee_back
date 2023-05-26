package com.swulab.eatswunee.domain.order.application.port.in.command;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddOrderCommand {

  private LocalDateTime orderCreatedAt;
  private int totalPrice;
  private int orderNum;
  private int menuTotalCnt;
  private List<OrderMenuCommand> restaurantOrderedMenus;

  public AddOrderCommand(LocalDateTime orderCreatedAt, int orderNum,
      List<OrderMenuCommand> restaurantOrderedMenus) {
    this.orderCreatedAt = orderCreatedAt;
    this.totalPrice = calTotalPrice(restaurantOrderedMenus);
    this.orderNum = orderNum;
    this.menuTotalCnt = calTotalMenuCnt(restaurantOrderedMenus);
    this.restaurantOrderedMenus = restaurantOrderedMenus;
  }

  private int calTotalPrice(List<OrderMenuCommand> commands) {
    return commands.stream().mapToInt(OrderMenuCommand::getTotalPrice).sum();
  }

  private int calTotalMenuCnt(List<OrderMenuCommand> commands) {
    return commands.stream().mapToInt(OrderMenuCommand::getTotalPrice).sum();
  }


}
