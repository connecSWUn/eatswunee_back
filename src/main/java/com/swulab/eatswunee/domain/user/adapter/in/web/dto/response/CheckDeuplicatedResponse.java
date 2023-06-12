package com.swulab.eatswunee.domain.user.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.user.application.port.in.command.CheckDuplicatedCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CheckDeuplicatedResponse {

  private Boolean is_duplicated;

  public CheckDeuplicatedResponse(CheckDuplicatedCommand command) {
    this.is_duplicated = command.getIsDuplicated();
  }

}
