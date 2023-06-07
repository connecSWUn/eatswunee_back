package com.swulab.eatswunee.domain.notification.application.service;

import com.swulab.eatswunee.domain.notification.application.port.in.GetRestaurantNotificationUseCase;
import com.swulab.eatswunee.domain.notification.application.port.out.ExistNotificationByOrderIdPort;
import com.swulab.eatswunee.domain.notification.application.port.out.FindRestaurantNotificationPort;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRestaurantNotificationCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GetRestaurantNotificationService implements GetRestaurantNotificationUseCase {

  private final FindRestaurantNotificationPort findRestaurantNotificationPort;
  private final ExistNotificationByOrderIdPort existNotificationByOrderIdPort;

  @Override
  public List<FindRestaurantNotificationCommand> getRestaurantNotification(Long restaurantId) {

    List<FindRestaurantNotificationCommand> commands = findRestaurantNotificationPort
        .findRestaurantNotification(restaurantId)
        .stream()
        .filter(command -> existNotificationByOrderIdPort.existNotificationByOrderId(command.getOrderId())).toList();

    return commands;
  }
}
