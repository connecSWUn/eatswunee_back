package com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.request;

import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EditRecruitStatusRequest {

  private Long recruitId;
  private RecruitStatus recruitStatus;

  public EditRecruitStatusRequest(Long recruitId,
      RecruitStatus recruitStatus) {
    this.recruitId = recruitId;
    this.recruitStatus = recruitStatus;
  }
}
