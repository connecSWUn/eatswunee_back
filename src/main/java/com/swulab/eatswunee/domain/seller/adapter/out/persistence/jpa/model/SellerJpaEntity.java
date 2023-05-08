package com.swulab.eatswunee.domain.seller.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.model.RestaurantJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seller")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SellerJpaEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long sellerId;

  @ManyToOne
  @JoinColumn(name = "restaurant_id")
  private RestaurantJpaEntity restaurantJpaEntity;

  @Builder
  public SellerJpaEntity(Long sellerId,
      RestaurantJpaEntity restaurantJpaEntity) {
    this.sellerId = sellerId;
    this.restaurantJpaEntity = restaurantJpaEntity;
  }
}
