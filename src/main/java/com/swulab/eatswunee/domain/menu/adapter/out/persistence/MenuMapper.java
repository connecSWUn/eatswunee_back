package com.swulab.eatswunee.domain.menu.adapter.out.persistence;

import com.swulab.eatswunee.domain.menu.adapter.out.persistence.jpa.model.MenuJpaEntity;
import com.swulab.eatswunee.domain.menu.domain.model.Menu;
import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.RestaurantMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MenuMapper {

  private final RestaurantMapper restaurantMapper;

  public Menu mapToDomainEntity(MenuJpaEntity menuJpaEntity) {
    return Menu.builder()
        .menuId(menuJpaEntity.getMenuId())
        .name(menuJpaEntity.getName())
        .price(menuJpaEntity.getPrice())
        .imageUrl(menuJpaEntity.getImageUrl())
        .avgScore(menuJpaEntity.getAvgScore())
        .restaurant(restaurantMapper.mapToDomainEntity(menuJpaEntity.getRestaurantJpaEntity()))
        .build();
  }

  public MenuJpaEntity mapToJpaEntity(Menu menu) {
    return MenuJpaEntity.builder()
        .menuId(menu.getMenuId())
        .name(menu.getName())
        .price(menu.getPrice())
        .imageUrl(menu.getImageUrl())
        .avgScore(menu.getAvgScore())
        .restaurantJpaEntity(restaurantMapper.mapToJpaEntity(menu.getRestaurant()))
        .build();
  }



}
