package com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller;

import com.swulab.eatswunee.domain.chatroom.adapter.in.dto.response.CreateRoomResponse;
import com.swulab.eatswunee.domain.chatroom.application.port.in.AddChatRoomUseCase;
import com.swulab.eatswunee.domain.chatroom.application.service.ChatService;
import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChatController {

  private final ChatService chatService;
  private final AddChatRoomUseCase addChatRoomUseCase;

  @GetMapping("/chat/create/{recruitId}")
  public ResponseEntity createRoom(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long recruitId) {
    Long userId = Long.parseLong(userDetails.getUsername());
    ChatRoom chatRoom = addChatRoomUseCase.createRoom(userId, recruitId);
    CreateRoomResponse response = new CreateRoomResponse(chatRoom.getChatRoomId());
    return ResponseEntity.ok(SuccessResponse.create201SuccessResponse(response));
  }

  @GetMapping("/chat")
  public List<ChatRoom> findAllRoom() {
    return chatService.findAllRoom();
  }
}
