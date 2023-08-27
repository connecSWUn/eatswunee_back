package com.swulab.eatswunee.domain.notification.application.port.out.command;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FindRestaurantNotificationCommand {

  private Long orderNotificationId;
  private Long orderId;
  private int orderNum;
  private LocalDateTime orderCreatedAt;
  private String menuName;
  private int orderEtcMenuCnt;
  private Boolean isRead;

  public FindRestaurantNotificationCommand(Long orderId, int orderNum,
      LocalDateTime orderCreatedAt, String menuName, int orderEtcMenuCnt) {
    this.orderId = orderId;
    this.orderNum = orderNum;
    this.orderCreatedAt = orderCreatedAt;
    this.menuName = menuName;
    this.orderEtcMenuCnt = orderEtcMenuCnt;
  }

  public void setOrderNotificationId(Long orderNotificationId) {
    this.orderNotificationId = orderNotificationId;
  }

  public void setRead(Boolean read) {
    isRead = read;
  }
}
