package com.swulab.eatswunee.domain.menu.application.service;

import com.swulab.eatswunee.domain.menu.application.port.in.GetMenuUseCase;
import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuCommand;
import com.swulab.eatswunee.domain.menu.application.port.out.FindMenuPort;
import com.swulab.eatswunee.domain.menu.domain.model.Menu;
import com.swulab.eatswunee.domain.review.application.port.out.FindReviewRatingByMenuIdPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMenuService implements GetMenuUseCase {

  private final FindReviewRatingByMenuIdPort findReviewRatingByMenuIdPort;
  private final FindMenuPort findMenuPort;

  @Override
  public GetMenuCommand getMenu(Long menuId) {

    List<Integer> ratingList = findReviewRatingByMenuIdPort.findMenuRatingByMenuId(menuId);
    Menu menu = findMenuPort.findMenu(menuId);
    String restaurantName = menu.getRestaurant().getName();

    return new GetMenuCommand(menu, ratingList, restaurantName);
  }
}
