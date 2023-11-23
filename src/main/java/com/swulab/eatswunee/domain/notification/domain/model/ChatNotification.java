package com.swulab.eatswunee.domain.notification.domain.model;

import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatNotification extends Notification {

  private ChatRoom chatRoom;

  public ChatNotification(Long notificationId, String notificationContent,
      Boolean notificationIsRead, LocalDateTime notificationCreatedAt,
      String notificationType, ChatRoom chatRoom, NotificationCategory notificationCategory) {
    super(notificationId, notificationContent, notificationIsRead, notificationCreatedAt,
        notificationType, notificationCategory);
    this.chatRoom = chatRoom;
  }
}
