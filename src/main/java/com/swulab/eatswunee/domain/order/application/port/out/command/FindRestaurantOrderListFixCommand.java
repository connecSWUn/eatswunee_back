package com.swulab.eatswunee.domain.order.application.port.out.command;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FindRestaurantOrderListFixCommand {
  private Long orderId;
  private Integer orderNum;
  private LocalDateTime orderCreatedAt;
  private String menuName;
  private Integer menuCnt;

  public FindRestaurantOrderListFixCommand(Long orderId, Integer orderNum,
      LocalDateTime orderCreatedAt, String menuName, Integer menuCnt) {
    this.orderId = orderId;
    this.orderNum = orderNum;
    this.orderCreatedAt = orderCreatedAt;
    this.menuName = menuName;
    this.menuCnt = menuCnt;
  }
}
