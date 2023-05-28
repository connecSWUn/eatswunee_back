package com.swulab.eatswunee.domain.order.application.port.in.command;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddOrderCommand {

  private Long menuId;
  private int menuCnt;

  public AddOrderCommand(Long menuId, int menuCnt) {
    this.menuId = menuId;
    this.menuCnt = menuCnt;
  }
}
