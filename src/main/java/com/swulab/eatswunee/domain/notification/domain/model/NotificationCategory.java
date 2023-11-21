package com.swulab.eatswunee.domain.notification.domain.model;

import lombok.Getter;

@Getter
public enum NotificationCategory {

    REQUEST_ORDER("주문번호 %d"),
    ORDER_ARRIVED("음식 준비가 완료되었습니다."),
    PLACING_ORDER("주문번호 %d"),
    CHAT_ARRIVE("%s님이 메시지를 보냈습니다.");

    private String message;

    NotificationCategory(String message) {
        this.message = message;
    }
}
