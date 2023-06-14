package com.swulab.eatswunee.domain.restaurant.adapter.in.web.controller;

import com.swulab.eatswunee.domain.restaurant.adapter.in.web.dto.response.RestaurantNameResponse;
import com.swulab.eatswunee.domain.restaurant.application.port.in.GetRestaurantNameUseCase;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetRestaurantNameController {

  private final GetRestaurantNameUseCase getRestaurantNameUseCase;

  @GetMapping("/restaurant/mypage/{restaurantId}")
  public ResponseEntity getRestaurantName(@PathVariable Long restaurantId) {

    String name = getRestaurantNameUseCase.getRestaurantName(restaurantId);
    RestaurantNameResponse response = new RestaurantNameResponse(name);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));

  }

}
