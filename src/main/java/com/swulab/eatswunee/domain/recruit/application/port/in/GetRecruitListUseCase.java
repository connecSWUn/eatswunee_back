package com.swulab.eatswunee.domain.recruit.application.port.in;

import com.swulab.eatswunee.domain.recruit.application.port.in.command.RecruitListCommand;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import java.util.List;

public interface GetRecruitListUseCase {

  List<Recruit> getRecruitList(RecruitListCommand command);

}
