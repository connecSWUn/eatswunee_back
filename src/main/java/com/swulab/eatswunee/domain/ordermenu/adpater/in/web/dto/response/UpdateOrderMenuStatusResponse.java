package com.swulab.eatswunee.domain.ordermenu.adpater.in.web.dto.response;

import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.UpdateOrderMenuStatusCommand;
import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenuStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateOrderMenuStatusResponse {

  private Long order_menu_id;
  private OrderMenuStatus to_order_menu_status;

  public UpdateOrderMenuStatusResponse(UpdateOrderMenuStatusCommand command) {
    this.order_menu_id = command.getOrderMenuId();
    this.to_order_menu_status = command.getOrderMenuStatus();
  }
}
