package com.swulab.eatswunee.domain.user.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.user.application.port.in.command.CheckNicknameCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CheckNicknameResponse {

  private Boolean is_duplicated;

  public CheckNicknameResponse(CheckNicknameCommand command) {
    this.is_duplicated = command.getIsDuplicated();
  }

}
