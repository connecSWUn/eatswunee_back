package com.swulab.eatswunee.domain.order.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.GetOrderMenuCommand;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.OrderMenuCommand;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetOrderResponse {
  private int order_num;
  private LocalDateTime order_created_at;
  private int order_total_price;

  private List<OrderMenuCommand> orders;

  public GetOrderResponse(GetOrderMenuCommand command) {
    this.order_created_at = command.getOrderCreatedAt();
    this.order_total_price = command.getOrderTotalPrice();
    this.order_num = command.getOrderNum();
    this.orders = command.getOrderCommandList();

  }

}
