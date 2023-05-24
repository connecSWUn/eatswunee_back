package com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa;

import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.model.RestaurantJpaEntity;
import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import com.swulab.eatswunee.domain.restaurant.domain.model.RestaurantSpot;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantJpaRepository extends JpaRepository<RestaurantJpaEntity, Long> {

  boolean existsByRestaurantSpot(String spot);

  List<Restaurant> findAllByRestaurantSpot(RestaurantSpot spot);

}
