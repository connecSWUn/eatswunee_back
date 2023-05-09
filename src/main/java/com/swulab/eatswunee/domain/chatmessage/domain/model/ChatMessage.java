package com.swulab.eatswunee.domain.chatmessage.domain.model;

import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ChatMessage {

  private Long chatMessageId;
  private String message;
  private Boolean isRead;
  private LocalDateTime createdAt;


  private User user;
  private ChatRoom chatRoom;

  @Builder
  public ChatMessage(Long chatMessageId, String message, Boolean isRead,
      LocalDateTime createdAt, User user,
      ChatRoom chatRoom) {
    this.chatMessageId = chatMessageId;
    this.message = message;
    this.isRead = isRead;
    this.createdAt = createdAt;
    this.user = user;
    this.chatRoom = chatRoom;
  }
}
