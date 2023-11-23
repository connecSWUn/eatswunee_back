package com.swulab.eatswunee.domain.chatroom.application.port.out;

import com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller.command.UserChatRoomCommand;
import java.util.List;

public interface FindRecruitChatRoomPort {

  List<UserChatRoomCommand> findRecruitChatRoom(Long recruitId);

  Integer findRecruitChatRoomByRecruitId(Long recruitId);

}
