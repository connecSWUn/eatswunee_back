package com.swulab.eatswunee.domain.recruit.application.port.in;

import com.swulab.eatswunee.domain.recruit.application.port.in.command.RecruitListCommand;
import java.util.List;

public interface GetRecruitListUseCase {

  List<RecruitListDto>  getRecruitList(RecruitListCommand command);

}
