package com.swulab.eatswunee.domain.notification.adapter.out.persistence;

import com.swulab.eatswunee.domain.notification.application.port.out.ExistNotificationByOrderIdPort;
import com.swulab.eatswunee.domain.notification.application.port.out.FindOrderNotificationPort;
import com.swulab.eatswunee.domain.notification.application.port.out.FindRestaurantNotificationPort;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindIdAndIsReadCommand;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRestaurantNotificationCommand;
import com.swulab.eatswunee.domain.notification.application.port.out.FindRevenuePort;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRevenueCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationPersistenceAdapter implements FindRestaurantNotificationPort,
    ExistNotificationByOrderIdPort, FindRevenuePort, FindOrderNotificationPort {

  private final NotificationQueryRepository notificationQueryRepository;

  @Override
  public List<FindRestaurantNotificationCommand> findRestaurantNotification(Long restaurantId) {

    return notificationQueryRepository.findRestaurantNotification(restaurantId);
  }

  @Override
  public Boolean existNotificationByOrderId(Long orderId) {

    return notificationQueryRepository.existNotificationByOrderId(orderId);
  }

  @Override
  public List<FindRevenueCommand> findRevenue(Long restaurantId) {
    return notificationQueryRepository.findRevenue(restaurantId);
  }

  @Override
  public FindIdAndIsReadCommand findOrderNotificationByOrderIdAndRestaurantId(Long orderId,
      Long restaurantId) {

    return notificationQueryRepository.findOrderNotificationByOrderIdAndRestaurantId(orderId, restaurantId);
  }
}
