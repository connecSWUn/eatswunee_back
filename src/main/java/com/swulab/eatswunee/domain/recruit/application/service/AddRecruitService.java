package com.swulab.eatswunee.domain.recruit.application.service;

import com.swulab.eatswunee.domain.recruit.adapter.in.web.dto.request.AddRecruitRequest;
import com.swulab.eatswunee.domain.recruit.application.port.in.AddRecruitUseCase;
import com.swulab.eatswunee.domain.recruit.application.port.in.command.AddRecruitCommand;
import com.swulab.eatswunee.domain.recruit.application.port.out.SaveRecruitPort;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.recruit.domain.model.RecruitStatus;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddRecruitService implements AddRecruitUseCase {

  private final SaveRecruitPort saveRecruitPort;
  private final FindUserPort findUserPort;


  @Override
  public Long addRecruit(AddRecruitCommand command) {

    User user = findUserPort.findUser(command.getWriter_id());
    Recruit newRecruit = createRecruit(command, user);

    return saveRecruitPort.saveRecruit(newRecruit);
  }


  private Recruit createRecruit(AddRecruitCommand command, User user) {
    return Recruit.builder()
        .title(command.getTitle())
        .content(command.getContent())
        .createdAt(LocalDateTime.now())
        .status(RecruitStatus.ONGOING)
        .restaurant(command.getSpot())
        .startTime(command.getStart_time())
        .endTime(command.getEnd_time())
        .user(user)
        .build();
  }




}
