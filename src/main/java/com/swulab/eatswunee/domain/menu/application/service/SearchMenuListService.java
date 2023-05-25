package com.swulab.eatswunee.domain.menu.application.service;

import com.swulab.eatswunee.domain.menu.application.port.in.SearchMenuListUseCase;
import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuListCommand;
import com.swulab.eatswunee.domain.menu.application.port.out.FindMenuPort;
import com.swulab.eatswunee.domain.menu.application.port.out.command.FindMenuListCommand;
import com.swulab.eatswunee.domain.restaurant.application.port.out.FindRestaurantPort;
import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import com.swulab.eatswunee.domain.restaurant.domain.model.RestaurantSpot;
import com.swulab.eatswunee.domain.review.application.port.out.FindReviewRatingByMenuIdPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchMenuListService implements SearchMenuListUseCase {

  private final FindRestaurantPort findRestaurantPort;
  private final FindMenuPort findMenuPort;
  private final FindReviewRatingByMenuIdPort findReviewRatingByMenuIdPort;

  @Override
  public GetMenuListCommand searchMenuList(Long restaurantId, String keyword) {

    // TODO : ORDER
    List<Restaurant> restaurant = findRestaurantPort.findRestaurant(RestaurantSpot.gusia);
    List<FindMenuListCommand> menuList =
        findMenuPort.findMenuListByRestaurantIdAndKeyword(restaurantId, keyword);
    setMenuRating(menuList);

    return new GetMenuListCommand(restaurant, menuList);
  }

  //TODO : 쿼리 변경 필요
  private void setMenuRating(List<FindMenuListCommand> menuListCommands) {
    menuListCommands.forEach(
        menu -> {
          List<Integer> menuRatings = findReviewRatingByMenuIdPort.findMenuRatingByMenuId(
              menu.getMenuId());
          double menuRating = menuRatings.stream().mapToInt(score -> score).average()
              .orElseGet(() -> 0.0);
          menu.setMenuRating(menuRating);
        }
    );
  }

}
