package com.swulab.eatswunee.domain.restaurant.adapter.out.persistence;

import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.RestaurantJpaRepository;
import com.swulab.eatswunee.domain.restaurant.application.port.out.ExistRestaurantPort;
import com.swulab.eatswunee.domain.restaurant.application.port.out.FindRestaurantPort;
import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import com.swulab.eatswunee.domain.restaurant.domain.model.RestaurantSpot;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantPersistenceAdapter implements ExistRestaurantPort, FindRestaurantPort {

  private final RestaurantJpaRepository restaurantJpaRepository;


  @Override
  public boolean existRestaurant(RestaurantSpot name) {
    return restaurantJpaRepository.existsByRestaurantSpot(name);
  }

  @Override
  public List<Restaurant> findRestaurant(RestaurantSpot restaurantSpot) {
    return restaurantJpaRepository.findAllByRestaurantSpot(restaurantSpot);
  }
}
