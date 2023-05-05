package com.swulab.eatswunee.menu.domain.model;

import com.swulab.eatswunee.restaurant.domain.model.Restaurant;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Menu {

  private Long menuId;
  private String name;
  private int price;
  private String imageUrl;
  private int avgScore;

  private Restaurant restaurant;

  @Builder
  public Menu(Long menuId, String name, int price, String imageUrl, int avgScore,
      Restaurant restaurant) {
    this.menuId = menuId;
    this.name = name;
    this.price = price;
    this.imageUrl = imageUrl;
    this.avgScore = avgScore;
    this.restaurant = restaurant;
  }
}
