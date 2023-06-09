package com.swulab.eatswunee.domain.user.application.port.in;

import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import com.swulab.eatswunee.domain.user.application.port.out.command.WriteListCommand;

public interface GetWriteListUseCase {

  WriteListCommand getWriteList(Long userId, RecruitStatus recruitStatus);

}
