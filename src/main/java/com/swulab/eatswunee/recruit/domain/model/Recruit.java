package com.swulab.eatswunee.recruit.domain.model;

import com.swulab.eatswunee.user.domain.model.User;
import java.time.LocalDate;
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
  private LocalDate days;

  private User user;

  @Builder
  public Recruit(Long recruitId, String title, String content, LocalDateTime createdAt,
      LocalDateTime editedAt, RecruitStatus status, String restaurant, LocalDate days,
      User user) {
    this.recruitId = recruitId;
    this.title = title;
    this.content = content;
    this.createdAt = createdAt;
    this.editedAt = editedAt;
    this.status = status;
    this.restaurant = restaurant;
    this.days = days;
    this.user = user;
  }
}
