package com.swulab.eatswunee.domain.notification.adapter.out.persistence;

import com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model.NotificationJpaEntity;
import com.swulab.eatswunee.domain.notification.domain.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationMapper {

    public Notification mapToDomainEntity(NotificationJpaEntity notificationJpaEntity) {
        return Notification.builder()
                .notificationId(notificationJpaEntity.getId())
                .notificationContent(notificationJpaEntity.getNotificationContent())
                .notificationIsRead(notificationJpaEntity.getNotificationIsRead())
                .notificationCreatedAt(notificationJpaEntity.getCreatedAt())
                .notificationCategory(notificationJpaEntity.getNotificationCategory())
                .build();
    }

    public NotificationJpaEntity mapToJpaEntity(Notification notification) {
        return NotificationJpaEntity.builder()
                .id(notification.getNotificationId())
                .notificationContent(notification.getNotificationContent())
                .notificationIsRead(notification.getNotificationIsRead())
                .createdAt(notification.getNotificationCreatedAt())
                .notificationCategory(notification.getNotificationCategory())
                .build();
    }

}
