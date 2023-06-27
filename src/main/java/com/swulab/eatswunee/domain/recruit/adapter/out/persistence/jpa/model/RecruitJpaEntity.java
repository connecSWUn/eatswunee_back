package com.swulab.eatswunee.domain.recruit.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import com.swulab.eatswunee.global.common.domain.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "recruit")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "recruit_id")),
    @AttributeOverride(name = "createdAt", column = @Column(name = "recruit_created_at"))
})
@SuperBuilder
@Getter
public class RecruitJpaEntity extends BaseEntity {

  private String title;

  private String content;

  @UpdateTimestamp
  private LocalDateTime editedAt;

  @Enumerated(EnumType.STRING)
  private RecruitStatus status;

  private String restaurant;

  private LocalTime startTime;

  private LocalTime endTime;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserJpaEntity userJpaEntity;

  public RecruitJpaEntity(Long recruitId, String title, String content,
      LocalDateTime createdAt, LocalDateTime editedAt,
      RecruitStatus status, String restaurant,
      LocalTime startTime, LocalTime endTime,
      UserJpaEntity userJpaEntity) {
    super(recruitId, createdAt);
    this.title = title;
    this.content = content;
    this.editedAt = editedAt;
    this.status = status;
    this.restaurant = restaurant;
    this.startTime = startTime;
    this.endTime = endTime;
    this.userJpaEntity = userJpaEntity;
  }
}
