package com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.restaurant.domain.model.RestaurantSpot;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RestaurantJpaEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long restaurantId;

  private String name;

  private RestaurantSpot restaurantSpot;

  @Builder
  public RestaurantJpaEntity(Long restaurantId, String name,
      RestaurantSpot restaurantSpot) {
    this.restaurantId = restaurantId;
    this.name = name;
    this.restaurantSpot = restaurantSpot;
  }
}
