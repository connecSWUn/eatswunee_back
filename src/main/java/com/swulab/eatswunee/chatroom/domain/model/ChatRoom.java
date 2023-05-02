package com.swulab.eatswunee.chatroom.domain.model;

import com.swulab.eatswunee.recruit.domain.model.Recruit;
import com.swulab.eatswunee.user.domain.model.User;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ChatRoom {

  private Long chatRoomId;
  private LocalDateTime createdAt;
  private User user;
  private Recruit recruit;

}
