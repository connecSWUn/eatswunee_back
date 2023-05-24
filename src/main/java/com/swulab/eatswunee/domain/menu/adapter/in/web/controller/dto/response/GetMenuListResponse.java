package com.swulab.eatswunee.domain.menu.adapter.in.web.controller.dto.response;

import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuListCommand;
import com.swulab.eatswunee.domain.menu.application.port.out.command.FindMenuListCommand;
import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetMenuListResponse {


  private List<RestaurantCommand> restaurants;
  private List<FindMenuListCommand> menus;


  public GetMenuListResponse(GetMenuListCommand command) {
    this.restaurants = command.getRestaurantCommandList().stream().map(RestaurantCommand::new).toList();
    this.menus = command.getMenuCommandList();
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
}
