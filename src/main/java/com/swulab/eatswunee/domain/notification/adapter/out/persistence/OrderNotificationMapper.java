package com.swulab.eatswunee.domain.notification.adapter.out.persistence;

import com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model.OrderNotificationJpaEntity;
import com.swulab.eatswunee.domain.notification.domain.model.NotificationCategory;
import com.swulab.eatswunee.domain.notification.domain.model.OrderNotification;
import com.swulab.eatswunee.domain.order.adapter.out.persistence.OrderMapper;
import com.swulab.eatswunee.domain.restaurant.adapter.out.persistence.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderNotificationMapper {

    private final OrderMapper orderMapper;
    private final RestaurantMapper restaurantMapper;

    public OrderNotification mapToDomainEntity(OrderNotificationJpaEntity notificationJpaEntity) {
        return new OrderNotification(notificationJpaEntity.getId(),
                notificationJpaEntity.getNotificationContent(),
                notificationJpaEntity.getNotificationIsRead(),
                notificationJpaEntity.getCreatedAt(),
                "",
                orderMapper.mapToDomainEntity(notificationJpaEntity.getOrderJpaEntity()),
                restaurantMapper.mapToDomainEntity(notificationJpaEntity.getRestaurantJpaEntity()),
                NotificationCategory.REQUEST_ORDER);
    }

    public OrderNotificationJpaEntity mapToJpaEntity(OrderNotification notification) {
        return new OrderNotificationJpaEntity(notification.getNotificationId(),
                "주문", "", false, null,
                orderMapper.mapToJpaEntity(notification.getOrder()),
                restaurantMapper.mapToJpaEntity(notification.getRestaurant()));
    }
}
