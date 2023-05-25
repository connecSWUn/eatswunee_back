package com.swulab.eatswunee.domain.menu.application.port.out;

import com.swulab.eatswunee.domain.menu.application.port.out.command.FindMenuListCommand;
import com.swulab.eatswunee.domain.menu.domain.model.Menu;
import java.util.List;

public interface FindMenuPort {

  Menu findMenu(Long menuId);

  List<FindMenuListCommand> findMenuListByRestaurantId(Long restaurantId);

}
