package com.swulab.eatswunee.domain.order.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.order.application.port.out.command.FindRestaurantOrderListFixCommand;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetRestaurantOrderListFixResponse {

  private List<Response> orders;

  public GetRestaurantOrderListFixResponse(
      List<FindRestaurantOrderListFixCommand> commands) {
    this.orders = commands.stream().map(Response::new).toList();
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class Response {

    private Long orderId;
    private int order_num;
    private LocalDateTime orderCreatedAt;
    private String menu_name;
    private int menu_cnt;

  public Response(FindRestaurantOrderListFixCommand command) {
      this.orderId = command.getOrderId();
      this.order_num = command.getOrderNum();
      this.orderCreatedAt = command.getOrderCreatedAt();
      this.menu_name = command.getMenuName();
      this.menu_cnt = command.getMenuCnt();
    }

  }

}
