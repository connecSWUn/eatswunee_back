package com.swulab.eatswunee.domain.ordermenu.application.port.out;

import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenu;
import java.util.List;

public interface SaveOrderMenuPort {

  void saveOrderMenus(List<OrderMenu> orderMenus);

}
