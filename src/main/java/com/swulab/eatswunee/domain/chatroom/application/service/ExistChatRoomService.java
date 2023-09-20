package com.swulab.eatswunee.domain.chatroom.application.service;

import com.swulab.eatswunee.domain.chatroom.application.port.in.ExistChatRoomUseCase;
import com.swulab.eatswunee.domain.chatroom.application.port.in.command.ExsitChatRoomCommand;
import com.swulab.eatswunee.domain.chatroom.application.port.out.ExistChatRoomPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExistChatRoomService implements ExistChatRoomUseCase {

  private final ExistChatRoomPort existChatRoomPort;

  @Override
  public ExsitChatRoomCommand getChatRoom(String chatRoomId) {

    Boolean isExist = existChatRoomPort.existChatRoomByChatRoomId(chatRoomId);

    return new ExsitChatRoomCommand(isExist);
  }
}
