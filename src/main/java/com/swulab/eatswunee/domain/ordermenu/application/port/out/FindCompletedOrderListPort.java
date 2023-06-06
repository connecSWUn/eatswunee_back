package com.swulab.eatswunee.domain.ordermenu.application.port.out;

import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.RestaurantNowOrderListCommand;
import java.util.List;

public interface FindCompletedOrderListPort {

  List<RestaurantNowOrderListCommand> findCompletedOrderList(Long restaurantId);

}
