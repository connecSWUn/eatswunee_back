package com.swulab.eatswunee.domain.menu.application.port.out;

import com.swulab.eatswunee.domain.menu.domain.model.Menu;

public interface FindMenuPort {

  Menu findMenu(Long menuId);

}
