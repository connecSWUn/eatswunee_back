package com.swulab.eatswunee.domain.ordermenu.adpater.in.web.controller;

import com.swulab.eatswunee.domain.ordermenu.adpater.in.web.dto.request.UpdateOrderMenuStatusRequest;
import com.swulab.eatswunee.domain.ordermenu.adpater.in.web.dto.response.UpdateOrderMenuStatusResponse;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.UpdateOrderMenuStatusUseCase;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.UpdateOrderMenuStatusCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateOrderMenuStatusController {

  public final UpdateOrderMenuStatusUseCase updateOrderMenuStatusUseCase;

  @PatchMapping("/order/orderMenuStatus")
  public ResponseEntity updateOrderMenuStatus(@RequestBody UpdateOrderMenuStatusRequest request) {

    UpdateOrderMenuStatusCommand command = updateOrderMenuStatusUseCase.updateOrderMenuStatus(request.getRestaurantId(), request.getOrderId(), request.getOrderMenuStatus());
    UpdateOrderMenuStatusResponse response = new UpdateOrderMenuStatusResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));



  }

}
