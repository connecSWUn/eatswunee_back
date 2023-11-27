package com.swulab.eatswunee.global.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.Notification;
import com.swulab.eatswunee.domain.chatmessage.application.port.out.SaveChatMessagePort;
import com.swulab.eatswunee.domain.chatmessage.application.service.SendMessageService;
import com.swulab.eatswunee.domain.chatmessage.domain.model.ChatMessage;
import com.swulab.eatswunee.domain.chatroom.application.port.in.FindChatRoomUseCase;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitPort;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.domain.user.domain.model.User;
import com.swulab.eatswunee.global.common.application.port.in.FcmNotificationUseCase;
import com.swulab.eatswunee.global.common.application.service.FirebaseCloudMessageService;
import com.swulab.eatswunee.global.common.domain.ChatMessageBasic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketHandler extends TextWebSocketHandler { // TextWebSocketHandler 상속받아 핸들러 구현

  private final ObjectMapper objectMapper;
  private final SendMessageService sendMessageService;
  private final FindChatRoomUseCase findChatRoomUseCase;
  private final FindChatRoomPort findChatRoomPort;
  private final FindUserPort findUserPort;
  private final SaveChatMessagePort saveChatMessagePort;
  private final FindRecruitPort findRecruitPort;



  private final FirebaseCloudMessageService firebaseCloudMessageService;
  private final FcmNotificationUseCase fcmNotificationUseCase;

  public ChatRoom chatRoom;

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    // json 형식으로 요청을 보내면, 핸들러에서 objectMapper가 ChatMessage.class deserialize
    String payload = message.getPayload();
    log.info("{}", payload);

    ChatMessageBasic chatMessageBasic = objectMapper.readValue(payload, ChatMessageBasic.class);

    ChatMessage chatMessage = createChatMessage(chatMessageBasic);


    saveChatMessagePort.saveChatMessage(chatMessage);

    // 요청에 들어있는 roomId를 사용해서, 해당 채팅방을 찾아  handlerAction() 이라는 메서드를 실행
    chatRoom = findChatRoomUseCase.findRoomById(chatMessage.getChatRoom().getChatRoomId());


    chatRoom.handlerActions(session, chatMessage, sendMessageService);

    ChatRoom findChatRoom = findChatRoomPort.findChatRoomById(chatMessage.getChatRoom().getChatRoomId());
    Recruit recruit = findRecruitPort.findRecruit(findChatRoom.getRecruit().getRecruitId());

    Long userId = recruit.getUser().getUserId();
    User user = findUserPort.findUser(userId);

    firebaseCloudMessageService.sendMessageTo(user.getFcmToken(), chatMessage.getUser().getName(), chatMessage.getMessage());
    fcmNotificationUseCase.sendNotification(createChatNotification(user, chatMessage), userId);

  }

  private ChatMessage createChatMessage(ChatMessageBasic chatMessageBasic) {
    ChatMessage chatMessage = ChatMessage.builder()
        .message(chatMessageBasic.getMessage())
        .isRead(false)
        .type(chatMessageBasic.getMessageType())
        .user(findUserPort.findUser(chatMessageBasic.getSenderId()))
        .chatRoom(findChatRoomPort.findChatRoomById(chatMessageBasic.getChatRoomId()))
        .build();
    return chatMessage;
  }

  private Notification createChatNotification(User user, ChatMessage chatMessage) {
    return Notification.builder()
            .setTitle(user.getName())
            .setBody(chatMessage.getMessage())
            .setImage("").build();
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    chatRoom.removeSession(session);
    System.out.println(" close session = " + session);
    super.afterConnectionClosed(session, status);
  }

//  private Long getRecruitIdFromChatRoomId(String chatRoomId) {
//    String[] split = chatRoomId.toString().split("0");
//    return chatRoomId;
//  }

  /*
  handlerAction() :
  메서드는 이 참여자가 현재 이미 채팅방에 접속된 상태인지,
  아니면 이미 채팅에 참여해있는 상태인지를 판별하여,
  만약 채팅방에 처음 참여하는거라면 session을 연결해줌과 동시에 메시지를 보낼것이고 아니라면 메시지를 해당 채팅방으로 보내게 될 것이다.
   */


}
