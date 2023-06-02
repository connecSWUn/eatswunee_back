package com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence.jpa;

import com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence.jpa.model.ChatMessageJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageJpaRepository extends JpaRepository<ChatMessageJpaEntity, Long> {

}
