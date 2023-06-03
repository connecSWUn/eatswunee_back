package com.swulab.eatswunee.domain.chatroom.application.port.in;

import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;

public interface AddChatRoomUseCase {

  ChatRoom createRoom(Long userId, Long recruitId);

}
