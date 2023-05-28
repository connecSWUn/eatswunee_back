package com.swulab.eatswunee.domain.ordermenu.application.port.in.command;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderMenuCommand {

  private String restaurantName;
  private int restaurantTotalPrice;
  private List<MenuCommand> menus;

  public OrderMenuCommand(String restaurantName, List<MenuCommand> menus) {
    this.restaurantName = restaurantName;
    this.restaurantTotalPrice = calRestaurantTotalPrice(menus);
    this.menus = menus;
  }

  private int calRestaurantTotalPrice(List<MenuCommand> commands) {
    return commands.stream().mapToInt(MenuCommand::getMenuTotalPrice).sum();
  }

}
