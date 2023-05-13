package com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantJpaRepository extends JpaRepository<RestaurantJpaRepository, Long> {

  boolean existsByName(String name);

}
