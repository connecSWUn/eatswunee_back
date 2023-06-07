package com.swulab.eatswunee.domain.notification.adapter.in.web.controller;

import com.swulab.eatswunee.domain.notification.adapter.in.web.dto.response.GetRestaurantNotificationResponse;
import com.swulab.eatswunee.domain.notification.application.port.in.GetRestaurantNotificationUseCase;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRestaurantNotificationCommand;
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
public class GetRestaurantNotificationController {

  private final GetRestaurantNotificationUseCase getRestaurantNotificationUseCase;

  @GetMapping("/restaurant/notification/{restaurantId}")
  public ResponseEntity getRestaurantNotification(@PathVariable Long restaurantId) {

    List<FindRestaurantNotificationCommand> command = getRestaurantNotificationUseCase.getRestaurantNotification(restaurantId);

    GetRestaurantNotificationResponse response = new GetRestaurantNotificationResponse(command);
    return ResponseEntity.ok(SuccessResponse.create200SuccessResponse(response));

  }

}
