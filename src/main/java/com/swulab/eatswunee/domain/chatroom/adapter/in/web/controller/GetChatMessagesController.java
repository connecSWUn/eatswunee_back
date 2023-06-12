package com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller;

import com.swulab.eatswunee.domain.chatroom.adapter.in.dto.response.GetChatMessagesResponse;
import com.swulab.eatswunee.domain.chatroom.application.port.in.GetChatMessagesUseCase;
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

  @GetMapping("/chat/enter/{recruitId}")
  public ResponseEntity getChatMessagesUseCase(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long recruitId) {

    GetChatMessagesCommand command = getChatMessagesUseCase.getChatMessages(Long.parseLong(userDetails.getUsername()), recruitId);
    GetChatMessagesResponse response = new GetChatMessagesResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }

}
