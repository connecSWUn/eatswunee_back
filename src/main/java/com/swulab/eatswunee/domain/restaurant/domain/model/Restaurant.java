package com.swulab.eatswunee.domain.restaurant.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Restaurant {

  private Long restaurantId;
  private String name;

  @Builder
  public Restaurant(Long restaurantId, String name) {
    this.restaurantId = restaurantId;
    this.name = name;
  }
}
