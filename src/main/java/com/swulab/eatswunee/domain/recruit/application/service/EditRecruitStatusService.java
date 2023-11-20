package com.swulab.eatswunee.domain.recruit.application.service;

import com.swulab.eatswunee.domain.recruit.application.port.in.EditRecruitStatusUseCase;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitPort;
import com.swulab.eatswunee.domain.recruit.application.port.out.SaveRecruitPort;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditRecruitStatusService implements EditRecruitStatusUseCase {

  private final SaveRecruitPort saveRecruitPort;
  private final FindRecruitPort findRecruitPort;


  @Override
  public RecruitStatus editRecruitStatus(Long recruitId, RecruitStatus recruitStatus) {
    Recruit recruit = findRecruitPort.findRecruit(recruitId);
    recruit.changeRecruitStatus(recruitStatus);
    saveRecruitPort.saveRecruit(recruit);
    return recruit.getStatus();
  }

  @Override
  public String editRecruitContent(Long recruitId, String recruitStatus) {

    Recruit recruit = findRecruitPort.findRecruit(recruitId);
    recruit.changeRecruitContent(recruitStatus);

    return recruit.getContent();
  }
}
