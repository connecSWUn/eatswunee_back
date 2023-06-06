package com.swulab.eatswunee.domain.chatroom.application.port.out;

import com.swulab.eatswunee.domain.chatroom.application.port.out.command.FindChatMessageCommand;
import java.util.List;

public interface FindChatMessagesPort {

  List<FindChatMessageCommand> findChatMessages(Long chatRoomId);

}
