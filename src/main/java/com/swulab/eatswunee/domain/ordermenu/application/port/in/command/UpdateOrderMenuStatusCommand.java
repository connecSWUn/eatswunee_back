package com.swulab.eatswunee.domain.ordermenu.application.port.in.command;

import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenuStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateOrderMenuStatusCommand {

  private Long orderId;
  private OrderMenuStatus orderMenuStatus;

  public UpdateOrderMenuStatusCommand(Long orderId,
      OrderMenuStatus orderMenuStatus) {
    this.orderId = orderId;
    this.orderMenuStatus = orderMenuStatus;
  }
}
