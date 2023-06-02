package com.swulab.eatswunee.global.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swulab.eatswunee.domain.chatmessage.application.port.out.SaveChatMessagePort;
import com.swulab.eatswunee.domain.chatmessage.domain.model.ChatMessage;
import com.swulab.eatswunee.domain.chatroom.application.port.in.FindChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.application.service.ChatService;
import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.global.common.domain.ChatMessageBasic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketHandler extends TextWebSocketHandler { // TextWebSocketHandler 상속받아 핸들러 구현

  private final ObjectMapper objectMapper;
  private final ChatService chatService;
  private final FindChatRoomPort findChatRoomPort;
  private final FindUserPort findUserPort;
  private final SaveChatMessagePort saveChatMessagePort;


  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    // json 형식으로 요청을 보내면, 핸들러에서 objectMapper가 ChatMessage.class deserialize
    String payload = message.getPayload();
    log.info("{}", payload);

    ChatMessageBasic chatMessageBasic = objectMapper.readValue(payload, ChatMessageBasic.class);


    ChatMessage chatMessage = ChatMessage.builder()
        .message(chatMessageBasic.getMessage())
        .isRead(false)
        .type(chatMessageBasic.getMessageType())
        .user(findUserPort.findUser(chatMessageBasic.getSenderId()))
        .chatRoom(findChatRoomPort.findChatRoomById(chatMessageBasic.getChatRoomId()))
        .build();

    saveChatMessagePort.saveChatMessage(chatMessage);

    // 요청에 들어있는 roomId를 사용해서, 해당 채팅방을 찾아  handlerAction() 이라는 메서드를 실행
    ChatRoom chatRoom = chatService.findRoomById(chatMessage.getChatRoom().getChatRoomId());


    chatRoom.handlerActions(session, chatMessage, chatService);
  }
  /*
  handlerAction() :
  메서드는 이 참여자가 현재 이미 채팅방에 접속된 상태인지,
  아니면 이미 채팅에 참여해있는 상태인지를 판별하여,
  만약 채팅방에 처음 참여하는거라면 session을 연결해줌과 동시에 메시지를 보낼것이고 아니라면 메시지를 해당 채팅방으로 보내게 될 것이다.
   */
}
