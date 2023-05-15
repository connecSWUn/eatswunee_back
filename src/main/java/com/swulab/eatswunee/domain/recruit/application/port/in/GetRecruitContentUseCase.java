package com.swulab.eatswunee.domain.recruit.application.port.in;

import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;

public interface GetRecruitContentUseCase {

  Recruit getRecruitContent(Long recruitId);

}
