package com.swulab.eatswunee.domain.menu.application.port.in;

import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuListCommand;

public interface GetMenuListUseCase {

  GetMenuListCommand getMenuList(Long restaurantId);

}
