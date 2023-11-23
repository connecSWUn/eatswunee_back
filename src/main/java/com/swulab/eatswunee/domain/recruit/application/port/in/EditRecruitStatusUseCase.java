package com.swulab.eatswunee.domain.recruit.application.port.in;

import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;

public interface EditRecruitStatusUseCase {

  RecruitStatus editRecruitStatus(Long recruitId, RecruitStatus recruitStatus);

  String editRecruitContent(Long recruitId, String recruitStatus);

}
