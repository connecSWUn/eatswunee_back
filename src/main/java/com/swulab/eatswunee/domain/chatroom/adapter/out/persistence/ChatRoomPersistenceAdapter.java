package com.swulab.eatswunee.domain.chatroom.adapter.out.persistence;

import com.swulab.eatswunee.domain.chatroom.adapter.in.web.controller.command.UserChatRoomCommand;
import com.swulab.eatswunee.domain.chatroom.adapter.out.persistence.jap.ChatRoomJpaRepository;
import com.swulab.eatswunee.domain.chatroom.adapter.out.persistence.jap.model.ChatRoomJpaEntity;
import com.swulab.eatswunee.domain.chatroom.application.port.out.ExistChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindChatMessagesPort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindRecruitChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.FindUserChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.SaveChatRoomPort;
import com.swulab.eatswunee.domain.chatroom.application.port.out.command.FindChatMessageCommand;
import com.swulab.eatswunee.domain.chatroom.domain.model.ChatRoom;
import com.swulab.eatswunee.domain.chatroom.exception.NotFoundChatRoomException;
import com.swulab.eatswunee.global.error.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ChatRoomPersistenceAdapter implements FindChatRoomPort, SaveChatRoomPort,
    ExistChatRoomPort, FindChatMessagesPort, FindUserChatRoomPort, FindRecruitChatRoomPort {

  private final ChatRoomJpaRepository chatRoomJpaRepository;
  private final ChatRoomQueryRepository chatRoomQueryRepository;
  private final ChatRoomMapper chatRoomMapper;


  @Override
  public ChatRoom findChatRoomById(String chatRoomId) {
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
  public String saveChatRoom(ChatRoom chatRoom) {
    ChatRoomJpaEntity chatRoomJpaEntity = chatRoomMapper.mapToJpaEntity(chatRoom);
    log.info("[ChatRoomPersistenceAdapter] chatRoomId : {}", chatRoomJpaEntity.getChatRoomId());

    ChatRoomJpaEntity save = chatRoomJpaRepository.save(chatRoomJpaEntity);
    return save.getChatRoomId();
  }

  @Override
  public Boolean existChatRoomByChatRoomId(String chatRoomId) {
    return chatRoomJpaRepository.existsById(chatRoomId);
  }

  @Override
  public List<FindChatMessageCommand> findChatMessages(String chatRoomId) {
    Optional<List<FindChatMessageCommand>> optionalCommand = chatRoomQueryRepository.findChatRoomMessages(
        chatRoomId);
    List<FindChatMessageCommand> commands = optionalCommand.orElse(new ArrayList<>());
    return commands;
  }

  @Override
  public List<UserChatRoomCommand> findUserChatRoom(Long userId) {
    return chatRoomQueryRepository.findUserChatRoom(userId);
  }

  @Override
  public List<UserChatRoomCommand> findRecruitChatRoom(Long recruitId) {
    return chatRoomQueryRepository.findRecruitChat(recruitId);
  }

  @Override
  public Integer findRecruitChatRoomByRecruitId(Long recruitId) {
    return chatRoomQueryRepository.findRecruitChat1(recruitId).size();
  }

}
