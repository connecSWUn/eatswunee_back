package com.swulab.eatswunee.domain.notification.adapter.port.out.persistence;

import com.swulab.eatswunee.domain.notification.adapter.port.out.persistence.jpa.model.NotificationJpaEntity;
import com.swulab.eatswunee.domain.notification.domain.model.Notification;
import com.swulab.eatswunee.domain.order.adapter.out.persistence.OrderMapper;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationMapper {

  private final OrderMapper orderMapper;
  private final UserMapper userMapper;

  public Notification mapToDomainEntity(NotificationJpaEntity notificationJpaEntity) {
    return Notification.builder()
        .notificationId(notificationJpaEntity.getNotificationId())
        .notificationTitle(notificationJpaEntity.getNotificationTitle())
        .notificationContent(notificationJpaEntity.getNotificationContent())
        .notificationIsRead(notificationJpaEntity.getNotificationIsRead())
        .notificationCreatedAt(notificationJpaEntity.getNotificationCreatedAt())
        .order(orderMapper.mapToDomainEntity(notificationJpaEntity.getOrderJpaEntity()))
        .receiver(userMapper.mapToDomainEntity(notificationJpaEntity.getUserJpaEntity()))
        .build();
  }

  public NotificationJpaEntity mapToJpaEntity(Notification notification) {
    return NotificationJpaEntity.builder()
        .notificationId(notification.getNotificationId())
        .notificationTitle(notification.getNotificationTitle())
        .notificationContent(notification.getNotificationContent())
        .notificationIsRead(notification.getNotificationIsRead())
        .notificationCreatedAt(notification.getNotificationCreatedAt())
        .orderJpaEntity(orderMapper.mapToJpaEntity(notification.getOrder()))
        .userJpaEntity(userMapper.mapToJpaEntity(notification.getReceiver()))
        .build();
  }

}