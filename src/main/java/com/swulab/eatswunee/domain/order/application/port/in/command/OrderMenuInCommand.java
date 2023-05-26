package com.swulab.eatswunee.domain.order.application.port.in.command;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderMenuInCommand {

  private Long menuId;
  private int menuCnt;

  public OrderMenuInCommand(Long menuId, int menuCnt) {
    this.menuId = menuId;
    this.menuCnt = menuCnt;
  }
}
