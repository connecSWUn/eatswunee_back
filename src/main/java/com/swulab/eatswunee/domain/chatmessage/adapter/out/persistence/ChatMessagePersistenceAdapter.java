package com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence;

import com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence.jpa.ChatMessageJpaRepository;
import com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence.jpa.model.ChatMessageJpaEntity;
import com.swulab.eatswunee.domain.chatmessage.application.port.out.SaveChatMessagePort;
import com.swulab.eatswunee.domain.chatmessage.domain.model.ChatMessage;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindLastChatMessagePort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.command.LastChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatMessagePersistenceAdapter implements SaveChatMessagePort, FindLastChatMessagePort {

  private final ChatMessageMapper chatMessageMapper;
  private final ChatMessageJpaRepository chatMessageJpaRepository;
  private final ChatMessageQueryRepository chatMessageQueryRepository;


  @Override
  public Long saveChatMessage(ChatMessage chatMessage) {
    ChatMessageJpaEntity chatMessageJpaEntity = chatMessageMapper.mapToJpaEntity(chatMessage);
    ChatMessageJpaEntity savedChatMessage = chatMessageJpaRepository.save(chatMessageJpaEntity);
    return savedChatMessage.getChatMessageId();
  }

  @Override
  public LastChatMessage findLastChatMessage(Long chatRoomId) {
    return chatMessageQueryRepository.findLastChatMessage(chatRoomId);
  }
}
