package com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserOrderMenuCommand {

  private Long orderMenuId;
  private Long menuId;
  private String restaurantName;
  private String menuName;
  private int menuTotalPrice;
  private boolean isUserWriteReview;

  public UserOrderMenuCommand(Long orderMenuId, Long menuId, String restaurantName,
      String menuName, int menuPrice, int menuCnt) {
    this.orderMenuId = orderMenuId;
    this.menuId = menuId;
    this.restaurantName = restaurantName;
    this.menuName = menuName;
    this.menuTotalPrice = menuPrice * menuCnt;
  }

  public void setIsUserWriteReview(boolean setIsUserWriteReview) {
    this.isUserWriteReview = setIsUserWriteReview;
  }
}
