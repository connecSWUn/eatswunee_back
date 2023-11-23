package com.swulab.eatswunee.domain.chatroom.adapter.in.dto.response;

import com.swulab.eatswunee.domain.chatroom.application.port.in.command.GetChatMessagesCommand;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class GetChatMessagesResponse {

  private RecruitStatus recruitStatus;
  private String recruit_title;
  private String recruit_spot;
  private LocalTime recruit_start_time;
  private LocalTime recruit_end_time;
  private LocalDateTime recruit_created_at;
  private String sender_name;

  private List<ChatMessageResponse> messages;

  private Integer chat_room_number;

  public GetChatMessagesResponse(GetChatMessagesCommand command, Integer chat_room_number) {
    this.recruitStatus = command.getRecruitStatus();
    this.recruit_title = command.getRecruitTitle();
    this.recruit_spot = command.getRecruitSpot();
    this.recruit_start_time = command.getRecruitStartTime();
    this.recruit_end_time = command.getRecruitEndTime();
    this.recruit_created_at = command.getRecruitCreatedAt();
    this.sender_name = command.getSenderName();

    this.messages = command.getCommandList().stream().map(ChatMessageResponse::new).toList();
    this.chat_room_number = chat_room_number;

  }

  @Getter
  @RequiredArgsConstructor(access = AccessLevel.PROTECTED)
  private class ChatMessageResponse {

    private LocalDateTime message_created_at;
    private String message_sender;
    private String message_content;
    private Boolean message_is_read;

    public ChatMessageResponse(GetChatMessagesCommand.ChatMessageCommand command) {
      this.message_created_at = command.getMessageCreatedAt();
      this.message_sender = command.getMessageSender();
      this.message_content = command.getMessageContent();
      this.message_is_read = command.getMessageIsRead();
    }
  }
}
