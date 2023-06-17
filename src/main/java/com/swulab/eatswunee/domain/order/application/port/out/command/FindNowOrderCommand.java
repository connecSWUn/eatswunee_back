package com.swulab.eatswunee.domain.order.application.port.out.command;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FindNowOrderCommand {

  private Long orderId;
  private int orderNum;
  private Long restaurantId;
  private int expectedWaitingTime;

  public FindNowOrderCommand(Long orderId, int orderNum, Long restaurantId) {
    this.orderId = orderId;
    this.orderNum = orderNum;
    this.restaurantId = restaurantId;
    this.expectedWaitingTime = 5;
  }

  public void changeExpectedWaitingTime(int expectedWaitingTime) {
    this.expectedWaitingTime += expectedWaitingTime;
  }

}
