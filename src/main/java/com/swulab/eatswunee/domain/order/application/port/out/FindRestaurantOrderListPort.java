package com.swulab.eatswunee.domain.order.application.port.out;

import com.swulab.eatswunee.domain.order.application.port.out.command.FindRestaurantOrderListCommand;
import com.swulab.eatswunee.domain.order.application.port.out.command.FindRestaurantOrderListFixCommand;
import java.util.List;

public interface FindRestaurantOrderListPort {

  FindRestaurantOrderListCommand findRestaurantOrderList(Long orderId);

  List<FindRestaurantOrderListFixCommand> findRestaurantOrderListFix(Long orderId);

}
