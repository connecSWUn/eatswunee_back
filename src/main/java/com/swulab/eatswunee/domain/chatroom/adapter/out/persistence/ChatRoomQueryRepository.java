package com.swulab.eatswunee.domain.chatroom.adapter.out.persistence;

import static com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence.jpa.model.QChatMessageJpaEntity.chatMessageJpaEntity;
import static com.swulab.eatswunee.domain.chatroom.adapter.out.persistence.jap.model.QChatRoomJpaEntity.chatRoomJpaEntity;
import static com.swulab.eatswunee.domain.recruit.adapter.out.persistence.jpa.model.QRecruitJpaEntity.recruitJpaEntity;
import static com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.QUserJpaEntity.userJpaEntity;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller.command.UserChatRoomCommand;
import com.swulab.eatswunee.domain.chatroom.application.port.out.command.FindChatMessageCommand;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatRoomQueryRepository {

  private final JPAQueryFactory jpaQueryFactory;

  public Optional<List<FindChatMessageCommand>> findChatRoomMessages(String chatRoomId) {

    return Optional.of(jpaQueryFactory
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
        .fetch());
  }

  public List<UserChatRoomCommand> findUserChatRoom(Long userId) { // 내가 보낸 것

    return jpaQueryFactory
        .select(Projections.constructor(UserChatRoomCommand.class,
            chatRoomJpaEntity.chatRoomId,
            chatRoomJpaEntity.recruitJpaEntity.title.as("recruitTitle"),
            chatRoomJpaEntity.userJpaEntity.name.as("senderNickname"),
            chatRoomJpaEntity.userJpaEntity.profileUrl.as("senderProfileImgUrl")
        ))
        .from(chatRoomJpaEntity)
        .join(chatRoomJpaEntity.recruitJpaEntity, recruitJpaEntity)
        .where(
            recruitJpaEntity.userJpaEntity.id.eq(userId)
        )
        .fetch();
  }

  public List<UserChatRoomCommand> findRecruitChat(Long userId) {

    return jpaQueryFactory
        .select(Projections.constructor(UserChatRoomCommand.class,
            chatRoomJpaEntity.chatRoomId,
            chatRoomJpaEntity.recruitJpaEntity.title.as("recruitTitle"),
            chatRoomJpaEntity.recruitJpaEntity.userJpaEntity.name.as("senderNickname"),
            chatRoomJpaEntity.userJpaEntity.profileUrl.as("senderProfileImgUrl")
        ))
        .from(chatRoomJpaEntity)
        .join(chatRoomJpaEntity.recruitJpaEntity, recruitJpaEntity)
        .where(
            chatRoomJpaEntity.chatRoomId.like(userId+"%")
        )
        .fetch();


  }

}
