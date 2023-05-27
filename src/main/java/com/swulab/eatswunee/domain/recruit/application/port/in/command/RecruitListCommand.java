package com.swulab.eatswunee.domain.recruit.application.port.in.command;

import com.swulab.eatswunee.domain.restaurant.domain.model.RestaurantSpot;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RecruitListCommand {

  @NotNull
  @NotEmpty
  private RestaurantSpot restaurantCategory;

  public RecruitListCommand(RestaurantSpot category) {

    this.restaurantCategory = category;
  }

  public boolean isAll() {
    if (this.restaurantCategory.equals(RestaurantSpot.ALL)) return true;
    else return false;
  }
}
