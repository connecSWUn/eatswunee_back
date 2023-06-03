package com.swulab.eatswunee.domain.chatmessage.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swulab.eatswunee.domain.chatmessage.application.port.in.SendMessageUseCase;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendMessageService implements SendMessageUseCase {

  private final ObjectMapper objectMapper;


  @Override
  public <T> void sendMessage(WebSocketSession session, T message) {
    try{
      session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
  }

}
