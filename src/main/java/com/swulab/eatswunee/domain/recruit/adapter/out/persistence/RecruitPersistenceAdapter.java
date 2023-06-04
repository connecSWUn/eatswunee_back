package com.swulab.eatswunee.domain.recruit.adapter.out.persistence;

import com.swulab.eatswunee.domain.recruit.adapter.out.persistence.jpa.model.RecruitJpaEntity;
import com.swulab.eatswunee.domain.recruit.application.port.out.DeleteRecruitPort;
import com.swulab.eatswunee.domain.recruit.application.port.out.ExistRecruitPort;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitContentPort;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitListPort;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitPort;
import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitsPortByUserIdPort;
import com.swulab.eatswunee.domain.recruit.application.port.out.SaveRecruitPort;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import com.swulab.eatswunee.domain.recruit.exception.RecruitNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class RecruitPersistenceAdapter implements FindRecruitListPort, FindRecruitContentPort,
    SaveRecruitPort, DeleteRecruitPort, ExistRecruitPort, FindRecruitPort,
    FindRecruitsPortByUserIdPort {

  private final RecruitQueryRepository recruitQueryRepository;
  private final RecruitJpaRepository recruitJpaRepository;
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

  @Override
  public Long saveRecruit(Recruit recruit) {
    RecruitJpaEntity recruitJpaEntity = recruitMapper.mapToJpaEntity(recruit);
    return recruitJpaRepository.saveAndFlush(recruitJpaEntity).getRecruitId();
  }

  @Override
  public void deleteRecruit(Long recruitId) {
    recruitJpaRepository.deleteById(recruitId);
  }

  @Override
  public Boolean existRecruit(Long recruitId) {
    return recruitJpaRepository.existsById(recruitId);
  }

  public Recruit findRecruit(Long recruitId) {
    RecruitJpaEntity recruitJpaEntity = recruitJpaRepository.findById(recruitId)
        .orElseThrow(() -> new RecruitNotFoundException("아이디가 " + recruitId + "인 게시글이 존재하지 않습니다."));

    return recruitMapper.mapToDomainEntity(recruitJpaEntity);
  }

  @Override
  public List<Recruit> findRecruitsPortByUserId(Long userId, RecruitStatus recruitStatus) {
    return recruitQueryRepository.findRecruitListByUserId(userId, recruitStatus);
  }
}
