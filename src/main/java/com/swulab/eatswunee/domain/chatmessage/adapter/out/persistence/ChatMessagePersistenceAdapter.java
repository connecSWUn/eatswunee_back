package com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence;

import com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence.jpa.ChatMessageJpaRepository;
import com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence.jpa.model.ChatMessageJpaEntity;
import com.swulab.eatswunee.domain.chatmessage.application.port.out.SaveChatMessagePort;
import com.swulab.eatswunee.domain.chatmessage.domain.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatMessagePersistenceAdapter implements SaveChatMessagePort {

  private final ChatMessageMapper chatMessageMapper;
  private final ChatMessageJpaRepository chatMessageJpaRepository;


  @Override
  public Long saveChatMessage(ChatMessage chatMessage) {
    ChatMessageJpaEntity chatMessageJpaEntity = chatMessageMapper.mapToJpaEntity(chatMessage);
    ChatMessageJpaEntity savedChatMessage = chatMessageJpaRepository.save(chatMessageJpaEntity);
    return savedChatMessage.getChatMessageId();
  }
}
