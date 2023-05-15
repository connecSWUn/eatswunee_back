package com.swulab.eatswunee.domain.recruit.adapter.out.persistence;

import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitContentPort;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitListPort;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.recruit.exception.RecruitNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RecruitPersistenceAdapter implements FindRecruitListPort, FindRecruitContentPort {

  private final RecruitQueryRepository recruitQueryRepository;
  private final RecruitMapper recruitMapper;


  @Override
  public List<Recruit> findRecruitList(String category) {
    return recruitQueryRepository.findRecruitList(category);
  }

  @Override
  public Recruit findRecruitContent(Long recruitId) {
    return recruitMapper.mapToDomainEntity(recruitQueryRepository.findRecruitContent(recruitId)
        .orElseThrow(() -> new RecruitNotFoundException("아이디가 " + recruitId + "인 게시글이 존재하지 않습니다.")));
  }
}
