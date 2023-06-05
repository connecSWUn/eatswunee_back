package com.swulab.eatswunee.domain.chatroom.application.port.in;

import com.swulab.eatswunee.domain.chatroom.application.port.in.command.GetChatRoomCommand;

public interface ExistChatRoomUseCase {

  GetChatRoomCommand getChatRoom(Long userId, Long recruitId);

}
