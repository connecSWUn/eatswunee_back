package com.swulab.eatswunee.domain.notification.domain.model;

import com.swulab.eatswunee.domain.order.domain.model.Order;
import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderNotification extends Notification {

  private Order order;
  private Restaurant restaurant;

  public OrderNotification(Long notificationId, String notificationContent,
      Boolean notificationIsRead, LocalDateTime notificationCreatedAt,
      String notificationType, Order order, Restaurant restaurant, NotificationCategory notificationCategory) {
    super(notificationId, notificationContent, notificationIsRead, notificationCreatedAt,
        notificationType, notificationCategory);
    this.order = order;
    this.restaurant = restaurant;
  }
}
