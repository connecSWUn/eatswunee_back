package com.swulab.eatswunee.domain.chatroom.adapter.in.dto.response;

import com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller.command.UserChatRoomCommand;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserChatRoomListResponse {

  private List<UserChatRoom> chatRooms;

  public UserChatRoomListResponse(List<UserChatRoomCommand> commands) {
    this.chatRooms = commands.stream().map(UserChatRoom::new).toList();
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class UserChatRoom {

    private Long chatRoom;
    private Long recruitId;
    private String recruitTitle;
    private String senderNickname;
    private String senderProfileImgUrl;

    private LocalDateTime lastChatCreatedAt;
    private String lastChatMessage;

    public UserChatRoom(UserChatRoomCommand command) {
      this.chatRoom = command.getChatRoomId();
      this.recruitId = Long.parseLong(chatRoom.toString().split("0")[1]);
      this.recruitTitle = command.getRecruitTitle();
      this.senderNickname = command.getSenderNickname();
      this.senderProfileImgUrl = command.getSenderProfileImgUrl();
      this.lastChatCreatedAt = command.getLastChatCreatedAt();
      this.lastChatMessage = command.getLastChatMessage();
    }
  }


}
