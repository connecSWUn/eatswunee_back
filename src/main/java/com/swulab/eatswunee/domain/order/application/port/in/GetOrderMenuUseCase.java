package com.swulab.eatswunee.domain.order.application.port.in;

import com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd.UserOrderMenuCommand;
import java.util.List;

public interface GetOrderMenuUseCase {

  List<UserOrderMenuCommand> getOrderMenuList(Long userId);

}
