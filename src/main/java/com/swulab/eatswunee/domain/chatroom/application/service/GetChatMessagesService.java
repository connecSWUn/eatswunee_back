package com.swulab.eatswunee.domain.chatroom.application.service;

import com.swulab.eatswunee.domain.chatroom.application.port.in.GetChatMessagesUseCase;
import com.swulab.eatswunee.domain.chatroom.application.port.in.command.GetChatMessagesCommand;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindChatMessagesPort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.command.FindChatMessageCommand;
import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitPort;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetChatMessagesService implements GetChatMessagesUseCase {

  private final FindChatMessagesPort findChatMessagesPort;
  private final FindUserPort findUserPort;
  private final FindChatRoomPort findChatRoomPort;

  @Override
  public GetChatMessagesCommand getChatMessages(Long guestId, String chatRoomId) {

    String userName = findUserPort.findUser(guestId).getName();

    List<FindChatMessageCommand> commands = findChatMessagesPort.findChatMessages(chatRoomId);

    ChatRoom chatRoom = findChatRoomPort.findChatRoomById(chatRoomId);
    Recruit recruit = chatRoom.getRecruit();
    return new GetChatMessagesCommand(recruit, commands, userName);
  }
}
