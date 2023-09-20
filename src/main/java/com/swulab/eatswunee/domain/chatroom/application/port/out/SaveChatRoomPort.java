package com.swulab.eatswunee.domain.chatroom.application.port.out;

import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;

public interface SaveChatRoomPort {

  String saveChatRoom(ChatRoom chatRoom);

}
