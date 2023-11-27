package com.swulab.eatswunee.global.common.application.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.swulab.eatswunee.domain.restaurant.application.port.out.FindRestaurantPort;
import com.swulab.eatswunee.domain.restaurant.domain.model.Restaurant;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.domain.user.domain.model.User;
import com.swulab.eatswunee.global.common.application.port.in.FcmNotificationUseCase;
import java.util.LinkedHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FcmService implements FcmNotificationUseCase {

    private final FirebaseMessaging firebaseMessaging;
    private final FindUserPort findUserPort;
    private final FindRestaurantPort findRestaurantPort;

    @Override
    public void sendNotification(Notification notification, Long userId) {
        User user = findUserPort.findUser(userId);
        System.out.println(sendMessage(user, notification));
    }

    @Override
    public void sendNotificationRestaurant(Notification notification, Long restaurantId) {
        Restaurant restaurant = findRestaurantPort.findRestaurant(restaurantId);
        System.out.println(sendMessage(restaurant, notification));
    }

    private String sendMessage(User user, Notification notification) {

        if (user.getFcmToken() != null) {
            Message message = Message.builder()
                    .setToken(user.getFcmToken())
                    .setNotification(notification)
                    .putAllData(new LinkedHashMap<>())
                    .build();

            System.out.println(message);

            try {
                firebaseMessaging.send(message);
                return "알림을 성공적으로 전송했습니다. targetUserId=" + user.getUserId();
            } catch (FirebaseMessagingException e) {
                e.printStackTrace();
                return "알림 보내기를 실패하였습니다. targetUserId" + user.getUserId();
            }
        } else {
            return "서버에 저장된 해당 유저의 FirebaseToken이 존재하지 않습니다. targetUserId=" + user.getUserId();
        }
    }

    private String sendMessage(Restaurant restaurant, Notification notification) {

        if (restaurant.getDeviceToken() != null) {
            Message message = Message.builder()
                    .setToken(restaurant.getDeviceToken())
                    .setNotification(notification)
                    .putAllData(new LinkedHashMap<>())
                    .build();

            try {
                firebaseMessaging.send(message);
                return "알림을 성공적으로 전송했습니다. targetUserId=" + restaurant.getRestaurantId();
            } catch (FirebaseMessagingException e) {
                e.printStackTrace();
                return "알림 보내기를 실패하였습니다. targetUserId" + restaurant.getRestaurantId();
            }
        } else {
            return "서버에 저장된 해당 유저의 FirebaseToken이 존재하지 않습니다. targetUserId=" + restaurant.getRestaurantId();
        }
    }


}
