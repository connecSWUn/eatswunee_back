package com.swulab.eatswunee.domain.seller.domain.model;

import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Seller {

  private Long sellerId;
  private String sellerName;
  private String sellerProfileUrl;
  private String sellerFcmToken;
  private String LoginId;
  private String password;

  private Restaurant restaurant;

  @Builder
  public Seller(Long sellerId, String sellerName, String sellerProfileUrl,
      String sellerFcmToken, String loginId, String password,
      Restaurant restaurant) {
    this.sellerId = sellerId;
    this.sellerName = sellerName;
    this.sellerProfileUrl = sellerProfileUrl;
    this.sellerFcmToken = sellerFcmToken;
    LoginId = loginId;
    this.password = password;
    this.restaurant = restaurant;
  }
}

