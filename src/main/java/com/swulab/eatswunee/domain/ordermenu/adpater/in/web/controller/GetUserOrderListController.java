package com.swulab.eatswunee.domain.ordermenu.adpater.in.web.controller;

import com.swulab.eatswunee.domain.order.adapter.in.web.controller.coammnd.UserOrderCommand;
import com.swulab.eatswunee.domain.order.adapter.in.web.dto.response.GetUserOrderResponse;
import com.swulab.eatswunee.domain.order.application.port.in.GetOrderMenuUseCase;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetUserOrderListController {

  public final GetOrderMenuUseCase getOrderMenuUseCase;

  @GetMapping("/mypage/orders/{userId}")
  public ResponseEntity getOrderMenuResponse(@AuthenticationPrincipal UserDetails userDetails) {

    List<UserOrderCommand> orderMenuList = getOrderMenuUseCase.getOrderMenuList(Long.parseLong(userDetails.getUsername()));
    GetUserOrderResponse response = new GetUserOrderResponse(orderMenuList);
    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }



}
