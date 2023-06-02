package com.swulab.eatswunee.domain.chatroom.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swulab.eatswunee.domain.chatroom.application.port.in.FindChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.application.port.in.SaveChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitPort;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {
  private final ObjectMapper objectMapper;
//  private Map<Long, ChatRoom> chatRooms; // chatId를 key로 갖고 ChatRoom을 value로 갖는 Map
  private final FindRecruitPort findRecruitPort;
  private final FindChatRoomPort findChatRoomPort;
  private final SaveChatRoomPort saveChatRoomPort;
  private final FindUserPort findUserPort;


  public List<ChatRoom> findAllRoom() {
    List<ChatRoom> allChatRooms = findChatRoomPort.findAllChatRooms();
    return allChatRooms;
  }

  public ChatRoom findRoomById(Long roomId) {
    ChatRoom findChatRoom = findChatRoomPort.findChatRoomById(roomId);
    return findChatRoom;
  }

  // OK
  public ChatRoom createRoom(Long userId, Long recruitId) { // userId : 채팅 신청한 사람

    // 채팅방 아이디 : userId + recruitId
    Long chatRoomId = Long.parseLong(userId.toString() + recruitId.toString()); // 채팅방 아이디 생성

    log.info("[createRoom] ChatRoomId : {}", chatRoomId);

    Recruit recruit = findRecruitPort.findRecruit(recruitId); // 모집 게시글 아이디 찾기
    User user = findUserPort.findUser(userId);

    ChatRoom chatRoom = ChatRoom.builder() // 채팅방 만들기
        .chatRoomId(chatRoomId)
        .recruit(recruit) // TODO 사용자도 넣어야 하나?
        .user(user)
        .build();



    saveChatRoomPort.saveChatRoom(chatRoom); // 채팅방 저장

    // 세션도 하나 만들어야함 -> 모집 게시글 올린 사람의..

    recruit.getUser().getUserId();
//    chatRooms.put(chatRoomId, chatRoom); //Rooms 에 추가

    return chatRoom;
  }

  // TALK 상태일 경우 실행
  public <T> void sendMessage(WebSocketSession session, T message) {
    try{
      // 해당 메시지를 WebSocket Session 에 보냄
      session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
  }
}
