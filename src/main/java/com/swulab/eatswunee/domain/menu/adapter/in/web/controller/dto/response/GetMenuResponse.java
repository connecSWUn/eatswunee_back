package com.swulab.eatswunee.domain.menu.adapter.in.web.controller.dto.response;

import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetMenuResponse {

  private Long menuId;
  private String RestaurantName;
  private String menuName;
  private int menuPrice;
  private double menuRating;
  private Integer menuReviewCnt;

  public GetMenuResponse(GetMenuCommand command) {
    this.menuId = command.getMenuId();
    this.RestaurantName = command.getRestaurantName();
    this.menuName = command.getMenuName();
    this.menuPrice = command.getMenuPrice();
    this.menuRating = command.getMenuRating();
    this.menuReviewCnt = command.getMenuReviewCnt();
  }
}
