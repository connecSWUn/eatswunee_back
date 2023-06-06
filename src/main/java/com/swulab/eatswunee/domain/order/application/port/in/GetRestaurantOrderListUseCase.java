package com.swulab.eatswunee.domain.order.application.port.in;

import com.swulab.eatswunee.domain.order.application.port.out.command.FindRestaurantOrderListCommand;

public interface GetRestaurantOrderListUseCase {

  FindRestaurantOrderListCommand getRestaurantOrderList(Long orderId);

}
