package com.swulab.eatswunee.domain.chatmessage.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.chatroom.adapter.out.persistence.jap.model.ChatRoomJpaEntity;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import com.swulab.eatswunee.global.common.domain.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "chat_message")
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "chat_message_id")),
    @AttributeOverride(name = "createdAt", column = @Column(name = "created_at"))
})
public class ChatMessageJpaEntity extends BaseEntity {

  private String message;

  @Column(nullable = false)
  @ColumnDefault("false")
  private Boolean isRead;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserJpaEntity userJpaEntity;

  @ManyToOne
  @JoinColumn(name = "chat_room_id")
  private ChatRoomJpaEntity chatRoomJpaEntity;


  public ChatMessageJpaEntity(Long chatMessageId, String message, Boolean isRead,
      LocalDateTime createdAt,
      UserJpaEntity userJpaEntity,
      ChatRoomJpaEntity chatRoomJpaEntity) {
    super(chatMessageId, createdAt);
    this.message = message;
    this.isRead = isRead;
    this.userJpaEntity = userJpaEntity;
    this.chatRoomJpaEntity = chatRoomJpaEntity;
  }
}
