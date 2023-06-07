package com.swulab.eatswunee.domain.notification.adapter.in.web.controller;

import com.swulab.eatswunee.domain.notification.adapter.in.web.dto.response.GetRevenueResponse;
import com.swulab.eatswunee.domain.notification.application.port.in.GetRevenueUseCase;
import com.swulab.eatswunee.domain.notification.application.port.in.command.GetRevenueCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetRevenueController {

  private final GetRevenueUseCase getRevenueUseCase;

  @GetMapping("/restaurant/revenue/{restaurantId}")
  public ResponseEntity GetRevenue(@PathVariable Long restaurantId) {

    GetRevenueCommand command = getRevenueUseCase.getRevenue(restaurantId);
    GetRevenueResponse response = new GetRevenueResponse(command);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }
}
