package com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence;

import static com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence.jpa.model.QChatMessageJpaEntity.chatMessageJpaEntity;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.chatroom.application.port.out.command.LastChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatMessageQueryRepository {


  private final JPAQueryFactory jpaQueryFactory;


  public LastChatMessage findLastChatMessage(String chatRoomId) {

    return jpaQueryFactory
        .select(Projections.constructor(LastChatMessage.class,
            chatMessageJpaEntity.createdAt.as("lastChatCreatedAt"),
            chatMessageJpaEntity.message.as("lastChatMessage")
            ))
        .from(chatMessageJpaEntity)
        .where(
            chatMessageJpaEntity.chatRoomJpaEntity.chatRoomId.eq(chatRoomId)
        )
        .orderBy(chatMessageJpaEntity.createdAt.desc())
        .fetchFirst();

  }

}
