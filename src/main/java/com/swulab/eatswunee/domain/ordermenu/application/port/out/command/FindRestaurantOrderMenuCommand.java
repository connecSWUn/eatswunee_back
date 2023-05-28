package com.swulab.eatswunee.domain.ordermenu.application.port.out.command;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FindRestaurantOrderMenuCommand {

  private Long restaurantId;
  private String restaurantName;
  private List<FindMenuCommand> menus;

  public FindRestaurantOrderMenuCommand(Long restaurantId, String restaurantName, List<FindMenuCommand> menus) {
    this.restaurantId = restaurantId;
    this.restaurantName = restaurantName;
    this.menus = menus;
  }

  @Getter
  @NoArgsConstructor
  public static class FindMenuCommand {

    private String menuName;
    private Integer menuPrice;
    private Integer menuCnt;


    public FindMenuCommand(Integer menuCnt, String menuName, Integer menuPrice) {
      this.menuCnt = menuCnt;
      this.menuName = menuName;
      this.menuPrice = menuPrice;
    }

  }

}
