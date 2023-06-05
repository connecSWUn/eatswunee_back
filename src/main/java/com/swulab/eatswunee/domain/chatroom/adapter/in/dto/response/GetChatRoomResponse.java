package com.swulab.eatswunee.domain.chatroom.adapter.in.dto.response;

import com.swulab.eatswunee.domain.chatroom.application.port.in.command.GetChatRoomCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetChatRoomResponse {

  Boolean exist_chatroom;

  public GetChatRoomResponse(GetChatRoomCommand command) {
    this.exist_chatroom = command.getIsExistChatRoom();
  }
}
