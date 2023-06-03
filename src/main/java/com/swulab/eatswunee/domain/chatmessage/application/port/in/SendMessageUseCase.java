package com.swulab.eatswunee.domain.chatmessage.application.port.in;

import org.springframework.web.socket.WebSocketSession;

public interface SendMessageUseCase {

  <T> void sendMessage(WebSocketSession session, T message);

}
