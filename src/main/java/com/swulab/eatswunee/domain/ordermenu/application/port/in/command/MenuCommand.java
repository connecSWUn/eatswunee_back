package com.swulab.eatswunee.domain.ordermenu.application.port.in.command;

import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.FindRestaurantOrderMenuCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuCommand {

  private String menuName;
  private int menuPrice;
  private int menuCnt;
  private int menuTotalPrice;

  public MenuCommand(FindRestaurantOrderMenuCommand.FindMenuCommand command) {
    this.menuName = command.getMenuName();
    this.menuPrice = command.getMenuPrice();
    this.menuCnt = command.getMenuCnt();
    this.menuTotalPrice = calMenuTotalPrice(command.getMenuCnt(), command.getMenuPrice());
  }

  private int calMenuTotalPrice(int menuCnt, int menuPrice) {
    return menuCnt * menuPrice;
  }
}
