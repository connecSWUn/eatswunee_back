package com.swulab.eatswunee.domain.chatroom.domain.model;

import com.swulab.eatswunee.domain.chatmessage.domain.model.ChatMessage;
import com.swulab.eatswunee.domain.chatmessage.domain.model.MessageType;
import com.swulab.eatswunee.domain.chatroom.application.service.ChatService;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

@Getter
public class ChatRoom {

  private Long chatRoomId;
  private LocalDateTime createdAt;
  private User user;
  private Recruit recruit;

  // 0 : 모집글 쓴 사람, 1 채팅 방에 들어온 사람
//  private WebSocketSession[] sessions = new WebSocketSession[2];
  private List<WebSocketSession> sessions = new ArrayList<>();
//  private Set<WebSocketSession> sessions = new HashSet<>(); // 세션(WebSocketSession)을 관리할 집함

  @Builder
  public ChatRoom(Long chatRoomId, LocalDateTime createdAt, User user, Recruit recruit) {
    this.chatRoomId = chatRoomId;
    this.createdAt = createdAt;
    this.user = user;
    this.recruit = recruit;
  }

  // 해당 채팅방으로 보내진 메시지를 받아서 처리
  public void handlerActions(WebSocketSession session, ChatMessage chatMessage, ChatService chatService) {
    if (chatMessage.getType().equals(MessageType.ENTER)) { // 메시지의 값이 ENTER, TALK 인지 확인
      // ENTER 라면
      // TODO: 게시글 올린 사람에게 알림 보내기
//      sessions[1]=session; // session 을 연결
      sessions.add(session);

      chatMessage.setMessage(chatMessage.getUser().getName() + "님이 입장했습니다."); // 입장 메시지 설정
    }
    sendMessage(chatMessage, chatService); // 메시지 보냄

  }

  // 메시지 보냄
  private <T> void sendMessage(T message, ChatService chatService) {
//    chatService.sendMessage(sessions[0], message);
//    chatService.sendMessage(sessions[1], message);
    // 세션 집합에 있는 모든 세션들에게 메시지를 보냄
    sessions.parallelStream()
        .forEach(session -> chatService.sendMessage(session, message));
  }

}
