package com.swulab.eatswunee.chatroom.adapter.out.persistence.jap.model;

import com.swulab.eatswunee.recruit.adapter.out.persistence.jpa.model.RecruitJpaEntity;
import com.swulab.eatswunee.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "chat_room")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoomJpaEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long chatRoomId;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserJpaEntity userJpaEntity;

  @ManyToOne
  @JoinColumn(name = "recruit_id")
  private RecruitJpaEntity recruitJpaEntity;

  @Builder
  public ChatRoomJpaEntity(Long chatRoomId,
      UserJpaEntity userJpaEntity,
      RecruitJpaEntity recruitJpaEntity) {
    this.chatRoomId = chatRoomId;
    this.userJpaEntity = userJpaEntity;
    this.recruitJpaEntity = recruitJpaEntity;
  }
}
