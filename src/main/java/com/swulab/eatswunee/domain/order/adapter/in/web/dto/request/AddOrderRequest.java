package com.swulab.eatswunee.domain.order.adapter.in.web.dto.request;

import com.swulab.eatswunee.domain.order.application.port.in.command.AddOrderCommand;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddOrderRequest {

  List<OrderMenuRequest> orderMenus;

  public AddOrderRequest(
      List<OrderMenuRequest> orderMenus) {
    this.orderMenus = orderMenus;
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  private static class OrderMenuRequest {

    private Long menuId;
    private int menuCnt;

    public OrderMenuRequest(Long menuId, int menuCnt) {
      this.menuId = menuId;
      this.menuCnt = menuCnt;
    }
  }

  public List<AddOrderCommand> toCommands() {
    return this.orderMenus.stream().map(
        orderMenuRequest -> new AddOrderCommand(orderMenuRequest.menuId, orderMenuRequest.getMenuCnt())
    ).toList();
  }


}
