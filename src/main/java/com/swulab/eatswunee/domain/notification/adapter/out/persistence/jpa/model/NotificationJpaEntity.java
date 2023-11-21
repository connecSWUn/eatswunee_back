package com.swulab.eatswunee.domain.notification.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.notification.domain.model.NotificationCategory;
import com.swulab.eatswunee.global.common.domain.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "notification_type")
public class NotificationJpaEntity extends BaseEntity {

  private String notificationTitle;
  private String notificationContent;
  private Boolean notificationIsRead;

  @Enumerated(EnumType.STRING)
  private NotificationCategory notificationCategory;

  public NotificationJpaEntity(Long notificationId, String notificationTitle,
      String notificationContent, Boolean notificationIsRead,
      LocalDateTime notificationCreatedAt) {
    super(notificationId, notificationCreatedAt);
    this.notificationTitle = notificationTitle;
    this.notificationContent = notificationContent;
    this.notificationIsRead = notificationIsRead;
  }
}
