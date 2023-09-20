package com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller.command;

import com.swulab.eatswunee.domain.chatroom.application.port.out.command.LastChatMessage;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserChatRoomCommand {

  private String chatRoomId;
  private String recruitTitle;
  private String senderNickname;
  private String senderProfileImgUrl;

  private LocalDateTime lastChatCreatedAt;
  private String lastChatMessage;


  public UserChatRoomCommand(String chatRoomId, String recruitTitle, String senderNickname,
      String senderProfileImgUrl) {
    this.chatRoomId = chatRoomId;
    this.recruitTitle = recruitTitle;
    this.senderNickname = senderNickname;
    this.senderProfileImgUrl = senderProfileImgUrl;
  }

  public void getChatMessage(LastChatMessage message) {
    if (message != null) {
      this.lastChatCreatedAt = message.getLastChatCreatedAt();
      this.lastChatMessage = message.getLastChatMessage();
    }

  }

  public void mapToUrl(String url) {
    this.senderProfileImgUrl = url;
  }
}
