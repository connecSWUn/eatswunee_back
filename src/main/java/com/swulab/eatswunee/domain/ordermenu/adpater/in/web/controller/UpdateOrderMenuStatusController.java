package com.swulab.eatswunee.domain.ordermenu.adpater.in.web.controller;

import com.google.firebase.messaging.Notification;
import com.swulab.eatswunee.domain.ordermenu.adpater.in.web.dto.request.UpdateOrderMenuStatusRequest;
import com.swulab.eatswunee.domain.ordermenu.adpater.in.web.dto.response.UpdateOrderMenuStatusResponse;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.GetOrderUseCase;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.UpdateOrderMenuStatusUseCase;
import com.swulab.eatswunee.domain.ordermenu.application.port.in.command.UpdateOrderMenuStatusCommand;
import com.swulab.eatswunee.domain.restaurant.application.port.in.GetRestaurantNameUseCase;
import com.swulab.eatswunee.global.common.adapter.web.in.dto.SuccessResponse;
import com.swulab.eatswunee.global.common.application.port.in.FcmNotificationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateOrderMenuStatusController {

  public final UpdateOrderMenuStatusUseCase updateOrderMenuStatusUseCase;
  private final FcmNotificationUseCase fcmNotificationUseCase;
  private final GetRestaurantNameUseCase getRestaurantNameUseCase;
  private final GetOrderUseCase getOrderUseCase;

  @PatchMapping("/order/orderMenuStatus")
  public ResponseEntity updateOrderMenuStatus(@RequestBody UpdateOrderMenuStatusRequest request) {

    UpdateOrderMenuStatusCommand command = updateOrderMenuStatusUseCase.updateOrderMenuStatus(request.getRestaurantId(), request.getOrderId(), request.getOrderMenuStatus());
    UpdateOrderMenuStatusResponse response = new UpdateOrderMenuStatusResponse(command);

    String restaurantName = getRestaurantNameUseCase.getRestaurantName(request.getRestaurantId());
    Long userIdOfOrder = getOrderUseCase.getUserIdOfOrder(request.getOrderId());
    fcmNotificationUseCase.sendNotification(createNotification(restaurantName), userIdOfOrder);

    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));
  }

  private Notification createNotification(String restaurantName) {
    return Notification.builder()
            .setBody("음식 준비가 완료되었습니다.")
            .setTitle(restaurantName)
            .setImage("")
            .build();
  }

}
