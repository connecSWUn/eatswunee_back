package com.swulab.eatswunee.domain.order.application.port.out;

import com.swulab.eatswunee.domain.order.application.port.out.command.FindRestaurantOrderListCommand;

public interface FindRestaurantOrderListPort {

  FindRestaurantOrderListCommand findRestaurantOrderList(Long orderId);

}
