package com.swulab.eatswunee.domain.chatroom.application.service;

import com.swulab.eatswunee.domain.chatroom.application.port.in.FindChatRoomUseCase;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import jakarta.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindChatRoomService implements FindChatRoomUseCase {

  private Map<Long, ChatRoom> chatRooms; // chatId를 key로 갖고 ChatRoom을 value로 갖는 Map
  private final FindChatRoomPort findChatRoomPort;

  @PostConstruct
  private void init() {
    chatRooms = new LinkedHashMap<>();
  }

  @Override
  public List<ChatRoom> findAllRoom() {

    List<ChatRoom> allChatRooms = findChatRoomPort.findAllChatRooms();
    return allChatRooms;
  }

  @Override
  public ChatRoom findRoomById(Long roomId) {

    return findChatRoomPort.findChatRoomById(roomId);
  }
}
