package com.swulab.eatswunee.domain.chatroom.application.port.in;

import com.swulab.eatswunee.domain.chatroom.application.port.in.command.GetChatMessagesCommand;

public interface GetChatMessagesUseCase {

  GetChatMessagesCommand getChatMessages(Long userId, Long chatRoomId);

}
