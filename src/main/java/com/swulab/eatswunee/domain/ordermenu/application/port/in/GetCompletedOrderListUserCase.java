package com.swulab.eatswunee.domain.ordermenu.application.port.in;

import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.RestaurantNowOrderListCommand;
import java.util.List;

public interface GetCompletedOrderListUserCase {

  List<RestaurantNowOrderListCommand> getCompletedOrderList(Long sellerId);

}
