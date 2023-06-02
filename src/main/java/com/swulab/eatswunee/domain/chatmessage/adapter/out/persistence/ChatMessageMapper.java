package com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence;

import com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence.jpa.model.ChatMessageJpaEntity;
import com.swulab.eatswunee.domain.chatmessage.domain.model.ChatMessage;
import com.swulab.eatswunee.domain.chatroom.adapter.out.persistence.ChatRoomMapper;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ChatMessageMapper {

  private final UserMapper userMapper;
  private final ChatRoomMapper chatRoomMapper;

  public ChatMessage mapToDomainEntity(ChatMessageJpaEntity chatMessageJpaEntity) {
    return ChatMessage.builder()
        .chatMessageId(chatMessageJpaEntity.getChatMessageId())
        .message(chatMessageJpaEntity.getMessage())
        .isRead(chatMessageJpaEntity.getIsRead())
        .createdAt(chatMessageJpaEntity.getCreatedAt())
        .user(userMapper.mapToDomainEntity(chatMessageJpaEntity.getUserJpaEntity()))
        .chatRoom(chatRoomMapper.mapToDomainEntity(chatMessageJpaEntity.getChatRoomJpaEntity()))
        .build();
  }

  public ChatMessageJpaEntity mapToJpaEntity(ChatMessage chatMessage) {
    return ChatMessageJpaEntity.builder()
        .chatMessageId(chatMessage.getChatMessageId())
        .message(chatMessage.getMessage())
        .isRead(chatMessage.getIsRead())
        .createdAt(chatMessage.getCreatedAt())
        .userJpaEntity(userMapper.mapToJpaEntity(chatMessage.getUser()))
        .chatRoomJpaEntity(chatRoomMapper.mapToJpaEntity(chatMessage.getChatRoom()))
        .build();
  }



}
