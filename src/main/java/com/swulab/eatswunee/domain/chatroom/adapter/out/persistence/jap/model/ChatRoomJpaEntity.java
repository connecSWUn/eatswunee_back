package com.swulab.eatswunee.domain.chatroom.adapter.out.persistence.jap.model;

import com.swulab.eatswunee.domain.recruit.adapter.out.persistence.jpa.model.RecruitJpaEntity;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.UserJpaEntity;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "chat_room")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
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
  public ChatRoomJpaEntity(Long chatRoomId, LocalDateTime createdAt,
      UserJpaEntity userJpaEntity,
      RecruitJpaEntity recruitJpaEntity) {
    this.chatRoomId = chatRoomId;
    this.createdAt = createdAt;
    this.userJpaEntity = userJpaEntity;
    this.recruitJpaEntity = recruitJpaEntity;
  }
}
