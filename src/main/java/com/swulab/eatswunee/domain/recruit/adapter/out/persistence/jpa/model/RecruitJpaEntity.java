package com.swulab.eatswunee.domain.recruit.adapter.out.persistence.jpa.model;

import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import com.swulab.eatswunee.domain.user.adapter.out.persistence.jpa.model.UserJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
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
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "recruit")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RecruitJpaEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long recruitId;

  private String title;

  private String content;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime editedAt;

  @Enumerated
  private RecruitStatus status;

  private String restaurant;

  private LocalDateTime startTime;

  private LocalDateTime endTime;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserJpaEntity userJpaEntity;

  @Builder
  public RecruitJpaEntity(Long recruitId, String title, String content,
      LocalDateTime createdAt, LocalDateTime editedAt,
      RecruitStatus status, String restaurant,
      LocalDateTime startTime, LocalDateTime endTime,
      UserJpaEntity userJpaEntity) {
    this.recruitId = recruitId;
    this.title = title;
    this.content = content;
    this.createdAt = createdAt;
    this.editedAt = editedAt;
    this.status = status;
    this.restaurant = restaurant;
    this.startTime = startTime;
    this.endTime = endTime;
    this.userJpaEntity = userJpaEntity;
  }
}
