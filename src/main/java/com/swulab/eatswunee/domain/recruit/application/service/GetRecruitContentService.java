package com.swulab.eatswunee.domain.recruit.application.service;

import com.swulab.eatswunee.domain.recruit.application.port.in.GetRecruitContentUseCase;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitContentPort;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetRecruitContentService implements GetRecruitContentUseCase {

  private final FindRecruitContentPort findRecruitContentPort;

  @Override
  public Recruit getRecruitContent(Long recruitId) {
    return findRecruitContentPort.findRecruitContent(recruitId);
  }
}
