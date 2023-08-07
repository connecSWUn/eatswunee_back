package com.swulab.eatswunee.domain.ordermenu.application.service;

import com.swulab.eatswunee.domain.ordermenu.application.port.in.UpdateOrderMenuStatusUseCase;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.UpdateOrderMenuStatusCommand;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.FindOrderMenuPort;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.SaveOrderMenuPort;
import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenu;
import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenuStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateOrderMenuService implements UpdateOrderMenuStatusUseCase {

  private final FindOrderMenuPort findOrderMenuPort;
  private final SaveOrderMenuPort saveOrderMenuPort;

  @Override
  public UpdateOrderMenuStatusCommand updateOrderMenuStatus(Long orderMenuId, OrderMenuStatus orderMenuStatus) {

    OrderMenu orderMenu = findOrderMenuPort.findOrderMenuPort(orderMenuId);
    orderMenu.changeOrderMenuStatusTo(orderMenuStatus);
    OrderMenu savedOrderMenu = saveOrderMenuPort.saveOrderMenu(orderMenu);

    return new UpdateOrderMenuStatusCommand(savedOrderMenu.getOrderMenuId(), savedOrderMenu.getOrderMenuStatus());

  }
}
