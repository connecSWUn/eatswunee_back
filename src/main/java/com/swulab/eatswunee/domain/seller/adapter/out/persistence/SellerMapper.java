package com.swulab.eatswunee.domain.seller.adapter.out.persistence;

import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.RestaurantMapper;
import com.swulab.eatswunee.domain.seller.adapter.out.persistence.jpa.model.SellerJpaEntity;
import com.swulab.eatswunee.domain.seller.domain.model.Seller;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SellerMapper {

  private final RestaurantMapper restaurantMapper;



  public Seller mapToDomainEntity(SellerJpaEntity sellerJpaEntity) {
    return Seller.builder()
        .sellerId(sellerJpaEntity.getSellerId())
        .sellerName(sellerJpaEntity.getSellerName())
        .sellerProfileUrl(sellerJpaEntity.getSellerProfileUrl())
        .sellerFcmToken(sellerJpaEntity.getSellerFcmToken())
        .loginId(sellerJpaEntity.getLoginId())
        .password(sellerJpaEntity.getPassword())
        .restaurant(restaurantMapper.mapToDomainEntity(sellerJpaEntity.getRestaurantJpaEntity()))
        .build();
  }

  public SellerJpaEntity mapToJpaEntity(Seller seller) {
    return SellerJpaEntity.builder()
        .sellerId(seller.getSellerId())
        .sellerId(seller.getSellerId())
        .sellerName(seller.getSellerName())
        .sellerProfileUrl(seller.getSellerProfileUrl())
        .sellerFcmToken(seller.getSellerFcmToken())
        .loginId(seller.getLoginId())
        .password(seller.getPassword())
        .restaurantJpaEntity(restaurantMapper.mapToJpaEntity(seller.getRestaurant()))
        .build();
  }





}
