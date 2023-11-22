package com.swulab.eatswunee.domain.restaurant.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Restaurant {

  private Long restaurantId;
  private String name;
  private RestaurantSpot restaurantSpot;

  private String deviceToken;

  @Builder
  public Restaurant(Long restaurantId, String name,
      RestaurantSpot restaurantSpot, String deviceToken) {
    this.restaurantId = restaurantId;
    this.name = name;
    this.restaurantSpot = restaurantSpot;
    this.deviceToken = deviceToken;
  }
}
