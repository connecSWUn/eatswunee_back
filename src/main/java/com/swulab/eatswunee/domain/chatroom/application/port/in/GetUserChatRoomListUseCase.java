package com.swulab.eatswunee.domain.chatroom.application.port.in;

import com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller.command.UserChatRoomCommand;
import java.util.List;

public interface GetUserChatRoomListUseCase {

  List<UserChatRoomCommand> getUserChatRoomList(Long userId);

}
