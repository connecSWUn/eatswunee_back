package com.swulab.eatswunee.domain.notification.application.port.in;

import com.swulab.eatswunee.domain.notification.application.port.in.command.GetRestaurantNotificationCommand;
import com.swulab.eatswunee.domain.notification.application.port.out.command.FindRestaurantNotificationCommand;
import java.util.List;

public interface GetRestaurantNotificationUseCase {

  List<FindRestaurantNotificationCommand> getRestaurantNotification(Long restaurantId);

}
