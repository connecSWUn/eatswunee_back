package com.swulab.eatswunee.domain.recruit.application.service;

import com.swulab.eatswunee.domain.recruit.application.port.in.GetRecruitListUseCase;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitListPort;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetRecruitListService implements GetRecruitListUseCase {

  private final FindRecruitListPort findRecruitListPort;


  @Override
  public List<Recruit> getRecruitList() {
    return findRecruitListPort.findRecruitList(); //Account 예시
  }
}
