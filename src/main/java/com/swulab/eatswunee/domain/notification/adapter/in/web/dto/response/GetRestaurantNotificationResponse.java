package com.swulab.eatswunee.domain.notification.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRestaurantNotificationCommand;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetRestaurantNotificationResponse {

  private List<RestaurantNotificationResponse> notifications;

  public GetRestaurantNotificationResponse(List<FindRestaurantNotificationCommand> commands) {
    this.notifications = commands.stream().map(RestaurantNotificationResponse::new).toList();
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  private class RestaurantNotificationResponse {

    private Long notification_id;
    private Long order_id;
    private int order_num;
    private String order_title_menu;
    private int order_etc_menu_cnt;
    private LocalDateTime order_created_at;
    private Boolean is_notification_read;

    public RestaurantNotificationResponse(FindRestaurantNotificationCommand command) {
      this.notification_id = command.getOrderNotificationId();
      this.order_id = command.getOrderId();
      this.order_num = command.getOrderNum();
      this.order_title_menu = command.getMenuName();
      this.order_etc_menu_cnt = command.getOrderEtcMenuCnt();
      this.order_created_at = command.getOrderCreatedAt();
      this.is_notification_read = command.getIsRead();
    }
  }


}
