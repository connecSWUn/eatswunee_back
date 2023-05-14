package com.swulab.eatswunee.domain.restaurant.adapter.out.persistence;

import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.RestaurantJpaRepository;
import com.swulab.eatswunee.domain.restaurant.application.port.out.ExistRestaurantPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantPersistenceAdapter implements ExistRestaurantPort {

  private final RestaurantJpaRepository restaurantJpaRepository;


  @Override
  public boolean existRestaurant(String name) {
    return restaurantJpaRepository.existsByName(name);
  }
}
