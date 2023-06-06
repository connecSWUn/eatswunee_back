package com.swulab.eatswunee.domain.chatroom.adapter.in.dto.response;

import com.swulab.eatswunee.domain.chatroom.application.port.in.command.ExsitChatRoomCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExistChatRoomResponse {

  Boolean exist_chatroom;

  public ExistChatRoomResponse(ExsitChatRoomCommand command) {
    this.exist_chatroom = command.getIsExistChatRoom();
  }
}
