package com.swulab.eatswunee.domain.chatroom.application.service;

import com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller.command.UserChatRoomCommand;
import com.swulab.eatswunee.domain.chatroom.application.port.in.GetUserChatRoomListUseCase;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindLastChatMessagePort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindUserChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.command.LastChatMessage;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserChatRoomListService implements GetUserChatRoomListUseCase {

  private final FindUserChatRoomPort findUserChatRoomPort;
  private final FindLastChatMessagePort findLastChatMessagePort;

  @Override
  public List<UserChatRoomCommand> getUserChatRoomList(Long userId) {

    List<UserChatRoomCommand> commands = findUserChatRoomPort.findUserChatRoom(userId);


    commands.forEach(
        command -> {
          LastChatMessage lastChatMessage = findLastChatMessagePort.findLastChatMessage(command.getChatRoomId());
          command.getChatMessage(lastChatMessage);
        }
    );

    return commands;
  }
}
