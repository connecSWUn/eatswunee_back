package com.swulab.eatswunee.domain.chatroom.application.port.in;

import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import java.util.List;

public interface FindChatRoomUseCase {

  List<ChatRoom> findAllRoom();

  ChatRoom findRoomById(String roomId);

}
