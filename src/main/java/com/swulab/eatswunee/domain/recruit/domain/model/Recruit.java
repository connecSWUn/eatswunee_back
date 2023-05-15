package com.swulab.eatswunee.domain.recruit.domain.model;

import com.querydsl.core.types.Projections;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Recruit {

  private Long recruitId;

  private String title;
  private String content;
  private LocalDateTime createdAt;
  private LocalDateTime editedAt;
  private RecruitStatus status;
  private String restaurant;
  private LocalDateTime startTime;
  private LocalDateTime endTime;

  private User user;

  @Builder
  public Recruit(Long recruitId, String title, String content, LocalDateTime createdAt,
      LocalDateTime editedAt, RecruitStatus status, String restaurant,
      LocalDateTime startTime, LocalDateTime endTime, User user) {
    this.recruitId = recruitId;
    this.title = title;
    this.content = content;
    this.createdAt = createdAt;
    this.editedAt = editedAt;
    this.status = status;
    this.restaurant = restaurant;
    this.startTime = startTime;
    this.endTime = endTime;
    this.user = user;
  }

  public Recruit(Long recruitId, String title, LocalDateTime createdAt,
      RecruitStatus status, String restaurant,
      LocalDateTime startTime, LocalDateTime endTime) {
    this.recruitId = recruitId;
    this.title = title;
    this.createdAt = createdAt;
    this.status = status;
    this.restaurant = restaurant;
    this.startTime = startTime;
    this.endTime = endTime;
  }

}
