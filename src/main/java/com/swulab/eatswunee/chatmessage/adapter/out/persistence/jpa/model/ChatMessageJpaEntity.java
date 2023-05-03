package com.swulab.eatswunee.chatmessage.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.chatroom.adapter.out.persistence.jap.model.ChatRoomJpaEntity;
import com.swulab.eatswunee.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "chat_message")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatMessageJpaEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long chatMessageId;

  private String message;

  @Column(nullable = false)
  @ColumnDefault("false")
  @Builder.Default
  private Boolean isRead = false;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserJpaEntity userJpaEntity;

  @ManyToOne
  @JoinColumn(name = "chat_room_id")
  private ChatRoomJpaEntity chatRoomJpaEntity;

  @Builder
  public ChatMessageJpaEntity(Long chatMessageId, String message, Boolean isRead,
      UserJpaEntity userJpaEntity,
      ChatRoomJpaEntity chatRoomJpaEntity) {
    this.chatMessageId = chatMessageId;
    this.message = message;
    this.isRead = isRead;
    this.userJpaEntity = userJpaEntity;
    this.chatRoomJpaEntity = chatRoomJpaEntity;
  }
}
