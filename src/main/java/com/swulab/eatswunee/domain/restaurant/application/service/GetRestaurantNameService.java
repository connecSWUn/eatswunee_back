package com.swulab.eatswunee.domain.restaurant.application.service;

import com.swulab.eatswunee.domain.restaurant.application.port.in.GetRestaurantNameUseCase;
import com.swulab.eatswunee.domain.restaurant.application.port.out.FindRestaurantPort;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class GetRestaurantNameService implements GetRestaurantNameUseCase {

  private final FindRestaurantPort findRestaurantPort;


  @Override
  public String getRestaurantName(Long restaurantId) {

    return findRestaurantPort.findRestaurant(restaurantId).getName();
  }
}
