package com.swulab.eatswunee.domain.menu.application.port.out.command;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FindMenuListCommand {

  private Long menuId;
  private String restaurantName;
  private String menuImg;
  private String menuName;
  private int menuPrice;
  private Double menuRating;

  public FindMenuListCommand(Long menuId, String restaurantName,
      String menuImg, String menuName, int menuPrice) {
    this.menuId = menuId;
    this.restaurantName = restaurantName;
    this.menuImg = menuImg;
    this.menuName = menuName;
    this.menuPrice = menuPrice;
  }

  public void setMenuRating(Double menuRating) {
    this.menuRating = menuRating;
  }
}
