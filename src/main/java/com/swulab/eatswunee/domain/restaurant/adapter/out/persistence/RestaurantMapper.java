package com.swulab.eatswunee.domain.restaurant.adapter.out.persistence;

import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.model.RestaurantJpaEntity;
import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;

public class RestaurantMapper {

  public Restaurant mapToDomainEntity(RestaurantJpaEntity restaurantJpaEntity) {
    return Restaurant.builder()
        .restaurantId(restaurantJpaEntity.getRestaurantId())
        .name(restaurantJpaEntity.getName())
        .build();
  }

  public RestaurantJpaEntity mapToJpaEntity(Restaurant restaurant) {
    return RestaurantJpaEntity.builder()
        .restaurantId(restaurant.getRestaurantId())
        .name(restaurant.getName())
        .build();
  }
}
