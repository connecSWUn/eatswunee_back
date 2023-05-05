package com.swulab.eatswunee.chatroom.domain.model;

import com.swulab.eatswunee.recruit.domain.model.Recruit;
import com.swulab.eatswunee.user.domain.model.User;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ChatRoom {

  private Long chatRoomId;
  private LocalDateTime createdAt;
  private User user;
  private Recruit recruit;

  @Builder
  public ChatRoom(Long chatRoomId, LocalDateTime createdAt,
      User user, Recruit recruit) {
    this.chatRoomId = chatRoomId;
    this.createdAt = createdAt;
    this.user = user;
    this.recruit = recruit;
  }
}
