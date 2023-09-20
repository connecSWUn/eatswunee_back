package com.swulab.eatswunee.domain.chatroom.adapter.in.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateRoomResponse {

  private String chat_room_id;

  public CreateRoomResponse(String chat_room_id) {
    this.chat_room_id = chat_room_id;
  }
}
