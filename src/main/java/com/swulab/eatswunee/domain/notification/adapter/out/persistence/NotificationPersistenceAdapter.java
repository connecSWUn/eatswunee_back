package com.swulab.eatswunee.domain.notification.adapter.out.persistence;

import com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.OrderNotificationJpaRepository;
import com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model.OrderNotificationJpaEntity;
import com.swulab.eatswunee.domain.notification.application.port.in.SaveOrderNotificationPort;
import com.swulab.eatswunee.domain.notification.application.port.out.ExistNotificationByOrderIdPort;
import com.swulab.eatswunee.domain.notification.application.port.out.FindOrderNotificationPort;
import com.swulab.eatswunee.domain.notification.application.port.out.FindRestaurantNotificationPort;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindIdAndIsReadCommand;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRestaurantNotificationCommand;
import com.swulab.eatswunee.domain.notification.application.port.out.FindRevenuePort;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRevenueCommand;
import com.swulab.eatswunee.domain.notification.domain.model.OrderNotification;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationPersistenceAdapter implements FindRestaurantNotificationPort,
    ExistNotificationByOrderIdPort, FindRevenuePort, FindOrderNotificationPort, SaveOrderNotificationPort {

  private final NotificationQueryRepository notificationQueryRepository;
  private final OrderNotificationJpaRepository notificationJpaRepository;

  private final OrderNotificationMapper orderNotificationMapper;

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
    notificationQueryRepository.findOrderNotificationByOrderIdAndRestaurantId(orderId, restaurantId).stream().forEach(
            entity -> System.out.println(entity.getNotificationId())
    );
    return notificationQueryRepository.findOrderNotificationByOrderIdAndRestaurantId(orderId, restaurantId).get(0);
  }

  @Override
  public void saveAll(List<OrderNotification> orderNotifications) {

    List<OrderNotificationJpaEntity> orderNotificationJpaEntities = orderNotifications.stream()
            .map(orderNotificationMapper::mapToJpaEntity)
            .toList();
    notificationJpaRepository.saveAll(orderNotificationJpaEntities);
  }
}
