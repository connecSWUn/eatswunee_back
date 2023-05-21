package com.swulab.eatswunee.domain.menu.application.port.in;

import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuCommand;

public interface GetMenuUseCase {

  GetMenuCommand getMenu(Long menuId);

}
