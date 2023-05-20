package com.swulab.eatswunee.domain.recruit.application.port.out;

import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;

public interface FindRecruitPort {

  Recruit findRecruit(Long recruitId);

}
