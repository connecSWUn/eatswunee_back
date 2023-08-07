package com.swulab.eatswunee.domain.ordermenu.application.port.out;

import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenu;

public interface SaveOrderMenuPort {

  OrderMenu saveOrderMenu(OrderMenu orderMenu);

}
