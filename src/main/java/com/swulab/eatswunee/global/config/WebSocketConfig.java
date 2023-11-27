package com.swulab.eatswunee.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@RequiredArgsConstructor
@Configuration
@EnableWebSocket // 웹 소켓 활성화
public class WebSocketConfig implements WebSocketConfigurer {

  private final WebSocketHandler webSocketHandler; // 정보를 처리할 handler

  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

    // handler 등록, 웹 소켓과 연결할 주소 설정
    registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
  }


}