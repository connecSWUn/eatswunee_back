package com.swulab.eatswunee.domain.menu.application.port.in.command;

import com.swulab.eatswunee.domain.menu.domain.model.Menu;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetMenuCommand {

  private Long menuId;
  private String menuImg;
  private String RestaurantName;
  private String menuName;
  private int menuPrice;
  private double menuRating;
  private Integer menuReviewCnt;

  public GetMenuCommand(Menu menu, List<Integer> ratingList, String restaurantName) {
    this.menuId = menu.getMenuId();
    this.menuImg = menu.getImageUrl();
    this.RestaurantName = restaurantName;
    this.menuName = menu.getName();
    this.menuPrice = menu.getPrice();
    this.menuRating = calMenuAvgRating(ratingList);
    this.menuReviewCnt = ratingList.size();
  }

  private double calMenuAvgRating(List<Integer> ratingList) {
     return ratingList.stream().mapToInt(rating -> rating).average().orElse(0);
  }

  public void setMenuImg(String menuImg) {
    this.menuImg = menuImg;
  }
}
