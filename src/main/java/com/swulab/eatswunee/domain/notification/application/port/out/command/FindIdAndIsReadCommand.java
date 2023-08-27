package com.swulab.eatswunee.domain.notification.application.port.out.command;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FindIdAndIsReadCommand {

  private Long notificationId;
  private Boolean isRead;

  public FindIdAndIsReadCommand(Long notificationId, Boolean isRead) {
    this.notificationId = notificationId;
    this.isRead = isRead;
  }
}
