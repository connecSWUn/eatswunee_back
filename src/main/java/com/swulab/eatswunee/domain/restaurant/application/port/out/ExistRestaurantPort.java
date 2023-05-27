package com.swulab.eatswunee.domain.restaurant.application.port.out;

import com.swulab.eatswunee.domain.restaurant.domain.model.RestaurantSpot;

public interface ExistRestaurantPort {

  boolean existRestaurant(RestaurantSpot name);

}
