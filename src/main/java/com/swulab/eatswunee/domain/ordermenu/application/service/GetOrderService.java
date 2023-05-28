package com.swulab.eatswunee.domain.ordermenu.application.service;

import com.swulab.eatswunee.domain.order.application.port.out.FindOrderPort;
import com.swulab.eatswunee.domain.order.domain.model.Order;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.GetOrderMenuCommand;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.GetOrderUseCase;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.MenuCommand;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.OrderMenuCommand;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.FindOrderMenuPort;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.FindRestaurantOrderMenuCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOrderService implements GetOrderUseCase {

  private final FindOrderMenuPort findOrderMenuPort;
  private final FindOrderPort findOrderPort;

  @Override
  public GetOrderMenuCommand getOrder(Long orderId) {

    Order order = findOrderPort.findOrder(orderId);

    List<FindRestaurantOrderMenuCommand> findRestaurantOrderMenuCommands = findOrderMenuPort.getOrderPort(orderId);

    List<OrderMenuCommand> orderMenuCommands = findRestaurantOrderMenuCommands.stream().map(
        command -> {
          List<MenuCommand> menuCommands = command.getMenus().stream().map(MenuCommand::new)
              .toList();
          return new OrderMenuCommand(command.getRestaurantName(), menuCommands);
        }
    ).toList();

    return new GetOrderMenuCommand(order.getOrderNum(), order.getOrderCreatedAt(), orderMenuCommands);
  }
}
