package com.swulab.eatswunee.domain.chatroom.adapter.out.persistence;

import com.swulab.eatswunee.domain.chatroom.adapter.out.persistence.jap.ChatRoomJpaRepository;
import com.swulab.eatswunee.domain.chatroom.adapter.out.persistence.jap.model.ChatRoomJpaEntity;
import com.swulab.eatswunee.domain.chatroom.application.port.in.FindChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.application.port.in.SaveChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import com.swulab.eatswunee.domain.chatroom.exception.NotFoundChatRoomException;
import com.swulab.eatswunee.global.error.ErrorCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ChatRoomPersistenceAdapter implements FindChatRoomPort, SaveChatRoomPort {

  private final ChatRoomJpaRepository chatRoomJpaRepository;
  private final ChatRoomMapper chatRoomMapper;


  @Override
  public ChatRoom findChatRoomById(Long chatRoomId) {
    ChatRoomJpaEntity chatRoomJpaEntity = chatRoomJpaRepository.findById(chatRoomId)
        .orElseThrow(() -> new NotFoundChatRoomException(
            ErrorCode.CHATROOM_NOT_FOUND, "[chatRoomId] : " + chatRoomId + "인 채팅방이 존재하지 않습니다."));

    return chatRoomMapper.mapToDomainEntity(chatRoomJpaEntity);
  }

  @Override
  public List<ChatRoom> findAllChatRooms() {
    List<ChatRoomJpaEntity> chatRoomJpaEntities = chatRoomJpaRepository.findAll();
    return chatRoomJpaEntities.stream()
        .map(chatRoomMapper::mapToDomainEntity).toList();
  }

  @Override
  public Long saveChatRoom(ChatRoom chatRoom) {
    ChatRoomJpaEntity chatRoomJpaEntity = chatRoomMapper.mapToJpaEntity(chatRoom);
    log.info("[ChatRoomPersistenceAdapter] chatRoomId : {}", chatRoomJpaEntity.getChatRoomId());

    ChatRoomJpaEntity save = chatRoomJpaRepository.save(chatRoomJpaEntity);
    return save.getChatRoomId();
  }
}