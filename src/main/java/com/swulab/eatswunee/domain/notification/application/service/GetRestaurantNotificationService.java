package com.swulab.eatswunee.domain.notification.application.service;

import com.swulab.eatswunee.domain.notification.application.port.in.GetRestaurantNotificationUseCase;
import com.swulab.eatswunee.domain.notification.application.port.out.FindOrderNotificationPort;
import com.swulab.eatswunee.domain.notification.application.port.out.FindRestaurantNotificationPort;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindIdAndIsReadCommand;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRestaurantNotificationCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GetRestaurantNotificationService implements GetRestaurantNotificationUseCase {

  private final FindRestaurantNotificationPort findRestaurantNotificationPort;
  private final FindOrderNotificationPort findOrderNotificationPort;
//  private final UpdateNotificationPort updateNotificationPort; todo 알림 읽음으로 변경

  @Override
  public List<FindRestaurantNotificationCommand> getRestaurantNotification(Long restaurantId) {

    List<FindRestaurantNotificationCommand> commands = findRestaurantNotificationPort
        .findRestaurantNotification(restaurantId);

    commands
        .stream()
        .forEach(
            command -> {
              FindIdAndIsReadCommand findIdAndIsReadCommand = findOrderNotificationPort.findOrderNotificationByOrderIdAndRestaurantId(command.getOrderId(), restaurantId);
              command.setRead(findIdAndIsReadCommand.getIsRead());
              command.setOrderNotificationId(findIdAndIsReadCommand.getNotificationId());
            }
        );

    return commands;
  }
}
