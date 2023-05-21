package com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa;

import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.model.RestaurantJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantJpaRepository extends JpaRepository<RestaurantJpaEntity, Long> {

  boolean existsByRestaurantSpot(String spot);

}
