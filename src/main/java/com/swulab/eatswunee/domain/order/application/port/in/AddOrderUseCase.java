package com.swulab.eatswunee.domain.order.application.port.in;

import com.swulab.eatswunee.domain.order.application.port.in.command.OrderMenuInCommand;
import java.util.List;

public interface AddOrderUseCase {
  Long addOrder(Long userId, List<OrderMenuInCommand> request);

}
