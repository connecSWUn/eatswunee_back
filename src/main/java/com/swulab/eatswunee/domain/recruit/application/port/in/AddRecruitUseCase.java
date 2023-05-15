package com.swulab.eatswunee.domain.recruit.application.port.in;

import com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.request.AddRecruitRequest;
import com.swulab.eatswunee.domain.recruit.application.port.in.command.AddRecruitCommand;

public interface AddRecruitUseCase {

  Long addRecruit(AddRecruitCommand command);

}
