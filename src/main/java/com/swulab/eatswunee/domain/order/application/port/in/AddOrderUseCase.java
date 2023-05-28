package com.swulab.eatswunee.domain.order.application.port.in;

import com.swulab.eatswunee.domain.order.application.port.in.command.AddOrderCommand;
import java.util.List;

public interface AddOrderUseCase {
  Long addOrder(Long userId, List<AddOrderCommand> request);

}
