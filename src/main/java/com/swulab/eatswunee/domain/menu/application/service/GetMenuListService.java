package com.swulab.eatswunee.domain.menu.application.service;

import com.swulab.eatswunee.domain.menu.application.port.in.GetMenuListUseCase;
import com.swulab.eatswunee.domain.menu.application.port.in.command.GetMenuListCommand;
import com.swulab.eatswunee.domain.menu.application.port.out.FindMenuPort;
import com.swulab.eatswunee.domain.menu.application.port.out.command.FindMenuListCommand;
import com.swulab.eatswunee.domain.order.application.port.out.FindNowOrderPort;
import com.swulab.eatswunee.domain.order.application.port.out.command.FindNowOrderCommand;
import com.swulab.eatswunee.domain.restaurant.application.port.out.FindRestaurantPort;
import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import com.swulab.eatswunee.domain.restaurant.domain.model.RestaurantSpot;
import com.swulab.eatswunee.domain.review.application.port.out.FindReviewRatingByMenuIdPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetMenuListService implements GetMenuListUseCase {

  private final FindRestaurantPort findRestaurantPort;
  private final FindMenuPort findMenuPort;
  private final FindReviewRatingByMenuIdPort findReviewRatingByMenuIdPort;
  private final FindNowOrderPort findNowOrderPort;

  @Override
  public GetMenuListCommand getMenuList(Long restaurantId, Long userId) {


    List<FindNowOrderCommand> nowOrders = findNowOrderPort.findNowOrderPort(userId);
    List<Restaurant> restaurant = findRestaurantPort.findRestaurant(RestaurantSpot.gusia);
    List<FindMenuListCommand> menuList = findMenuPort.findMenuListByRestaurantId(restaurantId);
    setMenuRating(menuList);

    return new GetMenuListCommand(nowOrders, restaurant, menuList);
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
