package com.swulab.eatswunee.domain.chatroom.application.port.in;

import com.swulab.eatswunee.domain.chatroom.application.port.in.command.ExsitChatRoomCommand;

public interface ExistChatRoomUseCase {

  ExsitChatRoomCommand getChatRoom(String chatRoomId);

}
