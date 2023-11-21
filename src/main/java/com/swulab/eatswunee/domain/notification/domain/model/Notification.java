package com.swulab.eatswunee.domain.notification.domain.model;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification {

  private Long notificationId;
  private String notificationContent;
  private Boolean notificationIsRead;
  private LocalDateTime notificationCreatedAt;
  private String notificationType;
  private NotificationCategory notificationCategory;


  @Builder
  public Notification(Long notificationId,
      String notificationContent, Boolean notificationIsRead,
      LocalDateTime notificationCreatedAt, String notificationType,
                      NotificationCategory notificationCategory) {
    this.notificationId = notificationId;
    this.notificationContent = notificationContent;
    this.notificationIsRead = notificationIsRead;
    this.notificationCreatedAt = notificationCreatedAt;
    this.notificationType = notificationType;
    this.notificationCategory = notificationCategory;
  }
}
