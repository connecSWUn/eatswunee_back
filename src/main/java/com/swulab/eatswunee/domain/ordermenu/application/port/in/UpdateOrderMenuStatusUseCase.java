package com.swulab.eatswunee.domain.ordermenu.application.port.in;

import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.UpdateOrderMenuStatusCommand;
import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenuStatus;

public interface UpdateOrderMenuStatusUseCase {

  UpdateOrderMenuStatusCommand updateOrderMenuStatus(Long orderMenuId, OrderMenuStatus orderMenuStatus);

}
