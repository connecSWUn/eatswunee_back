package com.swulab.eatswunee.domain.restaurant.adapter.out.persistence;

import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.model.RestaurantJpaEntity;
import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import com.swulab.eatswunee.domain.restaurant.domain.model.RestaurantSpot;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {

  public Restaurant mapToDomainEntity(RestaurantJpaEntity restaurantJpaEntity) {
    return Restaurant.builder()
        .restaurantId(restaurantJpaEntity.getRestaurantId())
        .name(restaurantJpaEntity.getName())
        .restaurantSpot(restaurantJpaEntity.getRestaurantSpot())
        .build();
  }

  public RestaurantJpaEntity mapToJpaEntity(Restaurant restaurant) {
    return RestaurantJpaEntity.builder()
        .restaurantId(restaurant.getRestaurantId())
        .name(restaurant.getName())
        .restaurantSpot(restaurant.getRestaurantSpot())
        .build();
  }
}
