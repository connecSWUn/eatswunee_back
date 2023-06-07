package com.swulab.eatswunee.domain.notification.adapter.out.persistence;

import com.swulab.eatswunee.domain.notification.application.port.out.ExistNotificationByOrderIdPort;
import com.swulab.eatswunee.domain.notification.application.port.out.FindRestaurantNotificationPort;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRestaurantNotificationCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationPersistenceAdapter implements FindRestaurantNotificationPort,
    ExistNotificationByOrderIdPort {

  private final NotificationQueryRepository notificationQueryRepository;

  @Override
  public List<FindRestaurantNotificationCommand> findRestaurantNotification(Long restaurantId) {

    return notificationQueryRepository.findRestaurantNotification(restaurantId);
  }

//  @Override
//  public Boolean existNotificationByOrderId(Long orderId) {
//
//    return notificationQueryRepository.existNotificationByOrderId(orderId);
//  }
}
