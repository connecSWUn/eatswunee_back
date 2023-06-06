package com.swulab.eatswunee.domain.chatroom.application.port.in.command;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExsitChatRoomCommand {

  Boolean isExistChatRoom;

  public ExsitChatRoomCommand(Boolean isExistChatRoom) {
    this.isExistChatRoom = isExistChatRoom;
  }
}
