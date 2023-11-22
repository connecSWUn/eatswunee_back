package com.swulab.eatswunee.domain.notification.application.port.in;

import com.swulab.eatswunee.domain.notification.domain.model.OrderNotification;
import java.util.List;

public interface SaveOrderNotificationPort {

    void saveAll(List<OrderNotification> orderNotifications);
}
