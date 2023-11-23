package com.swulab.eatswunee.domain.notification.application.port.out;

import com.swulab.eatswunee.domain.notification.application.port.out.command.FindIdAndIsReadCommand;

public interface FindOrderNotificationPort {

  FindIdAndIsReadCommand findOrderNotificationByOrderIdAndRestaurantId(Long orderId, Long restaurantId);

}
