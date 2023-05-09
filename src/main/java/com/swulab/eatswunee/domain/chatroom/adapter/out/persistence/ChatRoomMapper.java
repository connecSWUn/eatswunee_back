package com.swulab.eatswunee.domain.chatroom.adapter.out.persistence;

import com.swulab.eatswunee.domain.chatroom.adapter.out.persistence.jap.model.ChatRoomJpaEntity;
import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import com.swulab.eatswunee.domain.recruit.adapter.out.persistence.RecruitMapper;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.UserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChatRoomMapper {

  private final UserMapper userMapper;
  private final RecruitMapper recruitMapper;

  public ChatRoom mapToDomainEntity(ChatRoomJpaEntity chatRoomJpaEntity) {
    return ChatRoom.builder()
        .chatRoomId(chatRoomJpaEntity.getChatRoomId())
        .createdAt(chatRoomJpaEntity.getCreatedAt())
        .user(userMapper.mapToDomainEntity(chatRoomJpaEntity.getUserJpaEntity()))
        .recruit(recruitMapper.mapToDomainEntity(chatRoomJpaEntity.getRecruitJpaEntity()))
        .build();
  }

  public ChatRoomJpaEntity mapToJpaEntity(ChatRoom chatRoom) {
    return ChatRoomJpaEntity.builder()
        .chatRoomId(chatRoom.getChatRoomId())
        .createdAt(chatRoom.getCreatedAt())
        .userJpaEntity(userMapper.mapToJpaEntity(chatRoom.getUser()))
        .recruitJpaEntity(recruitMapper.mapToJpaEntity(chatRoom.getRecruit()))
        .build();
  }

}
