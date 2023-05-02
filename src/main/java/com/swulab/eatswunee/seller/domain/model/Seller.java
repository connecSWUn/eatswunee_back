package com.swulab.eatswunee.seller.domain.model;

import com.swulab.eatswunee.restaurant.domain.model.Restaurant;
import lombok.Getter;

@Getter
public class Seller {

  private Long sellerId;
  private Restaurant restaurant;

}
