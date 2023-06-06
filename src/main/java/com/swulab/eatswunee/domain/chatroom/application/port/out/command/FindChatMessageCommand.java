package com.swulab.eatswunee.domain.chatroom.application.port.out.command;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FindChatMessageCommand {

  private String messageSender;
  private String messageContent;
  private LocalDateTime messageCreatedAt;
  private Boolean messageIsRead;

  public FindChatMessageCommand(LocalDateTime messageCreatedAt, String messageSender, String messageContent,
       Boolean messageIsRead) {
    this.messageSender = messageSender;
    this.messageContent = messageContent;
    this.messageCreatedAt = messageCreatedAt;
    this.messageIsRead = messageIsRead;
  }
}
