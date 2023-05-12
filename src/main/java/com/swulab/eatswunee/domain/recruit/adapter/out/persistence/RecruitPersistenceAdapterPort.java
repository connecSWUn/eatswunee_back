package com.swulab.eatswunee.domain.recruit.adapter.out.persistence;

import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitListPort;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RecruitPersistenceAdapterPort implements FindRecruitListPort {

  private final RecruitQueryRepository recruitQueryRepository;


  @Override
  public List<Recruit> findRecruitList() {
    return recruitQueryRepository.findRecruitList();
  }
}
