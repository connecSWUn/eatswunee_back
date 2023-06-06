package com.swulab.eatswunee.domain.order.application.port.out.command;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FindRestaurantOrderListCommand {

  private Long orderId;
  private Integer orderNum;
  private List<FindRestaurantOrderMenuCommand> menus;

  public FindRestaurantOrderListCommand(Long orderId, Integer orderNum,
      List<FindRestaurantOrderMenuCommand> menus) {
    this.orderId = orderId;
    this.orderNum = orderNum;
    this.menus = menus;
  }

  @Getter
  @NoArgsConstructor
  public static class FindRestaurantOrderMenuCommand {

    private String menuName;
    private Integer menuCnt;

    public FindRestaurantOrderMenuCommand(String menuName, Integer menuCnt) {
      this.menuName = menuName;
      this.menuCnt = menuCnt;
    }
  }


}
