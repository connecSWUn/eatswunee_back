package com.swulab.eatswunee.domain.chatroom.adapter.in.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateRoomResponse {

  private Long chat_room_id;

  public CreateRoomResponse(Long chat_room_id) {
    this.chat_room_id = chat_room_id;
  }
}
