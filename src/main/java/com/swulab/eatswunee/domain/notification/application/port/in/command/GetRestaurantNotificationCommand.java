package com.swulab.eatswunee.domain.notification.application.port.in.command;

import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRestaurantNotificationCommand;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetRestaurantNotificationCommand {
  /*


   "order_id": "1",
        "order_num": "197",
        "order_title_menu": "매운닭갈비덮밥",
        "order_etc_menu_cnt": "6",
        "order_created_at": "2023.03.31 11:13"
      },
   */

  private Long orderId;
  private int orderNum;
  private String orderTitleMenu;
  private int orderEtcMenuCnt;
  private LocalDateTime orderCreatedAt;

  public GetRestaurantNotificationCommand(List<FindRestaurantNotificationCommand> commands) {


    this.orderId = orderId;
    this.orderNum = orderNum;
    this.orderTitleMenu = orderTitleMenu;
    this.orderEtcMenuCnt = orderEtcMenuCnt;
    this.orderCreatedAt = orderCreatedAt;
  }

  /*
    private Long orderId;
  private int orderNum;
  private LocalDateTime orderCreatedAt;
  private String menuName;
  private int menuCnt;
   */

}
