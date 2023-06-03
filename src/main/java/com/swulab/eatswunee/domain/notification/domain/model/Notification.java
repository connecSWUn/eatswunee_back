package com.swulab.eatswunee.domain.notification.domain.model;

import com.swulab.eatswunee.domain.order.domain.model.Order;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification {

  private Long notificationId;
  private String notificationTitle;
  private String notificationContent;
  private Boolean notificationIsRead;
  private LocalDateTime notificationCreatedAt;

  private Order order;
  private User receiver;

  @Builder
  public Notification(Long notificationId, String notificationTitle,
      String notificationContent, Boolean notificationIsRead,
      LocalDateTime notificationCreatedAt, Order order,
      User receiver) {
    this.notificationId = notificationId;
    this.notificationTitle = notificationTitle;
    this.notificationContent = notificationContent;
    this.notificationIsRead = notificationIsRead;
    this.notificationCreatedAt = notificationCreatedAt;
    this.order = order;
    this.receiver = receiver;
  }
}
