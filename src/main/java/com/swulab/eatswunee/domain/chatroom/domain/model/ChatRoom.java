package com.swulab.eatswunee.domain.chatroom.domain.model;

import com.swulab.eatswunee.domain.chatmessage.application.port.in.SendMessageUseCase;
import com.swulab.eatswunee.domain.chatmessage.domain.model.ChatMessage;
import com.swulab.eatswunee.domain.chatmessage.domain.model.MessageType;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

@Getter
public class ChatRoom {

  private String chatRoomId;
  private LocalDateTime createdAt;
  private User guest; // 채팅방 입장한 사람
  private Recruit recruit;

  private Set<WebSocketSession> sessions = new HashSet<>();


  @Builder
  public ChatRoom(String chatRoomId, LocalDateTime createdAt,
      User guest, Recruit recruit) {
    this.chatRoomId = chatRoomId;
    this.createdAt = createdAt;
    this.guest = guest;
    this.recruit = recruit;
  }

  public void handlerActions(WebSocketSession session, ChatMessage chatMessage, SendMessageUseCase sendMessageUseCase) {
    try {

      if (chatMessage.getType().equals(MessageType.ENTER)) {
        // TODO: 게시글 올린 사람에게 알림 보내기
        sessions.add(session);
        chatMessage.setMessage(chatMessage.getUser().getName() + "님이 입장했습니다."); // 입장 메시지 설정
      }
      sendMessage(chatMessage, sendMessageUseCase); // 메시지 보냄

    } catch (Exception ex){
      ex.printStackTrace();
      synchronized( sessions ) {
        sessions.remove(session);
      }
      System.out.println("세션이 삭제되었습니다.");
    }


  }

  // 메시지 보냄
  private <T> void sendMessage(T message, SendMessageUseCase sendMessageUseCase) {
    this.sessions.forEach(webSocketSession -> System.out.println(webSocketSession.getId()));
    sessions.parallelStream()
        .forEach(session -> sendMessageUseCase.sendMessage(session, message));
  }

  public void removeSession(WebSocketSession webSocketSession) {
    sessions.remove(webSocketSession);
  }

}
