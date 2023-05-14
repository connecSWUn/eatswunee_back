package com.swulab.eatswunee.domain.recruit.application.port.in;

import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
public class RecruitListDto {

  @NotNull
  @NotEmpty
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

  public RecruitListDto(Long recruitId, String title, LocalDateTime createdAt,
      RecruitStatus status, String spot, LocalDateTime startTime, LocalDateTime endTime) {
    this.recruitId = recruitId;
    this.title = title;
    this.createdAt = createdAt;
    this.status = status;
    this.spot = spot;
    this.startTime = startTime;
    this.endTime = endTime;
  }
}
