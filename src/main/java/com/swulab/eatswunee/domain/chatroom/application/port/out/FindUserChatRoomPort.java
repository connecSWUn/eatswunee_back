package com.swulab.eatswunee.domain.chatroom.application.port.out;

import com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller.command.UserChatRoomCommand;
import java.util.List;

public interface FindUserChatRoomPort {

  List<UserChatRoomCommand> findUserChatRoom(Long userId);

  Integer findChatRoomSizeRelatedRecruit(Long userId, Long recruitId);

}
