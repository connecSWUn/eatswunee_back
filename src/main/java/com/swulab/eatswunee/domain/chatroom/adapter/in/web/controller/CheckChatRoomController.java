package com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller;

import com.swulab.eatswunee.domain.chatroom.adapter.in.dto.response.GetChatRoomResponse;
import com.swulab.eatswunee.domain.chatroom.application.port.in.ExistChatRoomUseCase;
import com.swulab.eatswunee.domain.chatroom.application.port.in.command.GetChatRoomCommand;
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
public class CheckChatRoomController {

  private final ExistChatRoomUseCase existChatRoomUseCase;

  @GetMapping("/chat/exist/{recruitId}")
  public ResponseEntity getChatRoom(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long recruitId) {

    GetChatRoomCommand command = existChatRoomUseCase.getChatRoom(Long.parseLong(userDetails.getUsername()), recruitId);
    GetChatRoomResponse response = new GetChatRoomResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }


}
