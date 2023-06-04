package com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd;


import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserOrderMenuCommand {


  private Long orderMenuId;
  private LocalDateTime orderCreatedAt;
  private String restaurantName;
  private String menuName;
  private int menuTotalPrice;
  private int menuPrice;
  private int menuCnt;
  private boolean isUserWriteReview;

  public UserOrderMenuCommand(Long orderMenuId, LocalDateTime orderCreatedAt,
      String restaurantName, String menuName, int menuPrice, int menuCnt) {
    this.orderMenuId = orderMenuId;
    this.orderCreatedAt = orderCreatedAt;
    this.restaurantName = restaurantName;
    this.menuName = menuName;
    this.menuPrice = menuPrice;
    this.menuCnt = menuCnt;
    this.menuTotalPrice = menuPrice * menuCnt;
  }

  public void setIsUserWriteReview(boolean setIsUserWriteReview) {
    this.isUserWriteReview = setIsUserWriteReview;
  }
}
