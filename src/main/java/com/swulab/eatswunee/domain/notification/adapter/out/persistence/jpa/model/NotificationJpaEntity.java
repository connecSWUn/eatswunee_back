package com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.OrderJpaEntity;
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
@Table(name = "notification")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NotificationJpaEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long notificationId;

  private String notificationTitle;
  private String notificationContent;
  private Boolean notificationIsRead;

  @CreationTimestamp
  private LocalDateTime notificationCreatedAt;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private OrderJpaEntity orderJpaEntity;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserJpaEntity userJpaEntity;

  @Builder
  public NotificationJpaEntity(Long notificationId, String notificationTitle,
      String notificationContent, Boolean notificationIsRead,
      LocalDateTime notificationCreatedAt,
      OrderJpaEntity orderJpaEntity,
      UserJpaEntity userJpaEntity) {
    this.notificationId = notificationId;
    this.notificationTitle = notificationTitle;
    this.notificationContent = notificationContent;
    this.notificationIsRead = notificationIsRead;
    this.notificationCreatedAt = notificationCreatedAt;
    this.orderJpaEntity = orderJpaEntity;
    this.userJpaEntity = userJpaEntity;
  }
}
