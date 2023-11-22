package com.swulab.eatswunee.domain.restaurant.adapter.out.persistence;

import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.RestaurantJpaRepository;
import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.model.RestaurantJpaEntity;
import com.swulab.eatswunee.domain.restaurant.application.port.out.ExistRestaurantPort;
import com.swulab.eatswunee.domain.restaurant.application.port.out.FindRestaurantPort;
import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import com.swulab.eatswunee.domain.restaurant.domain.model.RestaurantSpot;
import com.swulab.eatswunee.domain.restaurant.exception.RestaurantNotFoundException;
import com.swulab.eatswunee.global.error.ErrorCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantPersistenceAdapter implements ExistRestaurantPort, FindRestaurantPort {

  private final RestaurantJpaRepository restaurantJpaRepository;
  private final RestaurantMapper restaurantMapper;
  private final RestaurantQueryRepository restaurantQueryRepository;


  @Override
  public boolean existRestaurant(RestaurantSpot name) {
    return restaurantJpaRepository.existsByRestaurantSpot(name);
  }

  @Override
  public List<Restaurant> findRestaurant(RestaurantSpot restaurantSpot) {
    return restaurantJpaRepository.findAllByRestaurantSpot(restaurantSpot);
  }

  @Override
  public Restaurant findRestaurant(Long restaurantId) {
    RestaurantJpaEntity restaurantJpaEntity = restaurantJpaRepository.findById(restaurantId)
        .orElseThrow(() -> new RestaurantNotFoundException(
            ErrorCode.RESTAURANT_NOT_FOUND.getDetail() + restaurantId));
    return restaurantMapper.mapToDomainEntity(restaurantJpaEntity);
  }

  @Override
  public Restaurant findRestaurantByMenuId(Long menuId) {
    RestaurantJpaEntity restaurantJpaEntity = restaurantQueryRepository.findRestaurantByMenuId(menuId);
    return restaurantMapper.mapToDomainEntity(restaurantJpaEntity);
  }
}
