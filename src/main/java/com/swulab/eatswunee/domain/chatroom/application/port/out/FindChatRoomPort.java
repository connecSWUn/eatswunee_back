package com.swulab.eatswunee.domain.chatroom.application.port.out;

import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import java.util.List;

public interface FindChatRoomPort {

  ChatRoom findChatRoomById(String chatRoom);

  List<ChatRoom> findAllChatRooms();

}
