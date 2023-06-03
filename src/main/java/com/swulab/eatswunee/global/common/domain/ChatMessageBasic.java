package com.swulab.eatswunee.global.common.domain;

import com.swulab.eatswunee.domain.chatmessage.domain.model.MessageType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class ChatMessageBasic {

  private MessageType messageType;
  private Long chatRoomId;
  private Long senderId;
  private String message;

  public ChatMessageBasic(
      MessageType messageType, Long chatRoomId, Long senderId, String message) {
    this.messageType = messageType;
    this.chatRoomId = chatRoomId;
    this.senderId = senderId;
    this.message = message;
  }
}
