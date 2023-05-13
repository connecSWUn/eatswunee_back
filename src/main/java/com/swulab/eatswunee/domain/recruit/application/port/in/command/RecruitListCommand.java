package com.swulab.eatswunee.domain.recruit.application.port.in.command;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RecruitListCommand {

  @NotNull
  @NotEmpty
  private String restaurantCategory;

  public RecruitListCommand(String category) {

    this.restaurantCategory = category;
  }

  public boolean isAll() {
    if (this.restaurantCategory.equals("ALL")) return true;
    else return false;
  }
}
