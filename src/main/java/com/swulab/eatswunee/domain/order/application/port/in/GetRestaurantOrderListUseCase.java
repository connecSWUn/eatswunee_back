package com.swulab.eatswunee.domain.order.application.port.in;

import com.swulab.eatswunee.domain.order.application.port.out.command.FindRestaurantOrderListCommand;
import com.swulab.eatswunee.domain.order.application.port.out.command.FindRestaurantOrderListFixCommand;
import java.util.List;

public interface GetRestaurantOrderListUseCase {

  FindRestaurantOrderListCommand getRestaurantOrderList(Long orderId, Long restaurantId);
  List<FindRestaurantOrderListFixCommand> getRestaurantOrderListFix(Long orderId);

}
