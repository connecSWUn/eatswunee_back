package com.swulab.eatswunee.domain.chatroom.application.port.out;

import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;

public interface SaveChatRoomPort {

  Long saveChatRoom(ChatRoom chatRoom);

}
