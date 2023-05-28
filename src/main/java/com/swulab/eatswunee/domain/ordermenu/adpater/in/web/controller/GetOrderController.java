package com.swulab.eatswunee.domain.ordermenu.adpater.in.web.controller;


import com.swulab.eatswunee.domain.order.adapter.in.web.dto.response.GetOrderResponse;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.GetOrderMenuCommand;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.GetOrderUseCase;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetOrderController {

  private final GetOrderUseCase getOrderUseCase;

  @GetMapping("/order/{orderId}")
  public ResponseEntity getOrder(@PathVariable Long orderId) {

    GetOrderMenuCommand command =  getOrderUseCase.getOrder(orderId);
    GetOrderResponse response = new GetOrderResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));

  }

}
