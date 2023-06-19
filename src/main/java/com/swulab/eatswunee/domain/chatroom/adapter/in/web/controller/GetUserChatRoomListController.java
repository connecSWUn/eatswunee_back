package com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller;

import com.swulab.eatswunee.domain.chatroom.adapter.in.dto.response.UserChatRoomListResponse;
import com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller.command.UserChatRoomCommand;
import com.swulab.eatswunee.domain.chatroom.application.port.in.GetUserChatRoomListUseCase;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import com.swulab.eatswunee.global.common.application.port.in.GetImageUrlUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetUserChatRoomListController {

  private final GetUserChatRoomListUseCase getUserChatRoomListUseCase;
  private final GetImageUrlUseCase getImageUrlUseCase;

  @GetMapping("/user/chatroom/list")
  public ResponseEntity GetUserChatRoomList(@AuthenticationPrincipal UserDetails userDetails) {
    List<UserChatRoomCommand> commands = getUserChatRoomListUseCase.getUserChatRoomList(Long.parseLong(userDetails.getUsername()));
    commands.forEach(
        command -> {
          command.mapToUrl(getImageUrlUseCase.getImageUrl("user_profile/" + command.getSenderProfileImgUrl()));
        }
    );
    UserChatRoomListResponse response = new UserChatRoomListResponse(commands);
    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }



}
