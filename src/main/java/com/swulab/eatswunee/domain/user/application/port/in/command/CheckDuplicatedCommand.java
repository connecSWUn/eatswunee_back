package com.swulab.eatswunee.domain.user.application.port.in.command;

import lombok.Getter;

@Getter
public class CheckDuplicatedCommand {

  private Boolean isDuplicated;

  public CheckDuplicatedCommand(Boolean isDuplicated) {
    this.isDuplicated = isDuplicated;
  }
}
