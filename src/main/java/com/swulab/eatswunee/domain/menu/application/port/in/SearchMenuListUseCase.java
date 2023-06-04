package com.swulab.eatswunee.domain.menu.application.port.in;

import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuListCommand;

public interface SearchMenuListUseCase {

  GetMenuListCommand searchMenuList(Long restaurantId, String keyword, Long userId);

}
