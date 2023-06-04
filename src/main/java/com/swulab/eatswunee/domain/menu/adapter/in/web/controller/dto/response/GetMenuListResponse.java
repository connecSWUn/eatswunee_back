package com.swulab.eatswunee.domain.menu.adapter.in.web.controller.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuListCommand;
import com.swulab.eatswunee.domain.menu.application.port.out.command.FindMenuListCommand;
import com.swulab.eatswunee.domain.order.application.port.out.command.FindNowOrderCommand;
import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import com.swulab.eatswunee.global.config.AvgScoreSerializer;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetMenuListResponse {

  private List<NowOrderCommand> orders;
  private List<RestaurantCommand> restaurants;
  private List<MenuListCommand> menus;


  public GetMenuListResponse(GetMenuListCommand command) {
    this.orders = command.getOrderCommandList().stream().map(NowOrderCommand::new).toList();
    this.restaurants = command.getRestaurantCommandList().stream().map(RestaurantCommand::new).toList();
    this.menus = command.getMenuCommandList().stream().map(MenuListCommand::new).toList();
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  private class NowOrderCommand {
    private Long orderId;
    private int orderNum;
    private Long restaurantId;
    private int expectedWaitingTime;

    public NowOrderCommand(FindNowOrderCommand command) {
      this.orderId = command.getOrderId();
      this.orderNum = command.getOrderNum();
      this.restaurantId = command.getRestaurantId();
      this.expectedWaitingTime = command.getExpectedWaitingTime();
    }
  }
  @Getter
  @NoArgsConstructor
  private class RestaurantCommand {

    private Long restaurantId;
    private String name;

    public RestaurantCommand(Restaurant restaurant) {
      this.restaurantId = restaurant.getRestaurantId();
      this.name = restaurant.getName();
    }
  }

  @Getter
  @NoArgsConstructor
  private class MenuListCommand {

    private Long menuId;
    private String restaurantName;
    private String menuImg;
    private String menuName;
    private int menuPrice;
    @JsonSerialize(using = AvgScoreSerializer.class)
    private Double menuRating;

    public MenuListCommand(FindMenuListCommand command) {
      this.menuId = command.getMenuId();
      this.restaurantName = command.getRestaurantName();
      this.menuImg = command.getMenuImg();
      this.menuName = command.getMenuName();
      this.menuPrice = command.getMenuPrice();
      this.menuRating = command.getMenuRating();
    }
  }

}
