package com.swulab.eatswunee.domain.ordermenu.application.port.out;

import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.FindRestaurantOrderMenuCommand;
import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenu;
import java.util.List;

public interface FindOrderMenuPort {

  List<FindRestaurantOrderMenuCommand> getOrderPort(Long orderId);

  OrderMenu findOrderMenuPort(Long orderMenuId);

  List<OrderMenu> findOrderMenus(Long restaurantId, Long orderId);

}
