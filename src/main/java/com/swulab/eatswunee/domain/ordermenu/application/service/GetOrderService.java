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
    List<OrderMenuCommand> orderMenuCommands = createOrderMenuCommands(orderId);

    return new GetOrderMenuCommand(order.getOrderNum(), order.getOrderCreatedAt(), orderMenuCommands);
  }

  /**
   * orderId를 사용해 OrderMenuCommand 리스트를 생성하는 함수
   * @param orderId 주문 아이디
   * @return List<OrderMenuCommand>
   */
  private List<OrderMenuCommand> createOrderMenuCommands(Long orderId) {
    List<FindRestaurantOrderMenuCommand> findRestaurantOrderMenuCommands = findOrderMenuPort.getOrderPort(orderId);
    return findRestaurantOrderMenuCommands.stream().map(
        command -> {
          List<MenuCommand> menuCommands = command.getMenus().stream().map(MenuCommand::new)
              .toList();
          return new OrderMenuCommand(command.getRestaurantName(), menuCommands);
        }
    ).toList();
  }
}
