package com.swulab.eatswunee.domain.ordermenu.adpater.in.web.dto.response;

import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.RestaurantNowOrderListCommand;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.RestaurantNowOrderListCommand.RestaurantOrderMenuCommand;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetNowOrderListResponse {

  List<RestaurantNowOrderResponse> restaurant_orders;

  public GetNowOrderListResponse(List<RestaurantNowOrderListCommand> restaurant_orders) {
    this.restaurant_orders = restaurant_orders.stream().map(RestaurantNowOrderResponse::new).toList();
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class RestaurantNowOrderResponse {

    private Long order_id;
    private int order_num;
    private LocalDateTime order_created_at;
    private List<RestaurantOrderMenuResponse> menus;

    public RestaurantNowOrderResponse(RestaurantNowOrderListCommand command) {
      this.order_id = command.getOrderId();
      this.order_num = command.getOrderNum();
      this.order_created_at = command.getOrderCreatedAt();
      this.menus = command.getMenus().stream().map(RestaurantOrderMenuResponse::new).toList();
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RestaurantOrderMenuResponse {

      private String menu_name;
      private int menu_cnt;

      public RestaurantOrderMenuResponse(RestaurantOrderMenuCommand command) {
        this.menu_name = command.getMenuName();
        this.menu_cnt = command.getMenuCnt();
      }
    }

  }
}
