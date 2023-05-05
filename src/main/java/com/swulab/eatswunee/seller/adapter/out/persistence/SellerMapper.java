package com.swulab.eatswunee.seller.adapter.out.persistence;

import com.swulab.eatswunee.restaurant.adapter.out.persistence.RestaurantMapper;
import com.swulab.eatswunee.seller.adapter.out.persistence.jpa.model.SellerJpaEntity;
import com.swulab.eatswunee.seller.domain.model.Seller;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SellerMapper {

  private final RestaurantMapper restaurantMapper;

  public Seller mapToDomainEntity(SellerJpaEntity sellerJpaEntity) {
    return Seller.builder()
        .sellerId(sellerJpaEntity.getSellerId())
        .restaurant(restaurantMapper.mapToDomainEntity(sellerJpaEntity.getRestaurantJpaEntity()))
        .build();
  }

  public SellerJpaEntity mapToJpaEntity(Seller seller) {
    return SellerJpaEntity.builder()
        .sellerId(seller.getSellerId())
        .restaurantJpaEntity(restaurantMapper.mapToJpaEntity(seller.getRestaurant()))
        .build();
  }





}
