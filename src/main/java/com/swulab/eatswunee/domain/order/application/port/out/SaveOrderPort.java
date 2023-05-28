package com.swulab.eatswunee.domain.order.application.port.out;

import com.swulab.eatswunee.domain.order.domain.model.Order;

public interface SaveOrderPort {

  Long saveOrder(Order order);

}
