package com.swulab.eatswunee.domain.notification.domain.model;

import com.swulab.eatswunee.domain.order.domain.model.Order;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderNotification extends Notification {

  private Order order;

  public OrderNotification(Long notificationId, String notificationContent,
      Boolean notificationIsRead, LocalDateTime notificationCreatedAt,
      String notificationType, Order order) {
    super(notificationId, notificationContent, notificationIsRead, notificationCreatedAt,
        notificationType);
    this.order = order;
  }
}
