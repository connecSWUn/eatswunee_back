package com.swulab.eatswunee.domain.restaurant.application.port.out;

import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import com.swulab.eatswunee.domain.restaurant.domain.model.RestaurantSpot;
import java.util.List;

public interface FindRestaurantPort {

  List<Restaurant> findRestaurant(RestaurantSpot restaurantSpot);

  Restaurant findRestaurant(Long restaurantId);

  Restaurant findRestaurantByMenuId(Long menuId);

}
