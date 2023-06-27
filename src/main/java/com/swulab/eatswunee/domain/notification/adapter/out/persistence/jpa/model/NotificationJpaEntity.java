package com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.order.adapter.out.persistence.jpa.model.OrderJpaEntity;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import com.swulab.eatswunee.global.common.domain.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "notification")
@Getter
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "notification_id")),
    @AttributeOverride(name = "createdAt", column = @Column(name = "notification_created_at"))
})
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NotificationJpaEntity extends BaseEntity {

  private String notificationTitle;
  private String notificationContent;
  private Boolean notificationIsRead;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private OrderJpaEntity orderJpaEntity;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserJpaEntity userJpaEntity;

  public NotificationJpaEntity(Long notificationId, String notificationTitle,
      String notificationContent, Boolean notificationIsRead,
      LocalDateTime notificationCreatedAt,
      OrderJpaEntity orderJpaEntity,
      UserJpaEntity userJpaEntity) {
    super(notificationId, notificationCreatedAt);
    this.notificationTitle = notificationTitle;
    this.notificationContent = notificationContent;
    this.notificationIsRead = notificationIsRead;
    this.orderJpaEntity = orderJpaEntity;
    this.userJpaEntity = userJpaEntity;
  }
}
