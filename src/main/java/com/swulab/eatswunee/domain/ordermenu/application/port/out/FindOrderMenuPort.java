package com.swulab.eatswunee.domain.ordermenu.application.port.out;

import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.FindRestaurantOrderMenuCommand;
import java.util.List;

public interface FindOrderMenuPort {

  List<FindRestaurantOrderMenuCommand> getOrderPort(Long orderId);

}
