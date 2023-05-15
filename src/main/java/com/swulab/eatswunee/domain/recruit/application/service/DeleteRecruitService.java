package com.swulab.eatswunee.domain.recruit.application.service;

import com.swulab.eatswunee.domain.recruit.application.port.in.DeleteRecruitUseCase;
import com.swulab.eatswunee.domain.recruit.application.port.out.DeleteRecruitPort;
import com.swulab.eatswunee.domain.recruit.application.port.out.ExistRecruitPort;
import com.swulab.eatswunee.domain.recruit.exception.RecruitNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteRecruitService implements DeleteRecruitUseCase {


  private final DeleteRecruitPort deleteRecruitPort;
  private final ExistRecruitPort existRecruitPort;

  @Override
  public void deleteRecruit(Long recruitId) {
    if(!existRecruitPort.existRecruit(recruitId))
      throw new RecruitNotFoundException("게시글 id: "+recruitId+"가 존재하지 않습니다.");

    deleteRecruitPort.deleteRecruit(recruitId);
  }
}
