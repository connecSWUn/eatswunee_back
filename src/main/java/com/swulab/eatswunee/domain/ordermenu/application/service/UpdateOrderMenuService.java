package com.swulab.eatswunee.domain.ordermenu.application.service;

import com.swulab.eatswunee.domain.ordermenu.application.port.in.UpdateOrderMenuStatusUseCase;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.UpdateOrderMenuStatusCommand;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.FindOrderMenuPort;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.SaveOrderMenuPort;
import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenu;
import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenuStatus;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateOrderMenuService implements UpdateOrderMenuStatusUseCase {

  private final FindOrderMenuPort findOrderMenuPort;
  private final SaveOrderMenuPort saveOrderMenuPort;

  @Override
  public UpdateOrderMenuStatusCommand updateOrderMenuStatus(Long restaurantId, Long orderId, OrderMenuStatus orderMenuStatus) {

    List<OrderMenu> orderMenus = findOrderMenuPort.findOrderMenus(restaurantId, orderId); // 여기서 식당도 걸러줘야함.
    orderMenus.forEach(orderMenu -> orderMenu.changeOrderMenuStatusTo(orderMenuStatus));
    saveOrderMenuPort.saveOrderMenus(orderMenus);

    return new UpdateOrderMenuStatusCommand(orderId, orderMenuStatus);
  }
}
