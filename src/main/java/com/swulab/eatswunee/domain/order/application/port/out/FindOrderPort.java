package com.swulab.eatswunee.domain.order.application.port.out;

import com.swulab.eatswunee.domain.order.domain.model.Order;
import java.util.List;

public interface FindOrderPort {

  Order findOrder(Long orderId);

  List<Order> findAllByUserId(Long userId);

}
