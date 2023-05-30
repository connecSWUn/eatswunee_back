package com.swulab.eatswunee.domain.review.application.service;

import com.swulab.eatswunee.domain.review.application.port.in.GetUserReviewListUseCase;
import com.swulab.eatswunee.domain.review.application.port.in.command.GetUserReviewCommand;
import com.swulab.eatswunee.domain.review.application.port.out.FindUserReviewListPort;
import com.swulab.eatswunee.domain.review.application.port.out.command.FindUserReviewCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserReviewListService implements GetUserReviewListUseCase {

  private final FindUserReviewListPort findUserReviewListPort;

  @Override
  public List<GetUserReviewCommand> getUserReviewList(Long userId) {

    List<FindUserReviewCommand> commands = findUserReviewListPort.findUserReviewList(userId);
    return commands.stream().map(GetUserReviewCommand::new).toList();
  }
}
