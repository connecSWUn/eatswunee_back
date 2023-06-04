package com.swulab.eatswunee.domain.menu.application.port.in.command;

import com.swulab.eatswunee.domain.menu.application.port.out.command.FindMenuListCommand;
import com.swulab.eatswunee.domain.order.application.port.out.command.FindNowOrderCommand;
import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetMenuListCommand {

  private List<FindNowOrderCommand> orderCommandList;
  private List<Restaurant> restaurantCommandList;
  private List<FindMenuListCommand> menuCommandList;


  public GetMenuListCommand(
      List<FindNowOrderCommand> orderCommandList,
      List<Restaurant> restaurantCommandList,
      List<FindMenuListCommand> menuCommandList) {
    this.orderCommandList = orderCommandList;
    this.restaurantCommandList = restaurantCommandList;
    this.menuCommandList = menuCommandList;
  }


}
