package com.swulab.eatswunee.domain.chatroom.application.service;

import com.swulab.eatswunee.domain.chatroom.application.port.in.ExistChatRoomUseCase;
import com.swulab.eatswunee.domain.chatroom.application.port.in.command.GetChatRoomCommand;
import com.swulab.eatswunee.domain.chatroom.application.port.out.ExistChatRoomPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExistChatRoomService implements ExistChatRoomUseCase {

  private final ExistChatRoomPort existChatRoomPort;

  @Override
  public GetChatRoomCommand getChatRoom(Long userId, Long recruitId) {

    Boolean isExist = existChatRoomPort.existChatRoomByChatRoomId(Long.parseLong(userId + "0" + recruitId));

    return new GetChatRoomCommand(isExist);
  }
}
