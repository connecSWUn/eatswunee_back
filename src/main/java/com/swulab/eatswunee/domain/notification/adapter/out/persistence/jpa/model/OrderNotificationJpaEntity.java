package com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.OrderJpaEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("notification_order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Table(name = "notification_order")
public class OrderNotificationJpaEntity extends NotificationJpaEntity {

  @ManyToOne
  @JoinColumn(name = "order_id")
  private OrderJpaEntity orderJpaEntity;

  public OrderNotificationJpaEntity(Long notificationId, String notificationTitle,
      String notificationContent, Boolean notificationIsRead,
      LocalDateTime notificationCreatedAt,
      OrderJpaEntity orderJpaEntity) {
    super(notificationId, notificationTitle, notificationContent, notificationIsRead,
        notificationCreatedAt);
    this.orderJpaEntity = orderJpaEntity;
  }
}
