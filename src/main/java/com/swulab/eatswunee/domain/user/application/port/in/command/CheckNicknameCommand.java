package com.swulab.eatswunee.domain.user.application.port.in.command;

import lombok.Getter;

@Getter
public class CheckNicknameCommand {

  private Boolean isDuplicated;

  public CheckNicknameCommand(Boolean isDuplicated) {
    this.isDuplicated = isDuplicated;
  }
}
