package com.swulab.eatswunee.domain.ordermenu.adpater.in.web.controller;

import com.swulab.eatswunee.domain.ordermenu.adpater.in.web.dto.response.GetNowOrderListResponse;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.GetNowOrderListUseCase;
import com.swulab.eatswunee.domain.ordermenu.application.port.out.command.RestaurantNowOrderListCommand;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class GetNowOrderListController {

  private final GetNowOrderListUseCase getNowOrderListUseCase;

  @GetMapping("/restaurant/orders/{restaurantId}")
  public ResponseEntity getNowOrderList(@PathVariable Long restaurantId) {

    List<RestaurantNowOrderListCommand> nowOrderList = getNowOrderListUseCase.getNowOrderList(restaurantId);
    GetNowOrderListResponse response = new GetNowOrderListResponse(nowOrderList);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }


}
