package com.swulab.eatswunee.domain.order.adapter.in.web.controller;

import com.swulab.eatswunee.domain.order.adapter.in.web.dto.request.AddOrderRequest;
import com.swulab.eatswunee.domain.order.adapter.in.web.dto.response.AddOrderResponse;
import com.swulab.eatswunee.domain.order.application.port.in.AddOrderUseCase;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddOrderController {

  private final AddOrderUseCase addOrderUseCase;

  @PostMapping("/gusia/order/save/{userId}")
  public ResponseEntity addOrderController(@PathVariable Long userId, @RequestBody AddOrderRequest request) {

    Long orderId = addOrderUseCase.addOrder(userId, request.toCommands());
    AddOrderResponse response = new AddOrderResponse(orderId);

    return ResponseEntity.ok(SuccessResponse.create201SuccessResponse(response));
  }

}
