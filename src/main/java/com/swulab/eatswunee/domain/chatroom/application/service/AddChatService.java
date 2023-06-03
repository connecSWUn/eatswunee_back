package com.swulab.eatswunee.domain.chatroom.application.service;

import com.swulab.eatswunee.domain.chatroom.application.port.in.AddChatRoomUseCase;
import com.swulab.eatswunee.domain.chatroom.application.port.out.SaveChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitPort;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.domain.user.domain.model.User;
import jakarta.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AddChatService implements AddChatRoomUseCase {

  private Map<Long, ChatRoom> chatRooms; // chatId를 key로 갖고 ChatRoom을 value로 갖는 Map
  private final FindRecruitPort findRecruitPort;
  private final SaveChatRoomPort saveChatRoomPort;
  private final FindUserPort findUserPort;

  @PostConstruct
  private void init() {
    chatRooms = new LinkedHashMap<>();
  }

  @Override
  public ChatRoom createRoom(Long userId, Long recruitId) { // userId : 채팅 신청한 사람

    ChatRoom chatRoom = createChatRoom(userId, recruitId);

    saveChatRoomPort.saveChatRoom(chatRoom); // 채팅방 저장
    chatRooms.put(chatRoom.getChatRoomId(), chatRoom);

    return chatRoom;
  }

  /**
   * userId + 0 + recruitId 를 chatRoomId로 갖는 chatRoom 생성
   * @param recruitId  게시글 아이디
   * @param userId 채팅방 입장한 사람 아이디
   * @return userId + 0 + recruitId 를 chatRoomId로 갖는 chatRoom
   */
  private ChatRoom createChatRoom(Long userId, Long recruitId) {

    Long chatRoomId = Long.parseLong(userId.toString() + "0" + recruitId.toString()); // 채팅방 아이디 생성

    Recruit recruit = findRecruitPort.findRecruit(recruitId); // 모집 게시글 아이디 찾기
    User user = findUserPort.findUser(userId);

    return ChatRoom.builder() // 채팅방 만들기
        .chatRoomId(chatRoomId)
        .recruit(recruit)
        .user(user)
        .build();
  }
}
