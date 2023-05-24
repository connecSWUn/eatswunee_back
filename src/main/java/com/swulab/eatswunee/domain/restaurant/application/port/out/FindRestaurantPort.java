package com.swulab.eatswunee.domain.restaurant.application.port.out;

import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import com.swulab.eatswunee.domain.restaurant.domain.model.RestaurantSpot;
import java.util.List;

public interface FindRestaurantPort {

  List<Restaurant> findRestaurant(RestaurantSpot restaurantSpot);

}
