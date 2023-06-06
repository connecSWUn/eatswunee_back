package com.swulab.eatswunee.domain.chatroom.adapter.out.persistence;

import static com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence.jpa.model.QChatMessageJpaEntity.chatMessageJpaEntity;
import static com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.QUserJpaEntity.userJpaEntity;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.chatroom.application.port.out.command.FindChatMessageCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatRoomQueryRepository {

  private final JPAQueryFactory jpaQueryFactory;

  public List<FindChatMessageCommand> findChatRoomMessages(Long chatRoomId) {

    return jpaQueryFactory
        .select(Projections.constructor(FindChatMessageCommand.class,
            chatMessageJpaEntity.createdAt.as("messageCreatedAt"),
            chatMessageJpaEntity.userJpaEntity.name.as("messageSender"),
            chatMessageJpaEntity.message.as("messageContent"),
            chatMessageJpaEntity.isRead.as("messageIsRead")
        ))
        .from(chatMessageJpaEntity)
        .join(chatMessageJpaEntity.userJpaEntity, userJpaEntity)
        .where(
            chatMessageJpaEntity.chatRoomJpaEntity.chatRoomId.eq(chatRoomId)
        )
        .orderBy(chatMessageJpaEntity.createdAt.asc())
        .fetch();
  }
}
