package com.swulab.eatswunee.recruit.domain.model;

import com.swulab.eatswunee.user.domain.model.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

}
