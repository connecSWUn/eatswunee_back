package com.swulab.eatswunee.domain.order.application.service;

import com.swulab.eatswunee.domain.menu.application.port.out.FindMenuPort;
import com.swulab.eatswunee.domain.menu.domain.model.Menu;
import com.swulab.eatswunee.domain.order.application.port.in.AddOrderUseCase;
import com.swulab.eatswunee.domain.order.application.port.in.command.AddOrderCommand;
import com.swulab.eatswunee.domain.order.application.port.out.SaveOrderPort;
import com.swulab.eatswunee.domain.order.domain.model.Order;
import com.swulab.eatswunee.domain.order.domain.model.OrderStatus;
import com.swulab.eatswunee.domain.ordermenu.domain.model.OrderMenu;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddOrderService implements AddOrderUseCase {

  private final SaveOrderPort saveOrderPort;
  private final FindUserPort findUserPort;
  private final FindMenuPort findMenuPort;
  private int orderNum = 1;

  @Override
  public Long addOrder(Long userId, List<AddOrderCommand> commands) {

    User user = findUserPort.findUser(userId);

    Order order = Order.builder()
        .orderNum(orderNum++)
        .orderStatus(OrderStatus.ONGOING)
        .user(user)
        .build();

    List<OrderMenu> orderMenus = commands.stream()
        .map(
            command -> {

              Menu menu = findMenuPort.findMenu(command.getMenuId());

              return OrderMenu.builder()
                  .menuCnt(command.getMenuCnt())
                  .orderPrice(menu.getPrice())
                  .order(order)
                  .menu(menu)
                  .build();
            }
        ).toList();

    order.updateOrderMenus(orderMenus);

    return saveOrderPort.saveOrder(order);
  }
}
