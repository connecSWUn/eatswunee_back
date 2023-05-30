package com.swulab.eatswunee.domain.order.application.port.in;

import com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd.UserOrderCommand;
import java.util.List;

public interface GetOrderMenuUseCase {

  List<UserOrderCommand> getOrderMenuList(Long userId);

}
