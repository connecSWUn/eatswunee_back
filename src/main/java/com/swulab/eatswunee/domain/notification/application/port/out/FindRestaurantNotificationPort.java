package com.swulab.eatswunee.domain.notification.application.port.out;

import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRestaurantNotificationCommand;
import java.util.List;

public interface FindRestaurantNotificationPort {

  List<FindRestaurantNotificationCommand> findRestaurantNotification(Long restaurantId);

}
