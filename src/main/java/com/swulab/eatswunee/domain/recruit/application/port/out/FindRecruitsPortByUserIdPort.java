package com.swulab.eatswunee.domain.recruit.application.port.out;

import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import java.util.List;

public interface FindRecruitsPortByUserIdPort {

  List<Recruit> findRecruitsPortByUserId(Long userId, RecruitStatus recruitStatus);

}
