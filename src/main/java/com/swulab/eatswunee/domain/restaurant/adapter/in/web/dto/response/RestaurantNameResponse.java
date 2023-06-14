package com.swulab.eatswunee.domain.restaurant.adapter.in.web.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantNameResponse {

  private String restaurant_name;

  public RestaurantNameResponse(String restaurant_name) {
    this.restaurant_name = restaurant_name;
  }
}
