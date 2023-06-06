package com.swulab.eatswunee.domain.ordermenu.adpater.in.web.controller;

import com.swulab.eatswunee.domain.ordermenu.adpater.in.web.dto.response.GetOrderListResponse;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.GetCompletedOrderListUserCase;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.RestaurantNowOrderListCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetCompletedOrderListController {

  private final GetCompletedOrderListUserCase getCompletedOrderListUserCase;

  @GetMapping("/restaurant/order/complete/{restaurantId}")
  public ResponseEntity getCompletedOrderList(@PathVariable Long restaurantId) {

    List<RestaurantNowOrderListCommand> command = getCompletedOrderListUserCase.getCompletedOrderList(restaurantId);
    GetOrderListResponse response = new GetOrderListResponse(command);
    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));

  }

}
