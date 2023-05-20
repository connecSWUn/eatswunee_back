package com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.response;

import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EditRecruitStatusResponse {

  private RecruitStatus recruitStatus;

  public EditRecruitStatusResponse(
      RecruitStatus recruitStatus) {
    this.recruitStatus = recruitStatus;
  }
}
