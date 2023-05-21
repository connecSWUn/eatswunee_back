package com.swulab.eatswunee.domain.menu.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.jpa.model.RestaurantJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "menu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MenuJpaEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long menuId;

  private String name;

  private int price;

  private String imageUrl;

//  private int avgScore;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "restaurant_id")
  private RestaurantJpaEntity restaurantJpaEntity;

  @Builder
  public MenuJpaEntity(Long menuId, String name, int price, String imageUrl,
      RestaurantJpaEntity restaurantJpaEntity) {
    this.menuId = menuId;
    this.name = name;
    this.price = price;
    this.imageUrl = imageUrl;
//    this.avgScore = avgScore;
    this.restaurantJpaEntity = restaurantJpaEntity;
  }
}
