package com.swulab.eatswunee.domain.order.application.service;

import com.swulab.eatswunee.domain.order.application.port.in.GetRestaurantOrderListUseCase;
import com.swulab.eatswunee.domain.order.application.port.out.FindRestaurantOrderListPort;
import com.swulab.eatswunee.domain.order.application.port.out.command.FindRestaurantOrderListCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetRestaurantOrderListService implements GetRestaurantOrderListUseCase {

  private final FindRestaurantOrderListPort findRestaurantOrderListPort;


  @Override
  public FindRestaurantOrderListCommand getRestaurantOrderList(Long orderId) {

    return findRestaurantOrderListPort.findRestaurantOrderList(orderId);
  }
}
