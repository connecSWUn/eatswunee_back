package com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller;

import com.swulab.eatswunee.domain.chatroom.adapter.in.dto.response.GetChatMessagesResponse;
import com.swulab.eatswunee.domain.chatroom.application.port.in.GetChatMessagesUseCase;
import com.swulab.eatswunee.domain.chatroom.application.port.in.GetUserChatRoomListUseCase;
import com.swulab.eatswunee.domain.chatroom.application.port.in.command.GetChatMessagesCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetChatMessagesController {

  private final GetChatMessagesUseCase getChatMessagesUseCase;
  private final GetUserChatRoomListUseCase getUserChatRoomListUseCase;


  @GetMapping("/chat/enter/{chatRoomId}")
  public ResponseEntity getChatMessages2UseCase(@AuthenticationPrincipal UserDetails userDetails, @PathVariable String chatRoomId) {

    long guestId = Long.parseLong(userDetails.getUsername());


    GetChatMessagesCommand command = getChatMessagesUseCase.getChatMessages(guestId, chatRoomId);
    GetChatMessagesResponse response = new GetChatMessagesResponse(command, getUserChatRoomListUseCase.getUserChatRoomList(guestId).size());

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }

}
