package com.swulab.eatswunee.restaurant.adapter.out.persistence.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantJpaEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long restaurantId;

  private String name;

  @Builder
  public RestaurantJpaEntity(Long restaurantId, String name) {
    this.restaurantId = restaurantId;
    this.name = name;
  }
}
