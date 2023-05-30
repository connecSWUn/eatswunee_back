package com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence;

import com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd.UserOrderMenuCommand;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.FindOrderMenuPort;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.FindUserMenuOrderListPort;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.FindRestaurantOrderMenuCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMenuPersistenceAdapter implements FindOrderMenuPort ,
    FindUserMenuOrderListPort {

  private final OrderMenuQueryRepository orderMenuQueryRepository;

  @Override
  public List<FindRestaurantOrderMenuCommand> getOrderPort(Long orderId) {

    return orderMenuQueryRepository.findOrderMenu(orderId);
  }


  @Override
  public List<UserOrderMenuCommand> findUserMenuOrderList(Long orderId) {

    return orderMenuQueryRepository.findUserOrderMenuList(orderId);
  }
}
