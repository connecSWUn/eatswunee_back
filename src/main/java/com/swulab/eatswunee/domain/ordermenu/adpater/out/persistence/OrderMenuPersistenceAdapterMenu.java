package com.swulab.eatswunee.domain.ordermenu.adpater.out.persistence;

import com.swulab.eatswunee.domain.ordermenu.application.port.out.FindOrderMenuPort;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.FindRestaurantOrderMenuCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMenuPersistenceAdapterMenu implements FindOrderMenuPort {

  private final OrderMenuQueryRepository orderMenuQueryRepository;

  @Override
  public List<FindRestaurantOrderMenuCommand> getOrderPort(Long orderId) {

    return orderMenuQueryRepository.findOrderMenu(orderId);
  }


}
