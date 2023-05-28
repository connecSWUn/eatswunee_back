package com.swulab.eatswunee.domain.ordermenu.application.port.in.command;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetOrderMenuCommand {

  private int orderNum;
  private LocalDateTime orderCreatedAt;
  private int orderTotalPrice;

  private List<OrderMenuCommand> orderCommandList;

  public GetOrderMenuCommand(int orderNum, LocalDateTime orderCreatedAt,
      List<OrderMenuCommand> orderCommandList) {

    this.orderNum = orderNum;
    this.orderCreatedAt = orderCreatedAt;
    this.orderTotalPrice = calOrderTotalPrice(orderCommandList);
    this.orderCommandList = orderCommandList;
  }

  private int calOrderTotalPrice(List<OrderMenuCommand> commands) {
    return commands.stream().mapToInt(OrderMenuCommand::getRestaurantTotalPrice).sum();
  }
}
