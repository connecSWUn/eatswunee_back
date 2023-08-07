package com.swulab.eatswunee.domain.ordermenu.adpater.in.web.dto.response;

import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.UpdateOrderMenuStatusCommand;
import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenuStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateOrderMenuStatusResponse {

  private Long order_id;
  private OrderMenuStatus to_order_menu_status;

  public UpdateOrderMenuStatusResponse(UpdateOrderMenuStatusCommand command) {
    this.order_id = command.getOrderId();
    this.to_order_menu_status = command.getOrderMenuStatus();
  }
}
