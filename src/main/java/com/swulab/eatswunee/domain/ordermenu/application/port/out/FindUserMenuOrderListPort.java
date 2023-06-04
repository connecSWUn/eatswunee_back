package com.swulab.eatswunee.domain.ordermenu.application.port.out;

import com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd.UserOrderMenuCommand;
import java.util.List;

public interface FindUserMenuOrderListPort {

  List<UserOrderMenuCommand> findUserMenuOrderList(Long userId);


}
