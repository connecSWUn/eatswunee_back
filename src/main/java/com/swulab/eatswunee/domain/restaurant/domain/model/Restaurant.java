package com.swulab.eatswunee.domain.restaurant.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Restaurant {

  private Long restaurantId;
  private String name;
  private RestaurantSpot restaurantSpot;

  @Builder
  public Restaurant(Long restaurantId, String name,
      RestaurantSpot restaurantSpot) {
    this.restaurantId = restaurantId;
    this.name = name;
    this.restaurantSpot = restaurantSpot;
  }
}
