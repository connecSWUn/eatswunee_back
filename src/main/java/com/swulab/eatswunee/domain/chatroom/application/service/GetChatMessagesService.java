package com.swulab.eatswunee.domain.chatroom.application.service;

import com.swulab.eatswunee.domain.chatroom.application.port.in.GetChatMessagesUseCase;
import com.swulab.eatswunee.domain.chatroom.application.port.in.command.GetChatMessagesCommand;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindChatMessagesPort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.command.FindChatMessageCommand;
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
  private final FindRecruitPort findRecruitPort;
  private final FindUserPort findUserPort;

  @Override
  public GetChatMessagesCommand getChatMessages(Long userId, Long recruitId) {

    String userName = findUserPort.findUser(userId).getName();

    List<FindChatMessageCommand> commands = findChatMessagesPort.findChatMessages(Long.parseLong(userId + "0" + recruitId));
    Recruit recruit = findRecruitPort.findRecruit(recruitId);

    return new GetChatMessagesCommand(recruit, commands, userName);
  }
}
