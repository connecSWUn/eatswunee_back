package com.swulab.eatswunee.domain.seller.domain.model;

import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Seller {

  private Long sellerId;
  private Restaurant restaurant;

  @Builder
  public Seller(Long sellerId, Restaurant restaurant) {
    this.sellerId = sellerId;
    this.restaurant = restaurant;
  }
}