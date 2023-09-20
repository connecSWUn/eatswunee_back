package com.swulab.eatswunee.domain.chatroom.application.port.out;

import com.swulab.eatswunee.domain.chatroom.application.port.out.command.LastChatMessage;

public interface FindLastChatMessagePort {

  LastChatMessage findLastChatMessage(String chatRoomId);

}
