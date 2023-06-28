package com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.chatroom.adapter.out.persistence.jap.model.ChatRoomJpaEntity;
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
@DiscriminatorValue("notification_chat")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "notification_chat")
@SuperBuilder
public class ChatNotificationJpaEntity extends NotificationJpaEntity {

  @ManyToOne
  @JoinColumn(name = "chat_room_id")
  private ChatRoomJpaEntity chatRoomJpaEntity;

  public ChatNotificationJpaEntity(Long notificationId, String notificationTitle,
      String notificationContent, Boolean notificationIsRead,
      LocalDateTime notificationCreatedAt,
      ChatRoomJpaEntity chatRoomJpaEntity) {
    super(notificationId, notificationTitle, notificationContent, notificationIsRead,
        notificationCreatedAt);
    this.chatRoomJpaEntity = chatRoomJpaEntity;
  }
}
