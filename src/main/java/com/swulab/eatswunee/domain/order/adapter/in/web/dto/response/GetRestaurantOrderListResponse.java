package com.swulab.eatswunee.domain.order.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.order.application.port.out.command.FindRestaurantOrderListCommand;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetRestaurantOrderListResponse {

  private Long orderId;
  private int order_num;
  private List<GetRestaurantOrderMenuResponse> menus;

  public GetRestaurantOrderListResponse(FindRestaurantOrderListCommand command) {
    this.orderId = command.getOrderId();
    this.order_num = command.getOrderNum();
    this.menus = command.getMenus().stream().map(GetRestaurantOrderMenuResponse::new).toList();
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class GetRestaurantOrderMenuResponse {

    private String menu_name;
    private int menu_cnt;

    public GetRestaurantOrderMenuResponse(FindRestaurantOrderListCommand.FindRestaurantOrderMenuCommand command) {
      this.menu_name = command.getMenuName();
      this.menu_cnt = command.getMenuCnt();
    }
  }

}
