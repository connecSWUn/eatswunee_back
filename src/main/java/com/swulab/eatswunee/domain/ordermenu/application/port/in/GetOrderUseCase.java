package com.swulab.eatswunee.domain.ordermenu.application.port.in;

import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.GetOrderMenuCommand;

public interface GetOrderUseCase {

  GetOrderMenuCommand getOrder(Long orderId);

  Long getUserIdOfOrder(Long orderId);

}
