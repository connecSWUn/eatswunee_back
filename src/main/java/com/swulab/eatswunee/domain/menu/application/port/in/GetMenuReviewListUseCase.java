package com.swulab.eatswunee.domain.menu.application.port.in;

import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuReviewListCommand;

public interface GetMenuReviewListUseCase {

  GetMenuReviewListCommand getMenuReviewList(Long menuId);

}
