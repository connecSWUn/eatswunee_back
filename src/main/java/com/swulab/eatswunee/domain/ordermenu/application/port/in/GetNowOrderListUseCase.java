package com.swulab.eatswunee.domain.ordermenu.application.port.in;

import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.RestaurantNowOrderListCommand;
import java.util.List;

public interface GetNowOrderListUseCase {

  List<RestaurantNowOrderListCommand> getNowOrderList(Long sellerId);

}
