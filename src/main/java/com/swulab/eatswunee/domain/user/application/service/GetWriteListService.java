package com.swulab.eatswunee.domain.user.application.service;

import com.swulab.eatswunee.domain.recruit.application.port.out.FindRecruitsPortByUserIdPort;
import com.swulab.eatswunee.domain.recruit.domain.model.Recruit;
import com.swulab.eatswunee.domain.user.application.port.in.GetWriteListUseCase;
import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.domain.user.application.port.out.command.WriteListCommand;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetWriteListService implements GetWriteListUseCase {
  private final FindUserPort findUserPort;
  private final FindRecruitsPortByUserIdPort findRecruitsPortByUserIdPort;


  @Override
  public WriteListCommand getWriteList(Long userId) {
    User user = findUserPort.findUser(userId);
    List<Recruit> recruitList = findRecruitsPortByUserIdPort.findRecruitsPortByUserId(userId);

    return new WriteListCommand(user.getUserId(), user.getName(), user.getProfileUrl(), recruitList);
  }
}
