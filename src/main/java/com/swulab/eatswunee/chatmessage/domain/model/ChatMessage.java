package com.swulab.eatswunee.chatmessage.domain.model;

import com.swulab.eatswunee.chatroom.domain.model.ChatRoom;
import com.swulab.eatswunee.user.domain.model.User;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ChatMessage {

  private Long chatMessageId;
  private String message;
  private Boolean isRead;
  private LocalDateTime createdAt;


  private User user;
  private ChatRoom chatRoom;


}
