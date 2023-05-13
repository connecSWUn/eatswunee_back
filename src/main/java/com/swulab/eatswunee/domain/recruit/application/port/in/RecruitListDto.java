package com.swulab.eatswunee.domain.recruit.application.port.in;

import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class RecruitListDto {

  private Long recruitId;

  private String title;
  private LocalDateTime createdAt;
  private RecruitStatus status;
  private String spot;
  private LocalDateTime startTime;
  private LocalDateTime endTime;

  public RecruitListDto(Recruit recruit) {
    this.recruitId = recruit.getRecruitId();
    this.title = recruit.getTitle();
    this.createdAt = recruit.getCreatedAt();
    this.status = recruit.getStatus();
    this.spot = recruit.getRestaurant();
    this.startTime = recruit.getStartTime();
    this.endTime = recruit.getEndTime();
  }
}
