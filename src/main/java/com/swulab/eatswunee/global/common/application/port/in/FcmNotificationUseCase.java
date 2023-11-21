package com.swulab.eatswunee.global.common.application.port.in;

import com.google.firebase.messaging.Notification;

public interface FcmNotificationUseCase {

    void sendNotification(Notification notification, Long userId);

}
