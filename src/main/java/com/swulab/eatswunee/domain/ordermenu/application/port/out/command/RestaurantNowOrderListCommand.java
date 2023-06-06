package com.swulab.eatswunee.domain.ordermenu.application.port.out.command;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RestaurantNowOrderListCommand {

  private Long orderId;
  private int orderNum;
  private LocalDateTime orderCreatedAt;
  private List<RestaurantOrderMenuCommand> menus;

  public RestaurantNowOrderListCommand(Long orderId, int orderNum,
      LocalDateTime orderCreatedAt,
      List<RestaurantOrderMenuCommand> menus) {
    this.orderId = orderId;
    this.orderNum = orderNum;
    this.orderCreatedAt = orderCreatedAt;
    this.menus = menus;
  }

  @Getter
  @NoArgsConstructor
  public static class RestaurantOrderMenuCommand {

    private String menuName;
    private int menuCnt;

    public RestaurantOrderMenuCommand(String menuName, int menuCnt) {
      this.menuName = menuName;
      this.menuCnt = menuCnt;
    }
  }



}
