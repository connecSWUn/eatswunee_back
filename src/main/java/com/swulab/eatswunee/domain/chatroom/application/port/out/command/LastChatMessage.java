package com.swulab.eatswunee.domain.chatroom.application.port.out.command;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LastChatMessage {

  private LocalDateTime lastChatCreatedAt;
  private String lastChatMessage;

  public LastChatMessage(LocalDateTime lastChatCreatedAt, String lastChatMessage) {
    this.lastChatCreatedAt = lastChatCreatedAt;
    this.lastChatMessage = lastChatMessage;
  }
}
