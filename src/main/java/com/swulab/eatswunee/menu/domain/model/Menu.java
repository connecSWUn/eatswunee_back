package com.swulab.eatswunee.menu.domain.model;

import com.swulab.eatswunee.restaurant.domain.model.Restaurant;
import lombok.Getter;

@Getter
public class Menu {

  private Long menuId;
  private String name;
  private int price;
  private String imageUrl;
  private int avgScore;

  private Restaurant restaurant;
}
