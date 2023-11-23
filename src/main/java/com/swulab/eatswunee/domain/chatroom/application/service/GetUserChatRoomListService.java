package com.swulab.eatswunee.domain.chatroom.application.service;

import com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller.command.UserChatRoomCommand;
import com.swulab.eatswunee.domain.chatroom.application.port.in.GetUserChatRoomListUseCase;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindLastChatMessagePort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindRecruitChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindUserChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.command.LastChatMessage;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitsPortByUserIdPort;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserChatRoomListService implements GetUserChatRoomListUseCase {

  private final FindUserChatRoomPort findUserChatRoomPort;
  private final FindLastChatMessagePort findLastChatMessagePort;
  private final FindRecruitsPortByUserIdPort findRecruitsPortByUserIdPort;
  private final FindRecruitChatRoomPort findRecruitChatRoomPort;


  @Override
  public List<UserChatRoomCommand> getUserChatRoomList(Long userId) {
    List<UserChatRoomCommand> commands = new ArrayList<>();
    List<Recruit> recruitList = findRecruitsPortByUserIdPort.findRecruitsPortByUserId(userId, null);

    recruitList.forEach(
        recruit -> commands.addAll(findRecruitChatRoomPort.findRecruitChatRoom(recruit.getRecruitId()))
    );

    commands.addAll(findUserChatRoomPort.findUserChatRoom(userId));


    commands.forEach(
        command -> {
          LastChatMessage lastChatMessage = findLastChatMessagePort.findLastChatMessage(command.getChatRoomId());
          command.getChatMessage(lastChatMessage);
        }
    );

    return commands;
  }

  @Override
  public Integer getUserChatRoomListByRecruitId(Long recruitId) {
    return findRecruitChatRoomPort.findRecruitChatRoomByRecruitId(recruitId);
  }
}
