package com.swulab.eatswunee.domain.chatroom.adapter.out.persistence.jap;

import com.swulab.eatswunee.domain.chatroom.adapter.out.persistence.jap.model.ChatRoomJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomJpaRepository extends JpaRepository<ChatRoomJpaEntity, String> {


}
