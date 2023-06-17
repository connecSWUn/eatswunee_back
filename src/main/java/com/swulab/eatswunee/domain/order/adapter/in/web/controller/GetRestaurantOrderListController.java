package com.swulab.eatswunee.domain.order.adapter.in.web.controller;

import com.swulab.eatswunee.domain.order.adapter.in.web.dto.response.GetRestaurantOrderListResponse;
import com.swulab.eatswunee.domain.order.application.port.in.GetRestaurantOrderListUseCase;
import com.swulab.eatswunee.domain.order.application.port.out.command.FindRestaurantOrderListCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class GetRestaurantOrderListController {

  private final GetRestaurantOrderListUseCase getRestaurantOrderListUseCase;

  @GetMapping("/restaurant/order/{orderId}")
  public ResponseEntity getRestaurantOrderList(@PathVariable Long orderId) {

    FindRestaurantOrderListCommand command = getRestaurantOrderListUseCase.getRestaurantOrderList(orderId);
    GetRestaurantOrderListResponse response = new GetRestaurantOrderListResponse(command);

return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }


}
