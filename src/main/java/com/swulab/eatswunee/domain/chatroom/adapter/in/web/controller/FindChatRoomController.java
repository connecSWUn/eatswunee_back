package com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller;

import com.swulab.eatswunee.domain.chatroom.application.port.in.FindChatRoomUseCase;
import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindChatRoomController {

  private final FindChatRoomUseCase findChatRoomUseCase;

  @GetMapping("/chat")
  public List<ChatRoom> findAllRoom() {
    return findChatRoomUseCase.findAllRoom();
  }

}
